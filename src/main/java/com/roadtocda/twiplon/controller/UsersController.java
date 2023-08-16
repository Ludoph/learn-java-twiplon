package com.roadtocda.twiplon.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.service.PostService;
import com.roadtocda.twiplon.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	@Autowired PostService postService;
	
	
	@GetMapping("/Profil")
    public String Users(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
        
        // Utilisez l'ID utilisateur pour récupérer les informations du profil
        // ...
        
        // Passez les informations du profil à la vue
        model.addAttribute("userInfo", usersService.getUser(0));
        
        return "users";
    }
	
	@PostMapping("/deletePost")
	public String deletePost(@RequestParam(name = "postId") long postId) {
	    postService.deletePost(postId);
	    
	    return "redirect:/Profil?id="+19;
	}
	
}
