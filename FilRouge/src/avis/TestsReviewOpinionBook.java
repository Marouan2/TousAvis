package avis;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

public class TestsReviewOpinionBook {
	public TestsReviewOpinionBook() {
		SocialNetwork sn = new SocialNetwork();
		//Initialisation de la base avec 
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addMember("salem", "salem", "profil2");
			sn.addItemBook("marouan", "marouan", "The Legend", "roman", "bernard", 250);
			sn.addItemBook("marouan", "marouan", "Mes Souvenir à Brest", "roman", "bernard", 250);
			sn.reviewItemBook("marouan", "marouan", "The Legend", 3, "Bon");
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (NotItem e) {}
		catch (MemberAlreadyExists e) {}
		catch (ItemBookAlreadyExists e) {}

		///  Gestion de l'exception BadEntry

		//// Le pseudo n'est pas instancié 
		try {
			sn.reviewOpinionBook(null, "salem", "The Legend","marouan","Bon",2);
			System.err.println("Erreur 7.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le password n'est pas instancié
		try {
			sn.reviewOpinionBook("salem", null, "The Legend","marouan","Bon",2);
			System.err.println("Erreur 7.2.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le titre est non instancié
		try {
			sn.reviewOpinionBook("salem", "salem", null,"marouan","Bon",2);
			System.err.println("Erreur 7.3.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");

		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le titre est vide
		try {
			sn.reviewOpinionBook("salem", "salem", "","marouan","Bon",2);
			System.err.println("Erreur 7.4.1 : l'ajout d'une opinion dont le titre du Book est vide est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le commentaire est non instancié
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","marouan",null,2);
			System.err.println("Erreur 7.5.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// La note est négative
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","marouan","Bon",-2);
			System.err.println("Erreur 7.6.1 : l'ajout d'une opinion dont la note est négative est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {}
		catch (NotItem e) {}		


		/// Gestion de l'exception NotItem

		/// Le titre n'existe pas dans la liste 
		try {
			sn.reviewOpinionBook("salem", "salem", "Dragon Ball Z","marouan","Bon",2);
			System.err.println("Erreur 7.8.2 : l'ajout d'une opinion avec un titre différent est autorisé.");
		}
		catch (NotItem e) {	}
		catch (NotMember e) {}
		catch (BadEntry e) {}

		/// Gestion de l'exception NotMember

		/// Le pseudo n'existe pas dans la liste
		try {
			sn.reviewOpinionBook("Robin", "salem", "The Legend","marouan","Bon",2);
			System.err.println("Erreur 7.2.2 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le mot de passe n'est pas le bon
		try {
			sn.reviewOpinionBook("salem", "alut", "The Legend","marouan","Bon",2);
			System.err.println("Erreur 7.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le pseudo qui a noté le Book n'est pas le bon
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","Robin","Bon",2);
			System.err.println("Erreur 7.4.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

	}

}
