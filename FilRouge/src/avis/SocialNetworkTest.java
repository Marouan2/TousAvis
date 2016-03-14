package avis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;
import junit.framework.Assert;

/** 
 * @author Kadry Mohammadou Aminou, 
 * @author Marouan Marouan
 * @date février - mars 2016
 * @version V0.7
 */

@SuppressWarnings("deprecation")
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
	@Test
	public void testAddMember() throws BadEntry, MemberAlreadyExists {		

		try {
			sn.addMember("jean", "paul", "lecteur impulsif");
			sn.addMember("Paul", "gtyhu", "grand amoureux de littérature");
			sn.addMember("Paul", "gtyhu", "grand amoureux de littérature");
			sn.addMember("Alice", "alice", "23 ans, sexy");
		} catch (MemberAlreadyExists e1) {
			Assert.fail("Erreur 3.0: exception MemberAlreadyExists!");
		}
		try {
			sn.addMember(null, "qsdfgh", "");			
		} catch (BadEntry e) {
			Assert.fail("Erreur 3.1 :  l'ajout d'un membre dont le pseudo n'est pas instancié: exception BadEntry ");
		}

		try {
			sn.addMember("  ", "qsdfgh", "");        
		} catch (BadEntry e) {
			Assert.fail("Erreur 3.2 :  l'ajout d'un membre dont le pseudo ne contient pas un caractère, autre que des espaces: exception BadEntry ");

		}       

		try {
			sn.addMember("B", null, "");        
		} catch (BadEntry e) {
			Assert.fail("Erreur 3.3 :  l'ajout d'un membre dont le password n'est pas instancié: exception BadEntry ");

		}

		try {
			sn.addMember("B", "  qwd  ", "");
		} catch (BadEntry e) {
			Assert.fail("Erreur 3.4 :  l'ajout d'un membre dont le password ne contient pas au moins 4 caractères, autre que des espaces de début ou de fin: exception BadEntry ");

		}

		try {
			sn.addMember("BBBB", "bbbb", null);        
		} catch (BadEntry e) {
			Assert.fail("Erreur 3.5 :  l'ajout d'un membre dont le profil n'est pas instancié: exception BadEntry ");

		}        	

	}

	@Test
	public void testAddItemFilm() throws BadEntry, NotMember, ItemFilmAlreadyExists {
		sn.addItemFilm("pseudo2", "password2", "ninja", "genre2", "realisateur2", "scenariste2", 80);
		sn.addItemFilm("pseudo3", "password3", "ninja", "genre3", "realisateur3", "scenariste3", 70);
		assertEquals("film already exist", "ninja","ninja" );
	}


	/**
	 * Test de la methode addItemBook  doit lever les exceptions
	 * @throws BadEntry 
	 * @throws ItemBookAlreadyExists 
	 * @throws NotMember 
	 */
	@Test
	public void testAddItemBook() throws BadEntry, NotMember, ItemBookAlreadyExists, MemberAlreadyExists {	

		try {
			sn.addMember("marouan", "marouan", "lecteur impulsif");
			sn.addMember("salem", "salut", "grand amoureux de littérature");
			sn.addItemBook("sales", "zazarty", "qsdfgh", "efghi", "auteur", 100);        

		} catch (NotMember e) {
			Assert.fail("Erreur 5.1 :  l'ajout d'un livre dont le pseudo ne correspond pas à un membre existant: Exception NotMember sales");

		}
		try {
			sn.addItemBook("  ", "vbg", "querty", "vbnh", "auteur", 150);        
		} catch (BadEntry e) {
			Assert.fail("Erreur 5.2 :  l'ajout d'un livre dont le pseudo ne contient pas un caractère, autre que des espaces:exception BadEntry" );
		}


		try {
			sn.addItemBook("vbj", "", "querty", "vbnh", "auteur", 150);
		} catch (BadEntry e5) {
			Assert.fail("Erreur 5.3 :  l'ajout d'un livre dont le password n'est pas instancié: exception BadEntry ");
		}

		try {
			sn.addItemBook("hello", "zaz", "qsdfgh", "efghi", "auteur", 100);        
		} catch (BadEntry e5) {
			Assert.fail("Erreur 5.4 :  l'ajout d'un livre dont le password ne contient pas au moins 4 caractères, autre que des espaces de début ou de fin: exception BadEntry ");
		}

		try {
			sn.addItemBook("hello", "zazarty", "", "efghi", "auteur", 100);        
		} catch (BadEntry e4) {
			Assert.fail("Erreur 5.5 :  l'ajout d'un livre dont le titre n'est pas instancié: exception BadEntry ");
		}

		try {
			sn.addItemBook("hjki", "zazarty", " ", "efghi", "auteur", 100);        
		} catch (BadEntry e3) {
			Assert.fail("Erreur 5.6 :  l'ajout d'un livre dont le titre ne contient pas un caract�re, autre que des espaces: exception BadEntry");
		}

		try {
			sn.addItemBook("hjki", "zazarty", "hjui", null, "auteur", 100);
		} catch (BadEntry e2) {
			Assert.fail("Erreur 5.7 :  l'ajout d'un livre dont le genre n'est pas instancié: exception BadEntry");
		}        

		try {
			sn.addItemBook("drft", "bghy", "zazarty", "hjui", null, 100);        
		} catch (BadEntry e1) {
			Assert.fail("Erreur 5.8 :  l'ajout d'un livre dont l'auteur n'est pas instancié: exception BadEntry");
		}

		try {
			sn.addItemBook("hjki", "zazarty", "jkiol", "efghi", "auteur", 0);         
		} catch (BadEntry e) {
			Assert.fail("Erreur 5.9 :  l'ajout d'un livre dont le nombre de pages n'est pas instancié: exception BadEntry");
		}
		// <=> fiche num�ro 2

		// ajout de 3 livres avec entrées "correctes"                 
		sn.addItemBook("Paul", "paul", "J2EE ", "informatique", "Java7", 300);        
		sn.addItemBook("Aminou", "kadri", "Telecom Bretagne", "souvenir", "Marouan", 50);        
		sn.addItemBook("Marouan", "Marouan","Marouan Brest", "souvenir", "Aminou", 70);        

		// tentative d'ajout de livre "existant"
		try {
			sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
			sn.addItemBook("Aminou", "kadri", "Telecom Bretagne", "souvenir", "Marouan", 50);        
			sn.addItemBook("Marouan", "Marouan","Marouan Brest", "souvenir", "Aminou", 70);  
		} catch (ItemBookAlreadyExists e) {
			Assert.fail("Erreur 5.13 :  l'ajout d'un livre du même titre et auteur: Exception ItemBookAlreadyExists");
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
		}catch (BadEntry|MemberAlreadyExists|ItemFilmAlreadyExists|NotMember ex){
			Assert.fail("Erreur: le titre à consulter ne doit pas être vide: exception BadEntry");
		}

		try{

			sn.addMember("member2","member2","admin");
			sn.addItemFilm("member2", "member2", "dragon", "genre3", "realisateur3", "scenariste3", 70);
			sn.consultItems("drag");
		}catch (BadEntry ex){
			Assert.fail("Erreur: le titre drag n'existe pas :exception BadEntry");
		}
	}


	/**
	 * Test de la methode reviewItemFilm elle doit lever les exceptions
	 * @throws BadEntry 
	 * @throws NotItem
	 * @throws MemberAlreadyExists 
	 * @throws ItemFilmAlreadyExists 
	 */
	@Test
	public void testReviewItemFilm() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemFilmAlreadyExists{
		try{
			sn.addMember("marouan","marouan","admin");
			sn.addItemFilm("marouan","marouan","film1","action","Zhu","Zhong",100);
			sn.reviewItemFilm("marou","marou","film1",4.2f,"comment");
		}
		catch (NotMember|BadEntry ex) {
			Assert.fail("Erreur: membre n'existe pas: exception NotMember|BadEntry");
		}

		try{
			sn.reviewItemFilm("marouan","marouan","f",4.2f,"comment");
		}
		catch (NotItem ex) {
			Assert.fail("Erreur: film n'existe pas  : exception NotItem");
		}

		try{
			sn.addItemFilm("salem","salem","film1","action","Zhu","Zhong",100);
			sn.reviewItemFilm("salem","salem","film1",4.2f,"comment");
		}
		catch (ItemFilmAlreadyExists ex) {
			Assert.fail("Erreur: film déjà existant:exception ItemFilmAlreadyExists");
		}

		try{
			sn.reviewItemFilm("marouan","marouan",null,4.2f,null);
		}catch (BadEntry ex){
			Assert.fail("Erreur: titre et comment sont obligatoire: exception BadEntry");
		}



	}


	/**
	 * Test de la methode reviewItemBook elle doit lever les exceptions
	 * @throws BadEntry 
	 * @throws NotItem
	 * @throws MemberAlreadyExists 
	 * @throws ItemBookAlreadyExists 
	 */
	@Test (timeout=6000)
	public void testReviewItemBook() throws BadEntry, NotMember, NotItem, MemberAlreadyExists, ItemBookAlreadyExists{
		try{
			sn.addMember("marouan","marouan","admin");
			sn.addItemBook("marouan","marouan","book1","roman","Zhong",200);
			sn.reviewItemBook("marou","marou","book1",4.2f,"comment");
		}
		catch (NotMember|BadEntry ex) {
			Assert.fail("Erreur: membre n'existe pas: exception NotMember|BadEntry");
		}

		try{
			sn.reviewItemBook("marouan","marouan","boo",4.2f,"comment");
		}
		catch (NotItem ex) {
			Assert.fail("Erreur: livre n'existe pas  : exception NotItem");
		}

		try{
			sn.addItemBook("salem","salem","book1","action","Zhu",200);
			sn.reviewItemBook("salem","salem","book1",4.2f,"comment");
		}
		catch (ItemBookAlreadyExists ex) {
			Assert.fail("Erreur: livre déjà existant:exception ItemFilmAlreadyExists");
		}

		try{
			sn.reviewItemBook("marouan","marouan",null,4.2f,null);
		}catch (BadEntry ex){
			Assert.fail("Erreur: titre et comment sont obligatoire: exception BadEntry");
		}
	}	


}
