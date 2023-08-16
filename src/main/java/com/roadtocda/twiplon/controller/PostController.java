package com.roadtocda.twiplon.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.model.Comment;
import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.service.CommentService;
import com.roadtocda.twiplon.service.PostService;
import com.roadtocda.twiplon.service.UsersService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("")
	public String Post(@RequestParam(name="name", required=false, defaultValue = "World")
	String name, Model model) {
		model.addAttribute("name", name);
		
		Iterable<Post> posts = postService.getPostsSortedByDateDesc();
		Map<Integer, Map<String, Long>> differencesMap = new HashMap<>();
		
		for (Post post : posts) {
			LocalDate dateCreation = post.getDatecreation().toLocalDateTime().toLocalDate();
			LocalDate aujourdhui = LocalDate.now();
			long differenceEnJours = ChronoUnit.DAYS.between(dateCreation, aujourdhui);
			
			long annee = differenceEnJours / 365;
			long mois = (differenceEnJours % 365) / 30;
			long jours = (differenceEnJours % 365) % 30;
			
			Map<String, Long> postDifferences = new HashMap<>();
	        postDifferences.put("annee", annee);
	        postDifferences.put("mois", mois);
	        postDifferences.put("jours", jours);
	        differencesMap.put(post.getIdpost(), postDifferences);
		}
		
		model.addAttribute("differencesMap", differencesMap);
		model.addAttribute("LesPosts", posts);
		
		return "index";
	}
	
	@PostMapping("/addPost")
	public String addPost(@RequestParam(name = "newPostContent") String newPostContent,
	                      @RequestParam(name = "userId") Long userId) {
	    Post newPost = new Post();
	    newPost.setContent(newPostContent);
	    newPost.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
	    
	    Users user = new Users();
	    user.setId_user(19);
	    newPost.setUser(user);
	    
	    postService.savePost(newPost);
	    
	    return "redirect:/";
	}
	/*
	@PostMapping("/addComment")
	public String addComment(@RequestParam(name = "newCommentText") String newCommentText,
	                         @RequestParam(name = "userId") Long userId,
	                         @RequestParam(name = "postId") Long postId) {
	    Comment newComment = new Comment();
	    newComment.setText(newCommentText);

	    Optional<Users> userOptional = usersService.getUser(userId);
	    if (userOptional.isPresent()) {
	        Users user = userOptional.get();
	        newComment.setUser(user);
	    } else {
	        return "redirect:/error";
	    }

	    Optional<Post> postOptional = postService.getPost(postId); 
	    if (postOptional.isPresent()) {
	        Post post = postOptional.get();
	        newComment.setPost(post);
	    } else {
	        return "redirect:/error";
	    }

	    commentService.saveComment(newComment);

	    return "redirect:/";
	}*/
	
}
