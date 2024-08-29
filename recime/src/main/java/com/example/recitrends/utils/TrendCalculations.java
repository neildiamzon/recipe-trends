package com.example.recitrends.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.recitrends.dto.Recipes;

public class TrendCalculations {
	
	/*
	 * Adjust targetRecencyFactor and targetDecayPeriod
	 * 
	 * this means that Engagements older than 30 days has a recencyFactor of 0.1
	 * 
	 * */
	
	private final static double targetRecencyFactor = 0.1;
	private final static int targetDecayPeriod = 30;
	
	/*
	 * Adjust the weights of each criteria (view, engagement, recency factor) 
	 * 
	 * each weight represents their importance for the trend score with the highest being 1.0
	 * 
	 * in this example view and engagement weights are equal 
	 * 
	 * and recencyFactor weight is less important
	 * 
	 * */
	private final static double viewWeight = 0.4;
	private final static double engagementWeight = 0.4;
	private final static double recencyFactorWeight = 0.2;
	
	
	public static double getLambda() {
		return -Math.log(targetRecencyFactor) / targetDecayPeriod;
	}
	
	public static double calculateRecencyFactor(Recipes recipe) {
		double v = 0.0;
		
		if (recipe.getEngagement() != null) {
			LocalDate today = LocalDate.now();
		
			long deltaTime = ChronoUnit.DAYS.between(
					recipe.getEngagement().getLastEngagement(), today);
			v = Math.exp(-getLambda()*deltaTime);
		}
		return v;
	}
	
	public static double calculateTrendScore(int views, int engagement, double recencyFactor) {
	    
		return 0.0;
	}
	
	public static <T> Number calculateNormalization(List<T> normalizeValues){
		
		
		return null;
	}
}
