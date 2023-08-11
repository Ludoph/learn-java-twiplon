package com.roadtocda.twiplon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.roadtocda.twiplon.model.Users;
import com.roadtocda.twiplon.repository.UserDetailsService;

public class CustomUserDetailsService  {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private UsersService usersService;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOptional = usersService.getUserByUsername(username);
        
        Users user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));
        
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), // Nom d'utilisateur
            user.getPassword(), // Mot de passe (crypté)
            new ArrayList<>() // Liste des rôles / autorisations (à implémenter)
        );
    }rm
}
