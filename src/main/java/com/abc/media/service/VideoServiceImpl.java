package com.abc.media.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.media.dto.VideoDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.User;
import com.abc.media.entity.Video;
import com.abc.media.exception.ChannelNotFoundException;
import com.abc.media.exception.ResourceNotFoundException;
import com.abc.media.exception.UserNotFoundException;
import com.abc.media.exception.VideoNotFoundException;
import com.abc.media.repository.ChannelRepository;
import com.abc.media.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private ChannelRepository channelRepository;

	@Override
	public Optional<Video> getVideoById(Long id) {
		return videoRepository.findById(id);
	}

	@Override
	public Video uploadVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public List<Video> getAllVideos() {

		List<Video> video = videoRepository.findAll();
		return video;
	}

	@Override
	public void deleteVideo(Long video) throws VideoNotFoundException {
		Optional<Video> optionalVideo = videoRepository.findById(video);
		if (optionalVideo.isEmpty()) {
			throw new VideoNotFoundException("video not found with id :" + video);

		}
		videoRepository.deleteById(video);
	}

	@Override
	public List<Video> searchVideosByTitle(String title) {

		return videoRepository.findByTitle(title);
	}

	
	
	@Override
    public void saveVideo(Video video) {
          videoRepository.save(video);
    }

    @Override
    public Video likeVideo(Long id) {
          Optional<Video> optionalVideo = videoRepository.findById(id);
          if (optionalVideo.isPresent()) {
                Video video = optionalVideo.get();
                video.setLikes(video.getLikes() + 1);
                return videoRepository.save(video);
          } else {
                return null;
          }
    }

    @Override
    public Video dislikeVideo(Long id) {
          Optional<Video> optionalVideo = videoRepository.findById(id);
          if (optionalVideo.isPresent()) {
                Video video = optionalVideo.get();
                video.setDislikes(video.getDislikes() + 1);
                return videoRepository.save(video);
          } else {
                return null;
          }
    }

	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void addLikes(Long videoId) {
//		Video video =videoRepository.findById(videoId).orElseThrow(()-> new RuntimeException("Video not found"));
//		video.setLikes(video.getLikes()+1);
//		 videoRepository.save(video);
//		
//	}
//
//	@Override
//	public void addDislikes(Long videoId) {
//		Video video =videoRepository.findById(videoId).orElseThrow(()-> new RuntimeException("Video not found"));
//	    video.setDislikes(video.getDislikes()+1);
//	     videoRepository.save(video);
//		
//		
//	}

	
	@Override
	public List<Video> searchVideosByVideoId(Long videoId) {
		
		return videoRepository.findByVideoId(videoId);
	}

//	@Override
//	public Video likeVideo(Long videoId) {
//
//		Optional<Video> optionalVideo = videoRepository.findById(videoId);
//		if (optionalVideo.isPresent()) {
//			Video video = optionalVideo.get();
//			video.setLikes(video.getLikes() + 1);
////			video.setUserLiked(true); 
//			return videoRepository.save(video);
//		} else {
//			throw new RuntimeException("Video not found");
//		}
//	}
	
	@Override
	public List<Video> getVideosByVideoId(Long channelId) throws VideoNotFoundException {
		Optional<Channel> optionalChannel = channelRepository.findById(channelId);
		if (optionalChannel.isEmpty()) {
			throw new ChannelNotFoundException("There are no video with this Id :" + channelId);
		}
		Channel channel = optionalChannel.get();
		List<Video> list = videoRepository.findBychannel(channel);
		if (list.isEmpty()) {
			throw new VideoNotFoundException("There are no video for the the Id :" + channelId);
}
return list;
	}

   

//    @Override
//    public VideoDto getLikeDislikeCounts() {
//        return new VideoDto(likes, dislikes);
//    }
//
//    @Override
//    public void updateLikes(VideoDto updateLikeDislikeDto) {
//        likes = updateLikeDislikeDto.getLikes();
//    }
//
//    @Override
//    public void updateDislikes(VideoDto updateLikeDislikeDto) {
//        dislikes = updateLikeDislikeDto.getDislikes();
//    }

//    @Override
//    public void removeLike() {
//        likes -= 1;
//    }
//
//    @Override
//    public void removeDislike() {
//        dislikes -= 1;
//    }

	
//	@Override
//	public VideoDto getLikes() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	

	
}	

