package avis;

import java.util.LinkedList;

import exception.BadEntry;

public class Member  {
	private String pseudo;
	private String password;
	private String profil;
	LinkedList<Review> reviews ;
	
	
	public Member(String pseudo, String password, String profil)throws BadEntry {
		if(pseudo==null || pseudo.length()<1)
			throw new BadEntry("le pseudo est obligatoire et contient au moins 1 caractère");
		if(password==null || password.length()<4)
			throw new BadEntry("le password est obligatoire et contient au moins 4 caractères");
		if(profil==null)
			throw new BadEntry("le profil est obligatoire");
		this.pseudo = pseudo;
		this.password = password;
		this.profil = profil;
		reviews = new LinkedList<Review>();
	}
	
	
	
	public Member(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
	}



	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	
}
