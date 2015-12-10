package avis;

public class Item {
	private String pseudo;
	private String password;
private String titre;
private String genre;


public Item(String pseudo, String password, String titre, String genre) {
	this.pseudo = pseudo;
	this.password = password;
	this.titre = titre;
	this.genre = genre;
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

public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}


}
