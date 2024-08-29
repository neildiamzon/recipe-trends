package com.example.recitrends.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrendingRecipes implements Comparable<TrendingRecipes> {

		private Recipes recipe;
		private Double trendScore;
		

		@Override
		public int compareTo(TrendingRecipes o) {
			// TODO Auto-generated method stub
			return 0;
		}
}
