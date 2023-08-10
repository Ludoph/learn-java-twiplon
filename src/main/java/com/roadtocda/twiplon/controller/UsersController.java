package com.roadtocda.twiplon.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.service.PostService;
import com.roadtocda.twiplon.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	@Autowired PostService postService;
	
	
	@GetMapping("/Profil")
    public String Users(@RequestParam(name="id", required = true, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        
        
        Optional<Users> userOptional = usersService.getUser(19);
        if (userOptional.isPresent()) {
        	Users user = userOptional.get();
        	model.addAttribute("user", user);
        	
        	Iterable<Post> userPosts = user.getPosts();
        	model.addAttribute("userPosts", userPosts);
        }
        return "users";
    }
	
	@PostMapping("/deletePost")
	public String deletePost(@RequestParam(name = "postId") long postId) {
	    postService.deletePost(postId);
	    
	    return "redirect:/Profil?id="+19;
	}
	
}
