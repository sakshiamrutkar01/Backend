package com.abc.media.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.abc.media.controller.ChannelController;
import com.abc.media.dto.ChannelDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.User;
import com.abc.media.repository.ChannelRepository;
import com.abc.media.repository.UserRepository;
import com.abc.media.service.ChannelService;

@WebMvcTest(ChannelController.class)
public class ChannelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ChannelService channelService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ChannelRepository channelRepository;

    @InjectMocks
    private ChannelController channelController;

    @Test
    public void testCreateChannel() throws Exception {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setChannelName("Test Channel");
        channelDto.setAbout("This is a test channel.");
        channelDto.setDate(LocalDate.now());
        channelDto.setUserId(1L);
        MockMultipartFile image = new MockMultipartFile("image", "test.jpg", "image/jpeg", "test image content".getBytes());
        channelDto.setImage(image);

        User user = new User();
        user.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Channel channel = new Channel();
        channel.setChannelId(1L);
        channel.setChannelName("Test Channel");
        channel.setAbout("This is a test channel.");
        channel.setDate(LocalDate.now());
        channel.setImage(image.getBytes());
        channel.setUser(user);

        when(channelService.createChannel(channel)).thenReturn(channel);

        ResponseEntity<?> response = channelController.createChannel(channelDto);

        // Verify that the response status code is 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify that the response body contains the expected channel
        assertEquals(channel, response.getBody());
    }

}
