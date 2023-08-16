package com.roadtocda.twiplon.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.roadtocda.twiplon.service.UsersService;

@Controller
public class LoginController {

		@Autowired
		private UsersService usersService;
		
		@GetMapping("/login")
		private String showProfil() {
			return "connexion";
		}
=======
public class LoginController {

>>>>>>> refs/remotes/origin/main
}
