package avis;

import java.util.LinkedList;

import exception.BadEntry;

public class Item {
	private String titre;
	private String genre;
	private LinkedList<Review> reviews ;	

	public Item(String titre, String genre)throws BadEntry {
		if(titre==null || titre.length()<1)
			throw new BadEntry("le titre est obligatoire et contient au moins 1 caractère");
		if(genre==null)
			throw new BadEntry("le titre est obligatoire");
		this.titre = titre;
		this.genre = genre;
		reviews = new LinkedList<Review>();
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

	public LinkedList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(LinkedList<Review> reviews) {
		this.reviews = reviews;
	}

}
