package com.example.recitrends.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	 * each weight represents their importance for the trend score
	 * 
	 * and sum of all weights must be equal to 1.0
	 * 
	 * in this example view and engagement weights are equal 
	 * 
	 * and recencyFactor weight is less important
	 * 
	 * 
	 * */
	
	private final static double viewWeight = 0.1;
	private final static double engagementWeight = 0.1;
	private final static double recencyFactorWeight = 0.8;
	
	
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
	
	public static double calculateTrendScore(Recipes r, 
			int highestViews, int highestEngagement, double recencyFactor) {
		double trendScore = 0;
		
		trendScore = ((r.getViewCount() / highestViews) * viewWeight) +
				((r.getEngagementCount() / highestEngagement) * engagementWeight) +
				(recencyFactor * recencyFactorWeight);
				
		
		return trendScore;
	}
}