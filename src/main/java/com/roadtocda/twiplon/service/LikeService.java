package com.roadtocda.twiplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Likes;
import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.repository.LikesRepository;
import com.roadtocda.twiplon.repository.PostRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikesRepository likeRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	
	public Likes likePost(Likes Likes) {
		Likes likePost = likeRepository.save(Likes);
		return likePost;
	}
	
	
	public LikesRepository getLikeRepository() {
		return likeRepository;
	}

	public void setLikeRepository(LikesRepository likeRepository) {
		this.likeRepository = likeRepository;
	}

	public UsersRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PostRepository getPostRepository() {
		return postRepository;
	}

	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
}
