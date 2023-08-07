package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.repository.CommentRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class UsersService {
		@Autowired
		private UsersRepository usersRepository;

		@Autowired
		private CommentRepository commentRepository;
		
		@Autowired
		private CommentService commentService;
		
		
		public Optional<Users>getUser(final long id ){
			return usersRepository.findById(id);
		}
		public Iterable<Users> getUsers(){
			return usersRepository.findAll();
		}

		public void deleteComment(final Long id) {
			usersRepository.deleteById(id);
		}
	

		
		
}
