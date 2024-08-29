package com.example.recitrends.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.example.recitrends.enums.Difficulty;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "Recipe")
@NoArgsConstructor
@Slf4j
public class Recipe {
	
	@Id
	private Long id;
	
	private String name;
	private Date dateCreated;
	private String Owner;
	private int viewCount;
	private Engagement engagement;
	private String imageUrl;
	private Difficulty difficulty;
	
	@Transient
	private int engagementCount;
	
	@PostConstruct
	public void setupEngagementCount() {
		log.info("Setting up Engagement Count");
		
		
	}
}
