package com.example.recitrends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recitrends.dto.TrendingRecipes;
import com.example.recitrends.enums.Difficulty;
import com.example.recitrends.services.ReciTrendsService;

@Controller
@RequestMapping("/api/recipes/trending/search")
public class ReciTrendsController {
	
	private final ReciTrendsService rts;
	
	@Autowired
	public ReciTrendsController(ReciTrendsService rts) {
		this.rts = rts;
	}
	
	@GetMapping
	public ResponseEntity<List<TrendingRecipes>> getAllTrendingRecipes(){
		
		//null meaning retrieve ALL recipes
		
		List<TrendingRecipes> trendingRecipes = rts.getTrendingRecipes(null);
		
		return new ResponseEntity<>(trendingRecipes, HttpStatus.OK);
	}
	
	@GetMapping(params = "difficulty")
	public ResponseEntity<List<TrendingRecipes>> getTrendingRecipesDifficulty(
			@RequestParam("difficulty") Difficulty diff){
		List<TrendingRecipes> trendingRecipes = rts.getTrendingRecipes(diff);
		
		return new ResponseEntity<>(trendingRecipes, HttpStatus.OK);
	}
}
