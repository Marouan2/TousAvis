package avis;

public class Book extends Item {
	private String auteur;
	private int nbPages;
	
	public Book(String pseudo, String password, String titre, String genre, String auteur, int nbPages) {
		///test modification test
		super(pseudo, password, titre, genre);
		this.auteur = auteur;
		this.nbPages = nbPages;
		
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	

}
