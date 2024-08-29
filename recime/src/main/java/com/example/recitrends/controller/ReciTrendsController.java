package com.example.recitrends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recitrends.dto.TrendingRecipes;
import com.example.recitrends.enums.Difficulty;
import com.example.recitrends.services.ReciTrendsService;

@Controller
@RequestMapping("/api/recipes/trending")
public class ReciTrendsController {
	
	private final ReciTrendsService rts;
	
	@Autowired
	public ReciTrendsController(ReciTrendsService rts) {
		this.rts = rts;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TrendingRecipes>> getAllTrendingRecipes(){
	
		List<TrendingRecipes> trendingRecipes = rts.getTrendingRecipes();
		
		return new ResponseEntity<>(trendingRecipes, HttpStatus.OK);
	}
	
	@GetMapping("/{diff}")
	public ResponseEntity<List<TrendingRecipes>> getTrendingRecipesDifficulty(
			@PathVariable("diff") Difficulty diff){
	
		List<TrendingRecipes> trendingRecipes = rts.getTrendingRecipes(diff);
		
		return new ResponseEntity<>(trendingRecipes, HttpStatus.OK);
	}
}
