package com.abc.media.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.media.dto.ChannelDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.User;
import com.abc.media.repository.ChannelRepository;
import com.abc.media.repository.UserRepository;
import com.abc.media.service.ChannelService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ChannelRepository channelRepository;

	@PostMapping(value = "/channels", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createChannel(@ModelAttribute ChannelDto channelDTO) {
        try {
        	String contentType = channelDTO.getImage().getContentType();
            if (!contentType.equals(MediaType.APPLICATION_OCTET_STREAM_VALUE) &&
                    !(contentType.equals("image/png") || contentType.equals("image/jpg") ||
                    contentType.equals("image/jpeg"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                      .body("Only jpg,jpeg,png image are allowed.");
            }

            Channel channel = new Channel();
            channel.setChannelName(channelDTO.getChannelName());
            channel.setAbout(channelDTO.getAbout()); 
           
            channel.setDate(channelDTO.getDate());
            channel.setImage(channelDTO.getImage().getBytes());
            Optional<User> Optionaluser = userRepository.findById(channelDTO.getUserId());
            User user = Optionaluser.get();
            channel.setUser(user);
            channel = channelService.createChannel(channel);
            return ResponseEntity.ok(channel);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	@GetMapping("/channel/getByUserId/{userId}")
	public ResponseEntity<List<Channel>> fetchAppointmentById(@PathVariable("userId") Long userId) {

		List<Channel> channel = channelService.getChannelsByChannelId(userId);
		ResponseEntity<List<Channel>> responseEntity = new ResponseEntity<>(channel, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/channel/deleteByChannelId/{channelId}")
	public ResponseEntity<String> CancelAppointment(@PathVariable("channelId") Long channelId) {

		String response = channelService.deleteChannelById(channelId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;
	}

}
