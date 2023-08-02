package com.roadtocda.twiplon.model;

import java.io.Serializable;

public class LikesId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id_user;
    private int idpost;
    
    
    // constructeur, getters et setters (à générer ou écrire manuellement)
    public LikesId() {
	}
    
    
	public int getId_user() {
		return id_user;
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
	
	
	// Assurez-vous de bien implémenter les méthodes equals() et hashCode()
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

    
}