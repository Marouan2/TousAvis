package test;

import static org.junit.Assert.*;

import org.junit.Test;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */

/**
 * @author Marouan
 *
 */
/**
 * @author Marouan
 *
 */
/**
 * @author Marouan
 *
 */
/**
 * @author Marouan
 *
 */

public class SocialNetworkTest {
	private SocialNetwork sn = new SocialNetwork();


	/**
	 * Test de la méthode nbMembers  
	 */
	@Test
	public void testNbMembers() throws Exception{
		sn.addMember("Paul", "paul", "lecteur impulsif");
		sn.addMember("Antoine", "antoine", "grand amoureux de littérature");
		sn.addMember("Alice", "alice", "23 ans, sexy");
		assertEquals(3,sn.nbMembers());
	}
	/**
	 * Test de la méthode nbFilms  
	 */
	@Test
	public void testNbFilms() throws Exception{
		sn.addItemFilm("pseudo", "password", "ninja", "genre", "realisateur", "scenariste", 80);
		sn.addItemFilm("pseudo1", "password1", "ninja1", "genre1", "realisateur1", "scenariste1", 70);
		assertEquals(2,sn.nbFilms());
	}

	/**
	 * Test de la méthode nbBooks  
	 */
	@Test
	public void testNbBooks() throws Exception {
		sn.addItemBook("pseudo", "password", "informatique", "genre", "aminou", 80);
		sn.addItemBook("pseudo1", "password1", "Java", "genre1", "marouan", 70);
		assertEquals(2,sn.nbBooks());

	}

	/**
	 * Test de la méthode addMember  doit lever les exceptions
	 * @throws BadEntry
	 * @throws MemberAlreadyExists
	 */
	@Test(expected=MemberAlreadyExists.class)
	public void testAddMember() throws BadEntry, MemberAlreadyExists {		


		sn.addMember("jean", "paul", "lecteur impulsif");
		sn.addMember("Paul", "gtyhu", "grand amoureux de littérature");
		sn.addMember("Paul", "gtyhu", "grand amoureux de littérature");
		sn.addMember("Alice", "alice", "23 ans, sexy");

		try {
			sn.addMember(null, "qsdfgh", "");			
		} catch (BadEntry e) {
			fail("Erreur 3.1 :  l'ajout d'un membre dont le pseudo n'est pas instancié: exception BadEntry ");
		}

		try {
			sn.addMember("  ", "qsdfgh", "");        
		} catch (BadEntry e) {
			fail("Erreur 3.2 :  l'ajout d'un membre dont le pseudo ne contient pas un caractère, autre que des espaces: exception BadEntry ");

		}       

		try {
			sn.addMember("B", null, "");        
		} catch (BadEntry e) {
			fail("Erreur 3.3 :  l'ajout d'un membre dont le password n'est pas instancié: exception BadEntry ");

		}

		try {
			sn.addMember("B", "  qwd  ", "");
		} catch (BadEntry e) {
			fail("Erreur 3.4 :  l'ajout d'un membre dont le password ne contient pas au moins 4 caractères, autre que des espaces de début ou de fin: exception BadEntry ");

		}

		try {
			sn.addMember("BBBB", "bbbb", null);        
		} catch (BadEntry e) {
			fail("Erreur 3.5 :  l'ajout d'un membre dont le profil n'est pas instancié: exception BadEntry ");

		}        	

	}

	
	/**Test de la méthode additemFilm
	 * @throws BadEntry
	 * @throws NotMember
	 * @throws ItemFilmAlreadyExists
	 */
	@Test
	public void testAddItemFilm() throws BadEntry, NotMember, ItemFilmAlreadyExists {
		try {
			sn.addMember("marouan", "marouan", "profil");
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
		} 
		catch (BadEntry e) {}
		catch (NotMember e) {}
		catch (ItemFilmAlreadyExists e) {} 
		catch (MemberAlreadyExists e) {}
		
		////////////// Gestion de l'exception BadEntry		

		//// Le pseudo n'est pas instancié 
		
		try {
			sn.addItemFilm(null, "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.1.1 : l'ajout d'un Film dont le pseudo n'est pas instancié est accepté.");
			
		} catch (BadEntry e) {			
		  } 
		catch (NotMember e) {
			fail("Erreur 3.1.3 : Exception NotMember non prévue");
			} 
		catch (ItemFilmAlreadyExists e) {
			fail("Erreur 3.1.4 : Exception ItemAlreadyExist non prévue");
			}
		
		/// Le pseudo a moins de 1 caractère autre que des espaces
		try {
			sn.addItemFilm(" ", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.2.1 : l'ajout d'un Film dont le pseudo ne contient que des espaces est accepté.");
			
		} catch (BadEntry e) {
					} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/// Le password n'est pas instancié
		try {
			sn.addItemFilm("marouan", "", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.3.1 : l'ajout d'un Film dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {
		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		
		///Le password a moins de 4 caractère autre que des espaces
		try {
			sn.addItemFilm("marouan", "  ", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.4.1 : l'ajout d'un Film dont le password contient moins de 4 caractères autre que des espaces est accepté.");
		} catch (BadEntry e) {
		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/// Le titre est non instancié
		try {
			sn.addItemFilm("marouan", "marouan", "", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.5.1 : l'ajout d'un Film dont le titre n'est pas instancié est accepté.");
		} catch (BadEntry e) {
		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		
		/// Le genre est non instancié
		try {
			sn.addItemFilm("marouan", "marouan", "Ninja", "", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.7.1 : l'ajout d'un Film dont le genre n'est pas instancié est accepté.");
		} catch (BadEntry e) {
		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/// Le realisateur non instancié
		try {
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "", "scenariste2", 80);
			fail("Erreur 3.8.1 : l'ajout d'un Film dont l'auteur n'est pas instancié est accepté.");
		} catch (BadEntry e) {
  		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/// Le scénariste non instancié
		try {
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "", 80);
			fail("Erreur 3.8.1 : l'ajout d'un Film dont l'auteur n'est pas instancié est accepté.");
		} catch (BadEntry e) {
		} 
		catch (NotMember e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		
		///////////////////  Gestion de l'exception NotMember

		/// Le pseudo est inconnu 
		try {
			sn.addItemFilm("Robert", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.1.1 : l'ajout d'un Film avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {

		}
		catch (BadEntry e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/// Le mot de passe du pseudo n'est pas le bon
		try {
			sn.addItemFilm("marouan", "marou", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.2.1 : l'ajout d'un Film avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {
			
		}
		catch (BadEntry e) {} 
		catch (ItemFilmAlreadyExists e) {}
		
		/////////////////// Gestion de l'exception ItemAlreadyExists

		/// Le titre existe déjà
		try {
			sn.addItemFilm("marouan", "marouan", "Ninja", "Art Martiaux", "realisateur2", "scenariste2", 80);
			fail("Erreur 3.3.1 : l'ajout d'un Film avec un titre déjà existant est autorisé.");
		}
		catch (ItemFilmAlreadyExists e) {
			
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}

    }
	


	/**
	 * Test de la methode addItemBook  doit lever les exceptions
	 * @throws BadEntry 
	 * @throws ItemBookAlreadyExists 
	 * @throws NotMember 
	 */
	@Test
	public void testAddItemBook() throws BadEntry, NotMember, ItemBookAlreadyExists, MemberAlreadyExists {	


		sn.addMember("marouan", "marouan", "lecteur impulsif");
		sn.addMember("salem", "salut", "grand amoureux de littérature");
		sn.addItemBook("sales", "zazarty", "qsdfgh", "efghi", "auteur", 100);        


		try {
			sn.addItemBook("  ", "vbg", "querty", "vbnh", "auteur", 150);        
		}
		catch (BadEntry e) {}

		try {
			sn.addItemBook("vbj", "", "querty", "vbnh", "auteur", 150);
			fail("Erreur 5.3 :  l'ajout d'un livre dont le password n'est pas instancié: exception BadEntry ");
		} catch (BadEntry e5) {
		}

		try {
			sn.addItemBook("hello", "zaz", "qsdfgh", "efghi", "auteur", 100); 
			fail("Erreur 5.4 :  l'ajout d'un livre dont le password ne contient pas au moins 4 caractères, autre que des espaces de début ou de fin: exception BadEntry ");
		} catch (BadEntry e5) {}

		try {
			sn.addItemBook("hello", "zazarty", "", "efghi", "auteur", 100);
			fail("Erreur 5.5 :  l'ajout d'un livre dont le titre n'est pas instancié: exception BadEntry ");
		} catch (BadEntry e4) {
		}

		try {
			sn.addItemBook("hjki", "zazarty", " ", "efghi", "auteur", 100);
			fail("Erreur 5.6 :  l'ajout d'un livre dont le titre ne contient pas un caract�re, autre que des espaces: exception BadEntry");
		} catch (BadEntry e3) {
		}

		try {
			sn.addItemBook("hjki", "zazarty", "hjui", null, "auteur", 100);
			fail("Erreur 5.7 :  l'ajout d'un livre dont le genre n'est pas instancié: exception BadEntry");
		} catch (BadEntry e2) {
		}        

		try {
			sn.addItemBook("drft", "bghy", "zazarty", "hjui", null, 100); 
			fail("Erreur 5.8 :  l'ajout d'un livre dont l'auteur n'est pas instancié: exception BadEntry");
		} catch (BadEntry e1) {
		}

		try {
			sn.addItemBook("hjki", "zazarty", "jkiol", "efghi", "auteur", 0);   
			fail("Erreur 5.9 :  l'ajout d'un livre dont le nombre de pages n'est pas instancié: exception BadEntry");
		} catch (BadEntry e) {
		}
		

		// ajout de 3 livres avec entrées "correctes"                 
		sn.addItemBook("Paul", "paul", "J2EE ", "informatique", "Java7", 300);        
		sn.addItemBook("Aminou", "kadri", "Telecom Bretagne", "souvenir", "Marouan", 50);        
		sn.addItemBook("Marouan", "Marouan","Marouan Brest", "souvenir", "Aminou", 70);        

		// tentative d'ajout de livre "existant"
		try {
			sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
			sn.addItemBook("Aminou", "kadri", "Telecom Bretagne", "souvenir", "Marouan", 50);        
			sn.addItemBook("Marouan", "Marouan","Marouan Brest", "souvenir", "Aminou", 70);  
			fail("Erreur 5.13 :  l'ajout d'un livre du même titre et auteur: Exception ItemBookAlreadyExists");
		} catch (ItemBookAlreadyExists e) {
		}

	}

	/**
	 * Test de la methode consultItems  doit lever les exceptions
	 * @throws BadEntry 
	 * @throws MemberAlreadyExists 
	 * @throws ItemFilmAlreadyExists 
	 * @throws NotMember 
	 */
	@Test
	public void testconsultItems() throws BadEntry, MemberAlreadyExists, NotMember, ItemFilmAlreadyExists{
		try{
			sn.addMember("membre1","member1","user");
			sn.addItemFilm("membre1", "membre1", "ninja", "genre2", "realisateur2", "scenariste2", 80);
			sn.consultItems("");
			fail("Erreur: le titre à consulter ne doit pas être vide: exception BadEntry");
		}catch (BadEntry|MemberAlreadyExists|ItemFilmAlreadyExists|NotMember ex){
		}

		try{

			sn.addMember("member2","member2","admin");
			sn.addItemFilm("member2", "member2", "dragon", "genre3", "realisateur3", "scenariste3", 70);
			sn.consultItems("drag");
		}catch (BadEntry ex){
			fail("Erreur: le titre drag n'existe pas :exception BadEntry");

		}
	}


	/**
	 * Test de la methode reviewItemFilm elle doit lever les exceptions
	 * @throws BadEntry 
	 * @throws NotItem
	 * @throws MemberAlreadyExists 
	 * @throws ItemFilmAlreadyExists 
	 */
	@Test(expected=NotMember.class)
	public void testReviewItemFilm() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemFilmAlreadyExists{

		sn.addMember("marouan","marouan","admin");
		sn.addItemFilm("marouan","marouan","film1","action","Zhu","Zhong",100);
		sn.reviewItemFilm("marou","marou","film1",4.2f,"comment");


		try{
			sn.reviewItemFilm("marouan","marouan","f",4.2f,"comment");
		}
		catch (NotItem ex) {
			fail("Erreur: film n'existe pas  : exception NotItem");
		}

		try{
			sn.addItemFilm("salem","salem","film1","action","Zhu","Zhong",100);
			sn.reviewItemFilm("salem","salem","film1",4.2f,"comment");
		}
		catch (ItemFilmAlreadyExists ex) {
			fail("Erreur: film déjà existant:exception ItemFilmAlreadyExists");
		}

		try{
			sn.reviewItemFilm("marouan","marouan",null,4.2f,null);
		}catch (BadEntry ex){
			fail("Erreur: titre et comment sont obligatoire: exception BadEntry");
		}



	}


	/**
	 * Test de la methode reviewItemBook elle doit lever les exceptions
	 * @throws BadEntry 
	 * @throws NotMember
	 * @throws NotItem
	 * @throws MemberAlreadyExists 
	 * @throws ItemBookAlreadyExists 
	 */
	@Test 
	public void testReviewItemBook() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemBookAlreadyExists{
		try{
			sn.addMember("marouan","marouan","admin");
			sn.addItemBook("marouan","marouan","book1","roman","Zhong",200);
			sn.reviewItemBook("marou","marou","book1",4.2f,"comment");
			fail("Erreur: membre n'existe pas: exception NotMember|BadEntry");
		}
		catch (NotMember|BadEntry ex) {
		}

		try{
			sn.reviewItemBook("marouan","marouan","boo",4.2f,"comment");
			fail("Erreur: livre n'existe pas  : exception NotItem");
		}
		catch (NotItem ex) {
		}

		try{
			sn.addItemBook("salem","salem","book1","action","Zhu",200);
			sn.reviewItemBook("salem","salem","book1",4.2f,"comment");
			fail("Erreur: livre déjà existant:exception ItemBookAlreadyExists");
		}
		catch (ItemBookAlreadyExists ex) {
		}

		try{
			sn.reviewItemBook("marouan","marouan",null,4.2f,null);
			fail("Erreur: titre et comment sont obligatoire: exception BadEntry");
		}catch (BadEntry ex){
		}
	}	
	
	
	/**Test de la méthode reviewOpinionBook
	 * ce test va gérer toutes les exceptions
	 * @throws BadEntry
	 * @throws NotMember
	 * @throws NotItem
	 * @throws MemberAlreadyExists
	 * @throws ItemBookAlreadyExists
	 */
	@Test
	public void testReviewOpinionBook() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemBookAlreadyExists{
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
			fail("Erreur 7.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le password n'est pas instancié
		try {
			sn.reviewOpinionBook("salem", null, "The Legend","marouan","Bon",2);
			fail("Erreur 7.2.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le titre est non instancié
		try {
			sn.reviewOpinionBook("salem", "salem", null,"marouan","Bon",2);
			fail("Erreur 7.3.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");

		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le titre est vide
		try {
			sn.reviewOpinionBook("salem", "salem", "","marouan","Bon",2);
			fail("Erreur 7.4.1 : l'ajout d'une opinion dont le titre du Book est vide est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le commentaire est non instancié
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","marouan",null,2);
			fail("Erreur 7.5.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// La note est négative
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","marouan","Bon",-2);
			fail("Erreur 7.6.1 : l'ajout d'une opinion dont la note est négative est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {}
		catch (NotItem e) {}		


		/// Gestion de l'exception NotItem

		/// Le titre n'existe pas dans la liste 
		try {
			sn.reviewOpinionBook("salem", "salem", "Dragon Ball Z","marouan","Bon",2);
			fail("Erreur 7.8.2 : l'ajout d'une opinion avec un titre différent est autorisé.");
		}
		catch (NotItem e) {	}
		catch (NotMember e) {}
		catch (BadEntry e) {}

		/// Gestion de l'exception NotMember

		/// Le pseudo n'existe pas dans la liste
		try {
			sn.reviewOpinionBook("Robin", "salem", "The Legend","marouan","Bon",2);
			fail("Erreur 7.2.2 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le mot de passe n'est pas le bon
		try {
			sn.reviewOpinionBook("salem", "alut", "The Legend","marouan","Bon",2);
			fail("Erreur 7.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le pseudo qui a noté le Book n'est pas le bon
		try {
			sn.reviewOpinionBook("salem", "salem", "The Legend","Robin","Bon",2);
			fail("Erreur 7.4.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

	}
	
	

	/**Test de la méthode reviewOpinionFilm
	 * ce test va gérer toutes les exceptions
	 * @throws BadEntry
	 * @throws NotMember
	 * @throws NotItem
	 * @throws MemberAlreadyExists
	 * @throws ItemBookAlreadyExists
	 */
	@Test
	public void testReviewOpinionFilm() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemBookAlreadyExists{
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
			fail("Erreur 6.1.1 : l'ajout d'une opinion dont le pseudo n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le password n'est pas instancié
		try {
			sn.reviewOpinionFilm("salem", null, "Ninja","marouan","Bon",2);
			fail("Erreur 6.3.1 : l'ajout d'une opinion dont le password n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}


		/// Le titre est non instancié
		try {
			sn.reviewOpinionFilm("salem", "salem", null,"marouan","Bon",2);
			fail("Erreur 6.5.1 : l'ajout d'une opinion dont le titre n'est pas instancié est accepté.");

		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le titre est vide
		try {
			sn.reviewOpinionFilm("salem", "salem", "","marouan","Bon",2);
			fail("Erreur 6.6.1 : l'ajout d'une opinion dont le titre du Film est vide est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// Le commentaire est non instancié
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","marouan",null,2);
			fail("Erreur 6.7.1 : l'ajout d'une opinion dont le commentaire n'est pas instancié est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {} 
		catch (NotItem e) {}

		/// La note est négative
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","marouan","Bon",-2);
			fail("Erreur 6.8.1 : l'ajout d'une opinion dont la note est négative est accepté.");
		} catch (BadEntry e) {} 
		catch (NotMember e) {}
		catch (NotItem e) {}		


		/// Gestion de l'exception NotItem

		/// Le titre n'existe pas dans la liste 
		try {
			sn.reviewOpinionFilm("salem", "salem", "Dragon Ball Z","marouan","Bon",2);
			fail("Erreur 6.1.2 : l'ajout d'une opinion avec un titre différent est autorisé.");
		}
		catch (NotItem e) {	}
		catch (NotMember e) {}
		catch (BadEntry e) {}

		/// Gestion de l'exception NotMember

		/// Le pseudo n'existe pas dans la liste
		try {
			sn.reviewOpinionFilm("Robin", "salem", "Ninja","marouan","Bon",2);
			fail("Erreur 6.2.2 : l'ajout d'une opinion avec un pseudo inconnu est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le mot de passe n'est pas le bon
		try {
			sn.reviewOpinionFilm("salem", "alut", "Ninja","marouan","Bon",2);
			fail("Erreur 6.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

		/// Le pseudo qui a noté le film n'est pas le bon
		try {
			sn.reviewOpinionFilm("salem", "salem", "Ninja","Robin","Bon",2);
			fail("Erreur 6.3.2 : l'ajout d'une opinion avec un mauvais mot de passe est autorisé.");
		}
		catch (NotMember e) {}
		catch (BadEntry e) {}
		catch (NotItem e) {}

	}


}
