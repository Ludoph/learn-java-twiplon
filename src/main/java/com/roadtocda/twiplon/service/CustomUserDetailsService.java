package com.roadtocda.twiplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Votre logique de chargement d'utilisateur depuis la base de données
        
        // Récupérez l'objet HttpSession
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        
        // Stockez l'ID utilisateur dans la session
        session.setAttribute("userId", usersService.getUser(id_user));
        
        // Créez et retournez l'objet UserDetails
        // ...
    }
}
