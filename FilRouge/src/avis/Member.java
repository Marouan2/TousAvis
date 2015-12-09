package avis;

public class Member  {
	private String pseudo;
	private String password;
	private String profil;
	
	
	
	public Member(String pseudo, String password, String profil) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.profil = profil;
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
