package com.roadtocda.twiplon.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roadtocda.twiplon.model.Users;

@Repository
public interface UserDetailsService extends CrudRepository<Users, Long> {
}