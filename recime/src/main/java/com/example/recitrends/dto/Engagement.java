package com.example.recitrends.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "engagement")
@Getter
@Setter
@NoArgsConstructor
public class Engagement {
	
	@Id
	@GeneratedValue
	@Column(name = "engagement_id")
	private Long engagementId;
	
	@Column(name = "like_count")
	private int likeCount;
	
	@Column(name = "share_count")
	private int shareCount;
	
	@Column(name = "comment_count")
	private int commentCount;
	
	@Column(name = "last_engagement")
	private LocalDate lastEngagement;
	
	public Engagement(int likeCount, int shareCount, 
			int commentCount, LocalDate lastEngagement) {
		this.likeCount = likeCount;
		this.shareCount = shareCount;
		this.commentCount = commentCount;
		this.lastEngagement = lastEngagement;
	}
}
