package com.roadtocda.twiplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Likes;
import com.roadtocda.twiplon.repository.LikesRepository;
import com.roadtocda.twiplon.repository.PostRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikesRepository likesRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	
	public void likeSave(int id_user, int idpost) {
		Likes likeSaved = new Likes(id_user, idpost);
		likesRepository.save(likeSaved);
	}
	
	public long countLikesByPostId(Long idpost) {
		return likesRepository.countByIdpost(idpost);
	}
}
