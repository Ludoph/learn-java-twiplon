package com.roadtocda.twiplon.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpost;

    private String content;
    private Date datecreation;

    // Clé étrangère vers l'utilisateur qui a créé la publication
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    // Relation One-to-Many avec les likes (une publication peut avoir plusieurs likes)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Likes> likes;

    // Relation One-to-Many avec les commentaires (une publication peut avoir plusieurs commentaires)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Getters et Setters
}