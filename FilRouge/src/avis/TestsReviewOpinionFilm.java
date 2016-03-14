package avis;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

public class TestsReviewOpinionFilm {

	public TestsReviewOpinionFilm() {
		SocialNetwork sn = new SocialNetwork();
		//Initialisation de la base avec 
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addMember("salem", "salem", "profil2");
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			sn.addItemFilm("marouan", "marouan", "Bruce Lee", "Art Martiaux", "realisateur2", "scenariste2", 80);
			sn.reviewItemFilm("marouan", "marouan", "Ninja", 3, "Bon");
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (NotItem e) {}
		catch (MemberAlreadyExists e) {}
		catch (ItemFilmAlreadyExists e) {}

		///  Gestion de l'exception BadEntry

		//// Le pseudo n'est pas instancié 
		try {
			sn.reviewOpinionFilm(null, "salem", "Ninja","marouan","Bon",2);
			System.err.println("Erreur 6.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le password n'est pas instancié
		try {
			sn.reviewOpinionFilm("salem", null, "Ninja","marouan","Bon",2);
			System.err.println("Erreur 6.3.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le titre est non instancié
		try {
			sn.reviewOpinionFilm("salem", "salem", null,"marouan","Bon",2);
			System.err.println("Erreur 6.5.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");

		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le titre est vide
		try {
			sn.reviewOpinionFilm("salem", "salem", "","marouan","Bon",2);
			System.err.println("Erreur 6.6.1 : l'ajout d'une opinion dont le titre du Film est vide est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le commentaire est non instancié
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","marouan",null,2);
			System.err.println("Erreur 6.7.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// La note est négative
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","marouan","Bon",-2);
			System.err.println("Erreur 6.8.1 : l'ajout d'une opinion dont la note est négative est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {}
		catch (NotItem e) {}		


		/// Gestion de l'exception NotItem

		/// Le titre n'existe pas dans la liste 
		try {
			sn.reviewOpinionFilm("salem", "salem", "Dragon Ball Z","marouan","Bon",2);
			System.err.println("Erreur 6.1.2 : l'ajout d'une opinion avec un titre différent est autorisé.");
		}
		catch (NotItem e) {	}
		catch (NotMember e) {}
		catch (BadEntry e) {}

		/// Gestion de l'exception NotMember

		/// Le pseudo n'existe pas dans la liste
		try {
			sn.reviewOpinionFilm("Robin", "salem", "Ninja","marouan","Bon",2);
			System.err.println("Erreur 6.2.2 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le mot de passe n'est pas le bon
		try {
			sn.reviewOpinionFilm("salem", "alut", "Ninja","marouan","Bon",2);
			System.err.println("Erreur 6.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le pseudo qui a noté le film n'est pas le bon
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","Robin","Bon",2);
			System.err.println("Erreur 6.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

	}


}
