package com.abc.media.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class VideoDto {

//	private Long videoId;

	private String title;

	private String description;

	private MultipartFile videoFile;

	

//	public VideoDto(int likes, int dislikes) {
//		super();
//		this.likes = likes;
//		this.dislikes = dislikes;
//	}

	public MultipartFile getVideoFile() {
		return videoFile;
	}

	public void setVideoFile(MultipartFile videoFile) {
		this.videoFile = videoFile;
	}

//	public int getLikes() {
//		return likes;
//	}
//
//	public void setLikes(int likes) {
//		this.likes = likes;
//	}
//
//	public int getDislikes() {
//		return dislikes;
//	}
//
//	public void setDislikes(int dislikes) {
//		this.dislikes = dislikes;
//	}

	private Long channelId;
	
	private Long userId;
	
//	private int likes;
//
//	private int dislikes;

//	private LocalDateTime createdAt;

	

	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}


}