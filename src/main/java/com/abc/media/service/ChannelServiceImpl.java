package com.abc.media.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.media.dto.ChannelDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.User;
import com.abc.media.entity.Video;
import com.abc.media.exception.ChannelNotFoundException;
import com.abc.media.exception.UserNotFoundException;
import com.abc.media.repository.ChannelRepository;
import com.abc.media.repository.UserRepository;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Channel createChannel(Channel channel) {
		return channelRepository.save(channel);
	}

	@Override
	public List<Channel> getChannelsByChannelId(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("There are no channel with this Id :" + userId);
		}
		User user = optionalUser.get();
		List<Channel> list = channelRepository.findByuser(user);
		if (list.isEmpty()) {
			throw new ChannelNotFoundException("There are no channel for the the Id :" + userId);
		}

		return list;
	}
	
	@Override
	public String deleteChannelById(Long channelId) {
		Optional<Channel> optionalChannel = channelRepository.findById(channelId);

		if (optionalChannel.isEmpty()) {
			throw new ChannelNotFoundException("Id Not Exists :" + channelId);
		}

		Channel channel = optionalChannel.get();
		channelRepository.delete(channel);
		return "channel deleted ";

	}

	
}
