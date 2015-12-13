package avis;

import java.util.LinkedList;

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
	public boolean itExists(LinkedList<Member> members){
		for (Member member : members){
			if (member.equals(this))
				return true;
		}
		return false;
	}
	public boolean badPseudo(String pseudo)
	{
		if(pseudo==""||pseudo==null)
			return true;
		return false;
	}
	
}
