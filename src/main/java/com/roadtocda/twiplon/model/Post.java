package com.roadtocda.twiplon.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="post", schema = "public")
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpost;

    private String content;
    private Timestamp datecreation;

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
    
//Constructor
    public Post() {
    }

// Getters et Setters
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Timestamp datecreation) {
		this.datecreation = datecreation;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	public List<Likes> getLikes() {
		return likes;
	}
	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

   
}