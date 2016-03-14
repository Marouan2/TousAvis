package avis;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;

/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */
public class TestsAddItemBook {
	
    public TestsAddItemBook(){
		
		int nbBooks = 0;
		SocialNetwork sn = new SocialNetwork();
		//Initialisation de la liste avec 
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			nbBooks = sn.nbBooks();
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (ItemBookAlreadyExists e) {} 
		catch (MemberAlreadyExists e) {}
		
		////////////// Gestion de l'exception BadEntry		

		//// Le pseudo n'est pas instancié 
		nbBooks = sn.nbBooks();
		try {
			sn.addItemBook(null, "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 2.1.1 : l'ajout d'un Book dont le pseudo n'est pas instancié est accepté.");
			
		} catch (BadEntry e) {			
				System.err.println("Erreur 2.1.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
		  } 
		catch (NotMember e) {
			System.err.println("Erreur 2.1.3 : Exception NotMember non prévue");
			} 
		catch (ItemBookAlreadyExists e) {
			System.err.println("Erreur 2.1.4 : Exception ItemAlreadyExist non prévue");
			}
		
		/// Le pseudo a moins de 1 caractère autre que des espaces
		try {
			sn.addItemBook(" ", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 2.2.1 : l'ajout d'un Book dont le pseudo ne contient que des espaces est accepté.");
			
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.2.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
				
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/// Le password n'est pas instancié
		try {
			sn.addItemBook("marouan", "", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 2.3.1 : l'ajout d'un Book dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.3.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		
		///Le password a moins de 4 caractère autre que des espaces
		try {
			sn.addItemBook("marouan", " mar ", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 2.4.1 : l'ajout d'un Book dont le password contient moins de 4 caractères autre que des espaces est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.4.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/// Le titre est non instancié
		try {
			sn.addItemBook("marouan", "marouan", "", "roman", "bernard", 617);
			System.err.println("Erreur 2.5.1 : l'ajout d'un Book dont le titre n'est pas instancié est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.5.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		
		/// Le genre est non instancié
		try {
			sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "", "bernard", 617);
			System.err.println("Erreur 2.7.1 : l'ajout d'un Book dont le genre n'est pas instancié est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.7.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/// Le realisateur non instancié
		try {
			sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "roman", null, 617);
			System.err.println("Erreur 2.8.1 : l'ajout d'un Book dont l'auteur n'est pas instancié est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.8.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/// Le nombre de pages est négatif
		try {
			sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", -617);
			System.err.println("Erreur 2.9.1 : l'ajout d'un Book dont le nombre de pages est négatif est accepté.");
		} catch (BadEntry e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 2.9.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		} 
		catch (NotMember e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		///////////////////  Gestion de l'exception NotMember

		/// Le pseudo est inconnu 
		try {
			sn.addItemBook("Robert", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 3.1.1 : l'ajout d'un Book avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 3.1.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		}
		catch (BadEntry e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/// Le mot de passe du pseudo n'est pas le bon
		try {
			sn.addItemBook("marouan", "marou", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 3.2.1 : l'ajout d'un Book avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 3.2.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		}
		catch (BadEntry e) {} 
		catch (ItemBookAlreadyExists e) {}
		
		/////////////////// Gestion de l'exception ItemAlreadyExists

		/// Le titre existe déjà
		try {
			sn.addItemBook("marouan", "marouan", "Mes Souvenirs à Brest", "roman", "bernard", 617);
			System.err.println("Erreur 3.3.1 : l'ajout d'un Book avec un titre déjà existant est autorisé.");
		}
		catch (ItemBookAlreadyExists e) {
			if(sn.nbBooks() != nbBooks){
				System.err.println("Erreur 3.3.2 : le nombre de Book dans la liste ne doit pas changé après le refus d'ajout d'un Book dans la liste");
			}
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}

    }
    
}
