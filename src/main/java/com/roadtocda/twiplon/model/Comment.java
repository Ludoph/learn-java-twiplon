package com.roadtocda.twiplon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(CommentId.class)
public class Comment {
    @Id
    @Column(name = "id_user")
    private int id_user;
    
    @Id
    @Column(name= " idpost")
    private int idpost;
    
    @Column(name = "text")
    private String text;
    
// Relation Many-to-One vers la publication (plusieurs commentaires sont associés à une publication)
    @ManyToOne
    @JoinColumn(name = "idpost", insertable = false, updatable = false)
    private Post post;
    
	public int getId_user() {
		return id_user;
	}
	
	@ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

// Getters et Setters (à générer ou écrire manuellement)
	public Comment() {
	}
	
	public Comment (int id_user, int idpost, String text) {
		this.id_user = id_user;
		this.idpost = idpost;
		this.text = text;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getIdpost() {
		return idpost;
	}

	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


// Autres méthodes et constructeurs si nécessaire
	@Override
	public String toString() {
		return "Comment [id_user=" + id_user + ", idpost=" + idpost + ", text=" + text + ", post=" + post + "]";
	}
}
