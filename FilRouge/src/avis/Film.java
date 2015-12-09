package avis;

public class Film extends Item{
private String realisateur;
private String scenariste;
private int duree;

public Film(String pseudo, String password, String titre, String genre, String realisateur, String scenariste,
		int duree) {
	super(pseudo, password, titre, genre);
	this.realisateur = realisateur;
	this.scenariste = scenariste;
	this.duree = duree;
}
public String getRealisateur() {
	return realisateur;
}
public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
}
public String getScenariste() {
	return scenariste;
}
public void setScenariste(String scenariste) {
	this.scenariste = scenariste;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}
	
}
