package com.example.recitrends.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recitrends.dto.Recipes;
import com.example.recitrends.dto.TrendingRecipes;
import com.example.recitrends.enums.Difficulty;
import com.example.recitrends.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReciTrendsService {
	
	private final RecipeRepository rr;
	
	@Autowired
	public ReciTrendsService(RecipeRepository rr) {
		this.rr = rr;
	}
	
	private List<Recipes> retrieveRecipesByDifficulty(Difficulty d) {
		if(d == null) {
			log.info("Getting ALL Trending Recipes.");
			return rr.findAll();
		} else {
			log.info("Getting Trending Recipes based on Difficulty: {}", d.name());
			return rr.findByDifficulty(d);
		}
	}
	
	public List<TrendingRecipes> getTrendingRecipes(Difficulty d) {
		List<Recipes> allRecipes = retrieveRecipesByDifficulty(d);
		
		Optional<Recipes> highestView = allRecipes
				.stream()
				.max(Comparator.comparingInt(Recipes::getViewCount));
		
		Optional<Recipes> highestEngagement = allRecipes
				.stream()
				.max(Comparator.comparingInt(Recipes::getEngagementCount));
		
		log.info("Recipe: {} has the highest View in list: {}", 
				highestView.get().getRecipeName(),
				highestView.get().getViewCount());

		log.info("Recipe: {} has the highest Engagement in list: {}",
				highestEngagement.get().getRecipeName(),
				highestEngagement.get().getEngagementCount());
		
		List<TrendingRecipes> tr = allRecipes
				.stream()
				.map(recipes -> new TrendingRecipes(
						recipes,
						highestView.get().getViewCount(),
						highestEngagement.get().getEngagementCount()))
				.collect(Collectors.toList());
		
		/* 
		 * Sorting based on override compareTo and since the default of compareTo is from 
		 * Lowest to Highest. We need to reverse in order to get the position. with #1 being the highest
		*/
		Collections.sort(tr, Collections.reverseOrder());
		
		int counter = 0;
		
		
		for(TrendingRecipes t: tr) {
			t.setPosition(++counter);
			
			log.info("Rank#{} Recipe: {}",
					t.getPosition(),
					t.getRecipe().getRecipeName());
		}
		
		
		return tr;
	}
}
