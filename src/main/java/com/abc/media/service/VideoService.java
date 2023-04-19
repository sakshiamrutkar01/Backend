package com.abc.media.service;

import java.util.List;
import java.util.Optional;

import com.abc.media.dto.VideoDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.Video;
import com.abc.media.exception.ResourceNotFoundException;
import com.abc.media.exception.VideoNotFoundException;

public interface VideoService {

	Optional<Video> getVideoById(Long id);
	Video uploadVideo(Video video);
	List<Video> getAllVideos();
	void deleteVideo(Long videoId) throws VideoNotFoundException;
	List<Video> searchVideosByTitle(String title);
	List<Video> searchVideosByVideoId(Long VideoId);
//	void addLikes(Long id);
//	void addDislikes(Long id);
	Video likeVideo(Long videoId);
	List<Video> getVideosByVideoId(Long channelId) throws VideoNotFoundException;
//	void addDislikes(Long videoId);
//	void addLikes(Long videoId);  
//	VideoDto getLikeDislikeCounts();
//	VideoDto getLikes();
//    void updateLikes(VideoDto updateVideoDto);
//    void updateDislikes(VideoDto updateVideoDto);
//    void removeLike();
//    void removeDislike();
//	
	void saveVideo(Video video); 
	Video dislikeVideo(Long id); 
	


 
 
	

}
