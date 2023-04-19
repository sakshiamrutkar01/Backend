package com.abc.media.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abc.media.exception.ChannelNotFoundException;
import com.abc.media.exception.UserNotFoundException;
import com.abc.media.repository.ChannelRepository;
import com.abc.media.repository.UserRepository;
import com.abc.media.service.ChannelService;
import com.abc.media.service.ChannelServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abc.media.entity.Channel;
import com.abc.media.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ChannelServiceImplTest {

    @Mock
    private ChannelRepository channelRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ChannelService channelService = new ChannelServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetChannelsByChannelId_Success() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("testuser");

        List<Channel> channels = new ArrayList<>();
        Channel channel1 = new Channel();
        channel1.setChannelId(1L);
        channel1.setChannelName("Channel 1");
        channel1.setUser(user);
        Channel channel2 = new Channel();
        channel2.setChannelId(2L);
        channel2.setChannelName("Channel 2");
        channel2.setUser(user);
        channels.add(channel1);
        channels.add(channel2);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(channelRepository.findByuser(user)).thenReturn(channels);

        List<Channel> result = channelService.getChannelsByChannelId(1L);

        assertEquals(2, result.size());
        assertEquals("Channel 1", result.get(0).getChannelName());
        assertEquals("Channel 2", result.get(1).getChannelName());
    }

    @Test
    public void testGetChannelsByChannelId_UserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> channelService.getChannelsByChannelId(1L));
    }

    @Test
    public void testGetChannelsByChannelId_ChannelNotFound() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("testuser");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(channelRepository.findByuser(user)).thenReturn(new ArrayList<>());

        assertThrows(ChannelNotFoundException.class, () -> channelService.getChannelsByChannelId(1L));
    }

//    @Test
//    public void testDeleteChannelById() {
//        // Call the service method
//        channelService.deleteChannelById(1L);
//
//        // Verify that the repository method is called with the correct argument
//        verify(channelRepository, times(1)).deleteById(1L);
//    }




    @Test
    public void testDeleteChannelById_ChannelNotFound() {
        when(channelRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ChannelNotFoundException.class, () -> channelService.deleteChannelById(1L));
    }
    
    
}
