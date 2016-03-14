package avis;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

public class TestsReviewItemFilm {

	public TestsReviewItemFilm() {
		SocialNetwork sn = new SocialNetwork();
		//Initialisation de la base avec 
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (MemberAlreadyExists e) {}
		catch (ItemFilmAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		///  Gestion de l'exception BadEntry

		//// Le pseudo n'est pas instancié 
		try {
			sn.reviewItemFilm(null, "marouan", "Ninja", 3, "Bon");
			System.err.println("Erreur 5.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}
		
		
		/// Le password n'est pas instancié
		try {
			sn.reviewItemFilm("marouan", null, "Ninja", 3, "Bon");
			System.err.println("Erreur 5.3.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}
		
		
		/// Le titre est non instancié
		try {
			sn.reviewItemFilm("marouan", "marouan", null, 3, "Bon");
			System.err.println("Erreur 5.5.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");
			
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}
		
		/// Le titre est vide
		try {
			sn.reviewItemFilm("marouan", "marouan", "", 3, "Bon");
			System.err.println("Erreur 5.7.1 : l'ajout d'une opinion dont le titre du Film est vide est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}
		
		/// La note est négative
		try {
			sn.reviewItemFilm("marouan", "marouan", "Ninja", -3, "Bon");
			System.err.println("Erreur 5.8.1 : l'ajout d'une opinion dont la note est négative est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {}
		catch (NotItem e) {}
		
		/// Le commentaire est non instancié
		try {
			sn.reviewItemFilm("marouan", "marouan", "Ninja", 3, null);
			System.err.println("Erreur 5.9.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}
		

		/// Gestion de l'exception NotItem
		
		/// Le titre n'existe pas dans la liste 
		try {
			sn.reviewItemFilm("marouan", "marouan", "Dragon Ball Z", 3, "Bon");
			System.err.println("Erreur 5.1.1 : l'ajout d'une opinion avec un titre différent est autorisé.");
		}
		catch (NotItem e) {	}
		catch (NotMember e) {}
		catch (BadEntry e) {}
	
		/// Gestion de l'exception NotMember

		/// Le pseudo n'existe pas dans la liste
		try {
			sn.reviewItemFilm("Robin", "marouan", "Ninja", 3, "Bon");
			System.err.println("Erreur 5.2.1 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}
		
		/// Le mot de passe n'est pas le bon
		try {
			sn.reviewItemFilm("marouan", "salem", "Ninja", 3, "Bon");
			System.err.println("Erreur 5.3.1 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}
		
		
	}

}
