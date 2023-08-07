package com.roadtocda.twiplon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roadtocda.twiplon.service.LikeService;

@RestController
public class LikesController {

	@Autowired
	private LikeService likeService;
	
	@PostMapping("/like")
	public void Likes(@RequestBody Map<String, Long> requestBody) {
		Long postId = requestBody.get("postId");
		likeService.likeSave(4, postId.intValue());
	}
	
}
