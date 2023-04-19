package com.abc.media.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abc.media.dto.CommentDto;
import com.abc.media.dto.UserDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.Comment;
import com.abc.media.entity.User;
import com.abc.media.entity.Video;
import com.abc.media.repository.CommentRepository;
import com.abc.media.repository.UserRepository;
import com.abc.media.repository.VideoRepository;

//package com.abc.media.service;
//
//import java.util.List;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.abc.media.dto.CommentDto;
//import com.abc.media.entity.Comment;
//import com.abc.media.repository.CommentRepository;
//
//@Service
//public class CommentServiceImpl implements CommentService {
//	
//    private final CommentRepository commentRepository;
//	
//    private final ModelMapper modelMapper;
//    @Autowired(required=true)
//    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
//        this.commentRepository = commentRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public CommentDto createComment(CommentDto commentDto) {
//        Comment comment = modelMapper.map(commentDto, Comment.class);
//        Comment savedComment = commentRepository.save(comment);
//        return modelMapper.map(savedComment, CommentDto.class);
//    }
//
//    @Override
//    public CommentDto getCommentById(Long id) {
//        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found"));
//        return modelMapper.map(comment, CommentDto.class);
//    }
//
//    @Override
//    public CommentDto updateComment(Long id, CommentDto commentDto) {
//        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found"));
//        modelMapper.map(commentDto, comment);
//        Comment savedComment = commentRepository.save(comment);
//        return modelMapper.map(savedComment, CommentDto.class);
//    }
//
//    @Override
//    public void deleteComment(Long id) {
//        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found"));
//        commentRepository.delete(comment);
//    }
//
//	@Override
//	public List<CommentDto> getAllCommentsByVideo(Long videoId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private VideoRepository videoRepsitory;
	
	@Autowired
	private UserRepository userRepsitory;

	@Override
	public Comment addComment(Comment comment) {
		

		
		
	    return commentRepository.save(comment);
       
		
	
	}



}