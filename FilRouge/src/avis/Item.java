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
	public void addReview(Review review){
		reviews.add(review);
	}
	public Review getReview(Member member){
		for (Review review : reviews){
			if (review.getMember().equals(member))
				return review;
		}
		return null;
	}
	
    public float note(){
    	float note = 0;
    	for(Review review:reviews){
    		note = note +review.getNote();
    	}
    	return note/reviews.size();
    } 
    
       
	@Override
	public String toString() {
		return "Titre "+this.titre+", de genre "+this.genre+" " ;
	}

}
