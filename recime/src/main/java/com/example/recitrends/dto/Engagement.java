package com.example.recitrends.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "engagement")
@NoArgsConstructor
public class Engagement {
	
	@Id
	private Long id;
	
	private int likeCount;
	
	private int shareCount;
	
	private int commentCount;
	
	private Date lastEngagement;
	
	public Engagement(int likeCount, int shareCount, int commentCount, Date lastEngagement) {
		this.likeCount = likeCount;
		this.shareCount = shareCount;
		this.commentCount = commentCount;
		this.lastEngagement = lastEngagement;
	}
}
