package com.roadtocda.twiplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.repository.CommentRepository;
import com.roadtocda.twiplon.repository.LikesIdRepository;

@Service
public class UsersService {

		@Autowired
		private CommentRepository commentRepository;
		
		@Autowired
		private LikesIdRepository likesRepository;

		
		public CommentRepository getCommentRepository() {
			return commentRepository;
		}

		public void setCommentRepository(CommentRepository commentRepository) {
			this.commentRepository = commentRepository;
		}

		public LikesIdRepository getLikesRepository() {
			return likesRepository;
		}

		public void setLikesRepository(LikesIdRepository likesRepository) {
			this.likesRepository = likesRepository;
		}
		
		
}
