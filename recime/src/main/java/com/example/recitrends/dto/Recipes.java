package com.example.recitrends.dto;

import java.time.LocalDate;

import com.example.recitrends.enums.Difficulty;

import jakarta.annotation.PostConstruct;
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
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "recipes")
@NoArgsConstructor
@Getter
@Setter
@Slf4j
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
	
	@PostLoad
	public void setupEngagementCount() {
		log.info("Setting up Engagement Count");
		if (engagement != null) {
			this.engagementCount = engagement.getCommentCount() + 
					engagement.getLikeCount() + 
					engagement.getShareCount();
		}
	}
}
