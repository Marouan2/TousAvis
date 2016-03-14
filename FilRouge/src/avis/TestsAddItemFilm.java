package avis;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;


/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */
public class TestsAddItemFilm {

	 public TestsAddItemFilm(){
			
			int nbFilms = 0;
			SocialNetwork sn = new SocialNetwork();
			//Initialisation de la liste avec 
			try {
				sn.addMember("marouan", "marouan", "profil");
				sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				nbFilms = sn.nbFilms();
			} 
			catch (BadEntry e) {}
			catch (NotMember e) {}
			catch (ItemFilmAlreadyExists e) {} 
			catch (MemberAlreadyExists e) {}
			
			////////////// Gestion de l'exception BadEntry		

			//// Le pseudo n'est pas instancié 
			nbFilms = sn.nbFilms();
			try {
				sn.addItemFilm(null, "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.1.1 : l'ajout d'un Film dont le pseudo n'est pas instancié est accepté.");
				
			} catch (BadEntry e) {			
					System.err.println("Erreur 3.1.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
			  } 
			catch (NotMember e) {
				System.err.println("Erreur 3.1.3 : Exception NotMember non prévue");
				} 
			catch (ItemFilmAlreadyExists e) {
				System.err.println("Erreur 3.1.4 : Exception ItemAlreadyExist non prévue");
				}
			
			/// Le pseudo a moins de 1 caractère autre que des espaces
			try {
				sn.addItemFilm(" ", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.2.1 : l'ajout d'un Film dont le pseudo ne contient que des espaces est accepté.");
				
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.2.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
					
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/// Le password n'est pas instancié
			try {
				sn.addItemFilm("marouan", "", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.3.1 : l'ajout d'un Film dont le password n'est pas instancié est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.3.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			
			///Le password a moins de 4 caractère autre que des espaces
			try {
				sn.addItemFilm("marouan", "  ", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.4.1 : l'ajout d'un Film dont le password contient moins de 4 caractères autre que des espaces est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.4.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/// Le titre est non instancié
			try {
				sn.addItemFilm("marouan", "marouan", "", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.5.1 : l'ajout d'un Film dont le titre n'est pas instancié est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.5.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			
			/// Le genre est non instancié
			try {
				sn.addItemFilm("marouan", "marouan", "Ninja", "", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.7.1 : l'ajout d'un Film dont le genre n'est pas instancié est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.7.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/// Le realisateur non instancié
			try {
				sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "", "scenariste2", 80);
				System.err.println("Erreur 3.8.1 : l'ajout d'un Film dont l'auteur n'est pas instancié est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.8.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/// Le scénariste non instancié
			try {
				sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "", 80);
				System.err.println("Erreur 3.8.1 : l'ajout d'un Film dont l'auteur n'est pas instancié est accepté.");
			} catch (BadEntry e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.8.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			} 
			catch (NotMember e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			
			///////////////////  Gestion de l'exception NotMember

			/// Le pseudo est inconnu 
			try {
				sn.addItemFilm("Robert", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.1.1 : l'ajout d'un Film avec un pseudo inconnu est autorisé.");
			}
			catch (NotMember e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.1.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			}
			catch (BadEntry e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/// Le mot de passe du pseudo n'est pas le bon
			try {
				sn.addItemFilm("marouan", "marou", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.2.1 : l'ajout d'un Film avec un mauvais mot de passe est autorisé.");
			}
			catch (NotMember e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.2.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			}
			catch (BadEntry e) {} 
			catch (ItemFilmAlreadyExists e) {}
			
			/////////////////// Gestion de l'exception ItemAlreadyExists

			/// Le titre existe déjà
			try {
				sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
				System.err.println("Erreur 3.3.1 : l'ajout d'un Film avec un titre déjà existant est autorisé.");
			}
			catch (ItemFilmAlreadyExists e) {
				if(sn.nbFilms() != nbFilms){
					System.err.println("Erreur 3.3.2 : le nombre de Film dans la liste ne doit pas changé après le refus d'ajout d'un Film dans la liste");
				}
			}
			catch (NotMember e) {}
			catch (BadEntry e) {}

	    }
	
	
	
	
}
