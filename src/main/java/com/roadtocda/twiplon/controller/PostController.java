package com.roadtocda.twiplon.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roadtocda.twiplon.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@GetMapping("")
	public String Post(@RequestParam(name="name", required=false, defaultValue = "World")
	String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("LesPosts", postService.getPosts());
		
		LocalDate dateCreation = LocalDate.of(2023, 7, 15); 
        LocalDate aujourdhui = LocalDate.now();
	    long differenceEnJours = ChronoUnit.DAYS.between(dateCreation, aujourdhui);

	        model.addAttribute("differenceEnJours", differenceEnJours);
		return "index";
	}
}
