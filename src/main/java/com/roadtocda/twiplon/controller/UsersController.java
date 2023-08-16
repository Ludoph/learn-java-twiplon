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
	
	@GetMapping("/login")
    public String showLoginForm() {
        return "connexion";
    }
	
	@PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session) {
        Optional<Users> user = usersService.getUserByUsername(username);
        
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user.get());
            return "redirect:/Profil"; // Redirect to the home page after successful login
        } else {
            return "redirect:/login?error=true"; // Redirect to login page with error parameter
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
    
    /*
     
     @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login page view
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session) {
        Optional<Users> user = usersService.getUserByUsername(username);
        
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user.get());
            return "redirect:/home"; // Redirect to the home page after successful login
        } else {
            return "redirect:/login?error=true"; // Redirect to login page with error parameter
        }
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session) {
        Users loggedInUser = (Users) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            // Show the home page for the logged-in user
            return "home";
        } else {
            return "redirect:/login"; // Redirect to login page if not logged in
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "redirect:/login"; // Redirect to login page after logout
    }
     
     */
	
}
