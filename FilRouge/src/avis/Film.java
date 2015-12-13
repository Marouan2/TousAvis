package avis;

import exception.BadEntry;

public class Film extends Item {
	private String realisateur;
	private String scenariste;
	private int duree;

	public Film(String titre, String genre, String realisateur, String scenariste, int duree) throws BadEntry {
		super(titre, genre);
		if(realisateur==null)
			throw new BadEntry("la réalisateur est obligatoire");
		if(scenariste==null)
			throw new BadEntry("la scenariste est obligatoire");
		if(duree<0)
			throw new BadEntry("la duree doit être positive");
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
