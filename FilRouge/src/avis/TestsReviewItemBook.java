package avis;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */
public class TestsReviewItemBook {
	 public TestsReviewItemBook(){

			SocialNetwork sn = new SocialNetwork();
			//Initialisation de la base avec 
			try {
				sn.addMember("marouan", "marouan", "profil");
				sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 250);
			} 
			catch (BadEntry e) {}
			catch (NotMember e) {}
			catch (MemberAlreadyExists e) {}
			catch (ItemBookAlreadyExists e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			///  Gestion de l'exception BadEntry

			//// Le pseudo n'est pas instancié 
			try {
				sn.reviewItemBook(null, "marouan", "Mes Souvenirs à Brest", 3, "Bon");
				System.err.println("Erreur 4.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
			} catch (BadEntry e) {} 
			catch (NotMember e) {} 
			catch (NotItem e) {}
			
			
			/// Le password n'est pas instancié
			try {
				sn.reviewItemBook("marouan", null, "Mes Souvenirs à Brest", 3, "Bon");
				System.err.println("Erreur 4.3.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
			} catch (BadEntry e) {} 
			catch (NotMember e) {} 
			catch (NotItem e) {}
			
			
			/// Le titre est non instancié
			try {
				sn.reviewItemBook("marouan", "marouan", null, 3, "Bon");
				System.err.println("Erreur 4.5.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");
				
			} catch (BadEntry e) {} 
			catch (NotMember e) {} 
			catch (NotItem e) {}
			
			/// Le titre est vide
			try {
				sn.reviewItemBook("marouan", "marouan", "", 3, "Bon");
				System.err.println("Erreur 4.7.1 : l'ajout d'une opinion dont le titre du Book est vide est accepté.");
			} catch (BadEntry e) {} 
			catch (NotMember e) {} 
			catch (NotItem e) {}
			
			/// La note est négative
			try {
				sn.reviewItemBook("marouan", "marouan", "Mes Souvenirs à Brest", -3, "Bon");
				System.err.println("Erreur 4.8.1 : l'ajout d'une opinion dont la note est négative est accepté.");
			} catch (BadEntry e) {} 
			catch (NotMember e) {}
			catch (NotItem e) {}
			
			/// Le commentaire est non instancié
			try {
				sn.reviewItemBook("marouan", "marouan", "Mes Souvenirs à Brest", 3, null);
				System.err.println("Erreur 4.9.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
			} catch (BadEntry e) {} 
			catch (NotMember e) {} 
			catch (NotItem e) {}
			

			/// Gestion de l'exception NotItem
			
			/// Le titre n'existe pas dans la liste 
			try {
				sn.reviewItemBook("marouan", "marouan", "Souvenir", 3, "Bon");
				System.err.println("Erreur 5.1.1 : l'ajout d'une opinion avec un titre différent est autorisé.");
			}
			catch (NotItem e) {	}
			catch (NotMember e) {}
			catch (BadEntry e) {}
		
			/// Gestion de l'exception NotMember

			/// Le pseudo n'existe pas dans la liste
			try {
				sn.reviewItemBook("Robin", "marouan", "Mes Souvenirs à Brest", 3, "Bon");
				System.err.println("Erreur 5.2.1 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
			}
			catch (NotMember e) {}
			catch (BadEntry e) {}
			catch (NotItem e) {}
			
			/// Le mot de passe n'est pas le bon
			try {
				sn.reviewItemBook("marouan", "salem", "Mes Souvenirs à Brest", 3, "Bon");
				System.err.println("Erreur 5.3.1 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
			}
			catch (NotMember e) {}
			catch (BadEntry e) {}
			catch (NotItem e) {}
			
			
		}

}
