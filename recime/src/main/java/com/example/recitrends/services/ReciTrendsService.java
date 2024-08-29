package com.example.recitrends.services;

import java.util.List;

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
		
		List<Recipes> r = rr.findAll();
		
		for (Recipes rs: r) {
			log.info(String.valueOf(rs.getEngagementCount()));
		}
		
		return null;
	}
	
	public List<TrendingRecipes> getTrendingRecipes(Difficulty difficulty) {
	log.info("Getting Trending Recipes based on difficulty: {}", 
			difficulty.name());
		
		return null;
	}


}
