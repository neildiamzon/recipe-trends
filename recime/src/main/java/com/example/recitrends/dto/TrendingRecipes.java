package com.example.recitrends.dto;

import com.example.recitrends.utils.TrendCalculations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TrendingRecipes implements Comparable<TrendingRecipes> {

		private Recipes recipe;
		private Double trendScore = 0.0;
		private int position;

		@Override
		public int compareTo(TrendingRecipes tr) {
			return Double.compare(this.trendScore, tr.getTrendScore());
		}
		
		public TrendingRecipes(Recipes r, int highestView, int highestEngagement) {
			recipe = r;
			trendScore = TrendCalculations.calculateTrendScore(r, 
					highestView, highestEngagement, r.getRecencyFactor());
		}
}
