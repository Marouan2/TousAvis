package avis;

import java.util.LinkedList;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;

/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */
public class TestsConsultItems {
	LinkedList <String> test = new LinkedList <String>();
	
	public TestsConsultItems(){
		SocialNetwork sn = new SocialNetwork();
		//Initialisation de la liste avec 
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addItemBook("marouan", "marouan", "The Legend", "roman", "bernard", 617);
			sn.addItemBook("marouan", "marouan", "Mes Souvenir à Brest", "roman", "bernard", 617);
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			sn.addItemFilm("marouan", "marouan", "Bruce Lee", "Art Martiaux", "realisateur2", "scenariste2", 80);
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (MemberAlreadyExists e) {}
		catch (ItemBookAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ItemFilmAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/////////////////// Gestion de l'exception BadEntry

		//// Le nom n'est pas instancié 
		try {
			sn.consultItems(null);
			System.err.println("Erreur 8.1.1 : le nom n'est pas instancié");
		} catch (BadEntry e) {}
		
		/// Le nom a moins de 1 caractère autre que des espaces
		try {
			sn.consultItems(" ");
			System.err.println("Erreur 8.2.1 : le nom posséde moins de 1 caractère ou ne contient que des espaces");
		} catch (BadEntry e) {}
		
		/// Le nom correspond à un élément de la liste book
		try {
			test = sn.consultItems("The Legend");			
		} catch (BadEntry e) {}
		
		
		/// Le nom correspond à un élément de la liste film
		try {
			test = sn.consultItems("Ninja");
		} catch (BadEntry e) {}
		
	}
}
