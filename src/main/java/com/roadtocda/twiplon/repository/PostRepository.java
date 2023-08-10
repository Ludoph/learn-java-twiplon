package com.roadtocda.twiplon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roadtocda.twiplon.model.Post;
import com.roadtocda.twiplon.model.Users;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	Iterable<Post> findAllByOrderByDatecreationDesc();
	List<Post> findByUserOrderByDatecreationDesc(Users user);
}
