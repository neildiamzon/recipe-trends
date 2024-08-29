package com.example.recitrends.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.recitrends.dto.TrendingRecipes;
import com.example.recitrends.enums.Difficulty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReciTrendsService {

	public List<TrendingRecipes> getTrendingRecipes() {
		log.info("Getting ALL Trending Recipes.");
		return null;
	}
	
	public List<TrendingRecipes> getTrendingRecipes(Difficulty difficulty) {
	log.info("Getting Trending Recipes based on difficulty: {}", 
			difficulty.name());
		
		return null;
	}


}
