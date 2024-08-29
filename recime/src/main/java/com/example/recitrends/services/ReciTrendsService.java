package com.example.recitrends.services;

import java.util.ArrayList;
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

	public List<TrendingRecipes> getTrendingRecipes() {
		log.info("Getting ALL Trending Recipes.");
		
		List<Recipes> allRecipes = rr.findAll();
		
		Optional<Recipes> highestView = allRecipes
				.stream()
				.max(Comparator.comparingInt(Recipes::getViewCount));
		
		Optional<Recipes> highestEngagement = allRecipes
				.stream()
				.max(Comparator.comparingInt(Recipes::getEngagementCount));
		
		List<TrendingRecipes> tr = allRecipes
				.stream()
				.map(recipes -> new TrendingRecipes(
						recipes,
						highestView.get().getViewCount(),
						highestEngagement.get().getEngagementCount()))
				.collect(Collectors.toList());
		
		for(TrendingRecipes t: tr) {
			log.info(String.valueOf(t.getTrendScore()));
		}
		
		
		return null;
	}
	
	public List<TrendingRecipes> getTrendingRecipes(Difficulty difficulty) {
	log.info("Getting Trending Recipes based on difficulty: {}", 
			difficulty.name());
		
		return null;
	}


}
