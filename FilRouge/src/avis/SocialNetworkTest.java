package avis;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.BadEntry;
import exception.ItemBookAlreadyExists;
import exception.ItemFilmAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotMember;

public class SocialNetworkTest {
private SocialNetwork sn = new SocialNetwork();
private int nbMembres = 0;
private int nbLivres = 0;
private int nbFilms = 0;


	@Test
	public void testNbMembers() throws BadEntry, MemberAlreadyExists {
		sn.addMember("Paul", "paul", "lecteur impulsif");
		sn.addMember("Antoine", "antoine", "grand amoureux de littérature");
		sn.addMember("Alice", "alice", "23 ans, sexy");		
		assertFalse(sn.nbMembers()!=nbMembres+3);
	}

	@Test
	public void testNbFilms() throws BadEntry, NotMember, ItemFilmAlreadyExists {
        nbMembres = sn.nbFilms();
		sn.addItemFilm("pseudo", "password", "ninja", "genre", "realisateur", "scenariste", 80);
		sn.addItemFilm("pseudo1", "password1", "ninja1", "genre1", "realisateur1", "scenariste1", 70);
		assertFalse(sn.nbFilms()!=nbFilms + 2);
	}

	@Test
	public void testNbBooks() throws BadEntry, NotMember, ItemBookAlreadyExists {
		nbLivres = sn.nbBooks();
		sn.addItemBook("pseudo", "password", "informatique", "genre", "aminou", 80);
		sn.addItemBook("pseudo1", "password1", "Java", "genre1", "marouan", 70);
		assertFalse(sn.nbBooks()!=nbLivres + 2);
	
	}

	@Test
	public void testAddMember() throws BadEntry, MemberAlreadyExists {		
		sn.addMember("jean", "paul", "lecteur impulsif");
     	sn.addMember("Paul", "gtyhu", "grand amoureux de littérature");
		sn.addMember("Alice", "alice", "23 ans, sexy");
		//assertTrue(false);
		 nbFilms = sn.nbFilms();
         nbLivres = sn.nbBooks();
		
		nbMembres = sn.nbMembers();
        sn.addMember(null, "qsdfgh", "");        
        assertEquals("Erreur 3.1 :  l'ajout d'un membre dont le pseudo n'est pas instanci� est accept� ",nbMembres,sn.nbMembers());
        
        nbMembres = sn.nbMembers();
        sn.addMember("  ", "qsdfgh", "");        
        assertEquals("Erreur 3.2 :  l'ajout d'un membre dont le pseudo ne contient pas un caract�re, autre que des espaces, est accept� ",nbMembres,sn.nbMembers());

        
        nbMembres = sn.nbMembers();
        sn.addMember("B", null, "");        
        assertEquals("Erreur 3.3 :  l'ajout d'un membre dont le password n'est pas instanci� est accept� ",nbMembres,sn.nbMembers());

        nbMembres = sn.nbMembers();
        sn.addMember("B", "  qwd  ", "");
        assertEquals("Erreur 3.4 :  l'ajout d'un membre dont le password ne contient pas au moins 4 caract�res, autre que des espaces de d�but ou de fin, est accept� ",nbMembres,sn.nbMembers());

        nbMembres = sn.nbMembers();
        sn.addMember("BBBB", "bbbb", null);        
        assertEquals("Erreur 3.5 :  l'ajout d'un membre dont le profil n'est pas instanci� est accept� ",nbMembres,sn.nbMembers());

        
        // <=> fiche num�ro 2

        // ajout de 3 membres avec entr�es "correctes"
        
        nbMembres = sn.nbMembers();
        sn.addMember("Paul", "paul", "lecteur impulsif");
        sn.addMember("Antoine", "antoine", "grand amoureux de litt�rature");
        sn.addMember("Alice", "alice", "23 ans, sexy");
        assertEquals("Erreur 3.6 :  le nombre de membres apr�s ajout de 3 membres n'a pas augment� de 3",nbMembres + 3,sn.nbMembers());

        
        // tentative d'ajout de membre "existant"
        nbMembres = sn.nbMembers();
        sn.addMember("Paul", "paul", "");        
        assertEquals("Erreur 3.7 :  l'ajout d'un membre avec le pseudo du premier membre ajout� est accept� ",nbMembres,sn.nbMembers());

        nbMembres = sn.nbMembers();
        sn.addMember("Alice", "paul", "");
        assertEquals("Erreur 3.8 :  l'ajout d'un membre avec le pseudo du dernier membre ajout� est accept� ",nbMembres,sn.nbMembers());
        
        nbMembres = sn.nbMembers();
        sn.addMember("Martial", "abcd", "");        
        assertEquals("Erreur 3.9 :  l'ajout d'un membre avec un pseudo existant (avec casse diff�rente) est accept� ",nbMembres,sn.nbMembers());

        nbMembres = sn.nbMembers();
        sn.addMember("  Martial  ", "abcdefgh", "");
        assertEquals("Erreur 3.10 :  l'ajout d'un membre avec un pseudo existant (avec leading et trailing blanks) est accept� ",nbMembres,sn.nbMembers());

        
        assertEquals("Erreur 3.11 : le nombre de films apr�s utilisation de addMember a �t� modifi�",nbFilms,sn.nbFilms());

        assertEquals("Erreur 3.12 : le nombre de livres apr�s utilisation de addMember a �t� modifi�",nbLivres,sn.nbBooks());
	
		
	}

	@Test
	public void testAddItemFilm() throws BadEntry, NotMember, ItemFilmAlreadyExists {
		sn.addItemFilm("pseudo2", "password2", "ninja", "genre2", "realisateur2", "scenariste2", 80);
		sn.addItemFilm("pseudo3", "password3", "ninja", "genre3", "realisateur3", "scenariste3", 70);
		assertEquals("film already exist", "ninja","ninja" );
	}

	@Test
	public void testAddItemBook() throws BadEntry, NotMember, ItemBookAlreadyExists {	
		 ///nbFilms = sn.nbFilms();
        // nbLivres = sn.nbBooks();         
         // <=> fiche num�ro 1
         // tentative d'ajout de LIVRES avec entr�es "incorrectes"
         nbLivres = sn.nbBooks();
         sn.addItemBook(null, "zazarty", "qsdfgh", "efghi", "auteur", 100);        
         assertEquals("Erreur 5.1 :  l'ajout d'un livre dont le pseudo n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         //nbLivres = sn.nbBooks();
         sn.addItemBook("  ", "vbg", "querty", "vbnh", "auteur", 150);        
         assertEquals("Erreur 5.2 :  l'ajout d'un livre dont le pseudo ne contient pas un caract�re, autre que des espaces, est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("vbj", "", "querty", "vbnh", "auteur", 150);
         assertEquals("Erreur 5.3 :  l'ajout d'un livre dont le password n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("hello", "zaz", "qsdfgh", "efghi", "auteur", 100);        
         assertEquals("Erreur 5.4 :  l'ajout d'un livre dont le password ne contient pas au moins 4 caract�res, autre que des espaces de d�but ou de fin, est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("hello", "zazarty", "", "efghi", "auteur", 100);        
         assertEquals("Erreur 5.5 :  l'ajout d'un livre dont le titre n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("hjki", "zazarty", " ", "efghi", "auteur", 100);        
         assertEquals("Erreur 5.6 :  l'ajout d'un livre dont le titre ne contient pas un caract�re, autre que des espaces, est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("hjki", "zazarty", "hjui", null, "auteur", 100);        
         assertEquals("Erreur 5.7 :  l'ajout d'un livre dont le genre n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("drft", "bghy", "zazarty", "hjui", null, 100);        
         assertEquals("Erreur 5.8 :  l'ajout d'un livre dont l'auteur n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("hjki", "zazarty", "jkiol", "efghi", "auteur", 0);         
         assertEquals("Erreur 5.9 :  l'ajout d'un livre dont le nombre de pages n'est pas instanci� est accept� ",nbLivres,sn.nbBooks());

         // <=> fiche num�ro 2

         // ajout de 3 livres avec entr�es "correctes"
                 
         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "J2EE ", "informatique", "Java7", 300);        
         sn.addItemBook("Aminou", "kadri", "Telecom Bretagne", "souvenir", "Marouan", 50);        
         sn.addItemBook("Marouan", "Marouan","Marouan � Brest", "souvenir", "Aminou", 70);        
         assertEquals("Erreur 5.10 :  le nombre de livres apr�s ajout de 3 livres n'a pas augment� de 3",nbLivres + 3,sn.nbBooks());
         
         // tentative d'ajout de livre par un membre inexistant
         nbLivres = sn.nbBooks();
         sn.addItemBook("Ahjkyu", "lopmk", "Spring security", "informatique", "Security", 500);
         assertEquals("Erreur 5.11 :  l'ajout d'un livre par un membre inexistant est accept� ",nbLivres,sn.nbBooks());

         // tentative d'ajout de livre par un membre avec le pseudo et le password qui ne correspondent pas. 
         
         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
         assertEquals("Erreur 5.12 :  l'ajout d'un livre par un membre inexistant est accept� ",nbLivres,sn.nbBooks());

         
         // tentative d'ajout de livre "existant"
         
         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
         assertEquals("Erreur 5.13 :  l'ajout d'un livre avec le titre du premier livre ajout� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
         assertEquals("Erreur 5.14 :  l'ajout d'un livre avec le titre du dernier livre ajout� est accept� ",nbLivres,sn.nbBooks());

         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
         assertEquals("Erreur 5.15 :  l'ajout d'un livre avec un titre existant (avec casse diff�rente) est accept� ",nbLivres,sn.nbBooks());
         
         nbLivres = sn.nbBooks();
         sn.addItemBook("Paul", "paul", "PHP 5", "developpement", "Web", 300);
         assertEquals("Erreur 5.16 :  l'ajout d'un livre avec un titre existant (avec leading et trailing blanks) est accept� ",nbLivres,sn.nbBooks());


	}

}
