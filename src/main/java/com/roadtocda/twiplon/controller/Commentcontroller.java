package com.roadtocda.twiplon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roadtocda.twiplon.service.CommentService;

@RestController
public class Commentcontroller {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/commentaire")
	public void Comments(@RequestBody Map <String, String> requestBody) {
		String commentId = requestBody.get("commentId");
		String textComment = requestBody.get("textcomment");
		commentService.commentSave(3, Integer.parseInt(commentId), textComment);
	}
}
