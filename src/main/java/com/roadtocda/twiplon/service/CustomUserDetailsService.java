package com.roadtocda.twiplon.service;

<<<<<<< HEAD
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
=======
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
>>>>>>> refs/remotes/origin/main
    }
}
