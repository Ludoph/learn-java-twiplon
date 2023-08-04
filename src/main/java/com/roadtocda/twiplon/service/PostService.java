package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.repository.CommentRepository;
import com.roadtocda.twiplon.repository.LikesRepository;
import com.roadtocda.twiplon.repository.PostRepository;
import com.roadtocda.twiplon.repository.UsersRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LikesRepository likesRepository;
	
	@Autowired 
	private CommentRepository commentRepository;
	
	
	
	public Optional<Post>getPost(final long id ){
		return postRepository.findById(id);
	}
	public Iterable<Post> getPosts(){
		return postRepository.findAll();
	}

	public void deletePost(final Long id) {
		postRepository.deleteById(id);
	}
	public Post savePost(Post Post) {
		Post savePost = postRepository.save(Post);
		return savePost;
	}

}
