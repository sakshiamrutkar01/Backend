package com.abc.media.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.abc.media.dto.ChannelDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.Video;
import com.abc.media.exception.UserNotFoundException;

public interface ChannelService {

   
	

	

	
	//ChannelDto save(ChannelDto channelDto, MultipartFile image);

	//Channel createChannel(ChannelDto channelDto) throws IOException;

	
    
	Channel createChannel(Channel channel);

	String deleteChannelById(Long channelId);

	List<Channel> getChannelsByChannelId(Long userId);



	

    

	



	







	














	

	

	


	

  

}