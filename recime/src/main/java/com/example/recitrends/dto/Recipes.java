package com.example.recitrends.dto;

import java.time.LocalDate;

import com.example.recitrends.enums.Difficulty;
import com.example.recitrends.utils.TrendCalculations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@NoArgsConstructor
@Getter
@Setter
public class Recipes {
	
	@Id
	@GeneratedValue
	@Column(name = "recipe_id")
	private Long recipeId;
	
	@Column(name = "recipe_name")
	private String recipeName;
	
	@Column(name = "date_created")
	private LocalDate dateCreated;

	@Column(name = "recipe_owner")
	private String recipeOwner;

	@Column(name = "view_count")
	private int viewCount;

	@OneToOne
	@JoinColumn(name = "engagement_id")
	private Engagement engagement;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "difficulty")
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	@Transient
	private int engagementCount;
	
	@Transient
	private double recencyFactor;
	
	@PostLoad
	public void setupEngagementCountAndRecencyFactor() {
		if (engagement != null) {
			this.engagementCount = engagement.getCommentCount() + 
					engagement.getLikeCount() + 
					engagement.getShareCount();
			
			this.recencyFactor = TrendCalculations.calculateRecencyFactor(this);
		}
	}
}
