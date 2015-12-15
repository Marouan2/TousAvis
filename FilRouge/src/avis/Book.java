package avis;

import exception.BadEntry;

public class Book extends Item {
	private String auteur;
	private int nbPages;
	
	public Book(String titre, String genre, String auteur, int nbPages) throws BadEntry {
		super(titre, genre);
		if(auteur==null)
			throw new BadEntry("la scenariste est obligatoire");
		if(nbPages<0)
			throw new BadEntry("le nombre des pages être positive");
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
	@Override
	public String toString() {
		if(getReviews().size()==0)
			return "Ce livre de"+ super.toString() + "de" + auteur +  
					"contient" + nbPages +"pages"+ "ce livre n'est pas noté";
		return "Ce livre de"+ super.toString() + "de" + auteur +  
				"contient" + nbPages +"pages"+"et de note"+super.note();
	}

}
