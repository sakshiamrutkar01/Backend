package com.abc.media.controller;


import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.media.dto.ChannelDto;
import com.abc.media.dto.CommentDto;
import com.abc.media.dto.UserDto;
import com.abc.media.entity.Channel;
import com.abc.media.entity.Comment;
import com.abc.media.entity.User;
import com.abc.media.entity.Video;
import com.abc.media.repository.UserRepository;
import com.abc.media.repository.VideoRepository;
import com.abc.media.service.ChannelService;
import com.abc.media.service.CommentService;
import com.abc.media.service.UserService;

//package com.abc.media.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.abc.media.dto.CommentDto;
//import com.abc.media.service.CommentService;
//@RestController
//@RequestMapping("/api/comment")
//public class CommentController {
//
//	@Autowired(required=true)
//	CommentService commentService;
//	@GetMapping("/comments/{commentId}")
//    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long commentId) {
//        CommentDto commentDto = commentService.getCommentById(commentId);
//        return ResponseEntity.ok(commentDto);
//
//	}
//
//    @PostMapping("/comments")
//    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
//        CommentDto savedCommentDto = commentService.createComment(commentDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentDto);
//    }
//
//    @PutMapping("/comments/{commentId}")
//    public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
//        CommentDto updatedCommentDto = commentService.updateComment(commentId, commentDto);
//        return ResponseEntity.ok(updatedCommentDto);
//    }
//
//    @DeleteMapping("/comments/{commentId}")
//    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
//        commentService.deleteComment(commentId);
//        return ResponseEntity.noContent().build();
//    }
//}
//

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @Autowired
    private VideoRepository videoRepository;
    
    @Autowired
    private UserRepository userRepository;
    
   
	@PostMapping("/comment/save")
	public ResponseEntity<Comment> add(@Valid @RequestBody CommentDto commentdto)
	{
		
//		Comment comment = commentService.addComment(commentdto);
//		ResponseEntity<Comment> responseEntity = new ResponseEntity<>(comment,HttpStatus.CREATED);
//		return responseEntity;
		try
		{
		Comment comment = new Comment();
		comment.setText(commentdto.getText());
		comment.setCreatedAt(commentdto.getCreatedAt());
		
		Optional<Video> Optionalvideo = videoRepository.findById(commentdto.getVideoId());
		Video video = Optionalvideo.get();
		comment.setVideo(video);
		
		Optional<User> Optionaluser = userRepository.findById(commentdto.getUserId());
		User user = Optionaluser.get();
		comment.setUser(user);
		 comment = commentService.addComment(comment);
         return ResponseEntity.ok(comment);
		}
		catch 
		(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
		
		
	}

    
	}
}


