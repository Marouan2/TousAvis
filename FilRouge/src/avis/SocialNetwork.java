package avis;

import java.util.LinkedList;
import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
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


/** 
 * <p>
 * <b>Système de mutualisation d'opinions portant sur des domaines
 * variés (littérature, cinéma, art, gastronomie, etc.) et non limités.</b>
 * </p>
 * <p>
 * L'accès aux items et aux opinions qui leurs sont associées
 * est public. La création d'item et le dépôt d'opinion nécessite en revanche 
 * que l'utilisateur crée son profil au préalable.
 * </p>
 * <p>
 * Dans une version avancée (version 2), une opinion peut également
 * être évaluée. Chaque membre se voit dans cette version décerner un "karma" qui mesure
 * la moyenne des notes portant sur les opinions qu'il a émises.
 * L'impact des opinions entrant dans le calcul de la note moyenne attribuée à un item
 * est pondéré par le karma des membres qui les émettent.
 * </p>
 */

public class SocialNetwork {

	private LinkedList <Film> films;
	private LinkedList <Book> books;
	private LinkedList <Member> members;
	private Film film;
	private Book book;
	private Member member;
	private Member member2;
	private Review review;


	/**
	 * constructeur de <i>SocialNetwok</i> 
	 * 
	 */

	public SocialNetwork() {
		films = new LinkedList<Film>();
		books = new LinkedList<Book>();
		members = new LinkedList<Member>();

	}

	/**
	 * Obtenir le nombre de membres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de membres
	 */
	public int nbMembers() {
		return members.size();
	}

	/**
	 * Obtenir le nombre de films du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de films
	 */
	public int nbFilms() {
		return films.size();
	}

	/**
	 * Obtenir le nombre de livres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de livres
	 */
	public int nbBooks() {
		return books.size();
	}


	/**
	 * Ajouter un nouveau membre au <i>SocialNetwork</i>
	 * 
	 * @param pseudo son pseudo
	 * @param password son mot de passe 
	 * @param profil son profil
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le profil n'est pas instancié.  </li>
	 * </ul><br>       
	 * 
	 * @throws MemberAlreadyExists membre de même pseudo déjà présent dans le <i>SocialNetwork</i> (même pseudo : indifférent à  la casse  et aux leadings et trailings blanks)
	 * 
	 */
	public void addMember(String pseudo, String password, String profil) throws BadEntry, MemberAlreadyExists  {
		if(pseudo == null)
			throw new BadEntry("Erreur: pseudo non instancié");
		if(pseudo.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractère autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancié");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caractères autre que des espaces");
		if(profil == null)
			throw new BadEntry("Erreur: profil non instancié");
		Member newMember = new Member (pseudo, password, profil);
		for (Member m : members) {
			if (m.getPseudo().equalsIgnoreCase(newMember.getPseudo().trim()))
				throw new MemberAlreadyExists();
		}
		members.add(newMember);
	}


	/**
	 * Ajouter un nouvel item de film au <i>SocialNetwork</i> 
	 * 
	 * @param pseudo le pseudo du membre
	 * @param password le password du membre 
	 * @param titre le titre du film
	 * @param genre son genre (aventure, policier, etc.)
	 * @param realisateur le réalisateur
	 * @param scenariste le scénariste
	 * @param duree sa durée en minutes
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si le genre n'est pas instancié. </li>
	 *  <li>  si le réalisateur n'est pas instancié. </li>
	 *  <li>  si le scénariste n'est pas instancié. </li>
	 *  <li>  si la durée n'est pas positive.  </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws ItemFilmAlreadyExists : item film de même titre  déjà présent (même titre : indifférent à  la casse  et aux leadings et trailings blanks)
	 * 
	 */
	public void addItemFilm(String pseudo, String password, String titre, String genre, String realisateur, String scenariste, int duree) throws BadEntry, NotMember, ItemFilmAlreadyExists {
		if(pseudo == null)
			throw new BadEntry("Erreur: pseudo non instancie");
		if(pseudo.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractere autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancie");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caracteres autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");
		if(genre == null)
			throw new BadEntry("Erreur: genre non instancie");
		if(realisateur == null)
			throw new BadEntry("Erreur: realisateur non instancie");
		if(scenariste == null)
			throw new BadEntry("Erreur: scenariste non instancie");
		if(duree <= 0)
			throw new BadEntry("Erreur: duree negative");
		Film newFilm = new Film(titre, genre, realisateur, scenariste, duree);
		for (Film m : films) {
			if (m.getTitre().equalsIgnoreCase(newFilm.getTitre()))
				throw new ItemFilmAlreadyExists();

		}	 

		films.add(newFilm);
		//items.add(newFilm);

	}

	/**
	 * Ajouter un nouvel item de livre au <i>SocialNetwork</i> 
	 * 
	 * @param pseudo le pseudo du membre
	 * @param password le password du membre 
	 * @param titre le titre du livre
	 * @param genre son genre (roman, essai, etc.)
	 * @param auteur l'auteur
	 * @param nbPages le nombre de pages
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si le genre n'est pas instancié. </li>
	 *  <li>  si l'auteur n'est pas instancié. </li>
	 *  <li>  si le nombre de pages n'est pas positif.  </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws ItemBookAlreadyExists item livre de même titre  déjà présent (même titre : indifférent à la casse  et aux leadings et trailings blanks)
	 * 
	 * 
	 */
	public void addItemBook(String pseudo, String password, String titre, String genre, String auteur, int nbPages) throws  BadEntry, NotMember, ItemBookAlreadyExists{
		if(pseudo == null)
			throw new BadEntry("Erreur: pseudo non instancié");
		if(pseudo.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractère autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancié");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caractères autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancié");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractère autre que des espaces");
		if(genre == null)
			throw new BadEntry("Erreur: genre non instancié");
		if(auteur == null)
			throw new BadEntry("Erreur: auteur non instancié");
		if(nbPages <= 0)
			throw new BadEntry("Erreur: nombres Pages négative");
		Book newBook = new Book(titre, genre, auteur, nbPages);
		for (Book m : books) {
			if (m.getTitre().equalsIgnoreCase(newBook.getTitre()))
				throw new ItemBookAlreadyExists();		

		}
		//items.add(newBook);
		books.add(newBook);

	}	 

	/**
	 * @return un film
	 * 
	 */
	public Film getFilm(String titre){
		for(Film film:films){
			if(film.getTitre().equalsIgnoreCase(titre))
				return film;			
		}
		return null;

	}

	/**
	 * @return un livre
	 * 
	 */
	public Book getBook(String titre){
		for(Book book:books){
			if(book.getTitre().equalsIgnoreCase(titre))
				return book;			
		}
		return null;

	}

	/**
	 * @return un membre
	 * 
	 */

	public Member getMember(String pseudo){
		for(Member member:members){
			if(member.getPseudo().equalsIgnoreCase(pseudo))
				return member;			
		}
		return null;

	}
	
	public Member getMember(String pseudo, String password) throws NotMember{
		for (Member member : members) {
			if( member.getPseudo().equalsIgnoreCase(pseudo)){
				if(member.getPassword().equalsIgnoreCase(password)){
					return member;
				}
				else{
					throw new NotMember("le pseudo et le password ne correspondent pas");
				}
			}
		}

		throw new NotMember("aucun membre inscrit avec ces identifiants");
	}

	public void setReview(Review review) {
		this.review = review;
	}

	/**
	 * Consulter les items du <i>SocialNetwork</i> par nom
	 * 
	 * @param nom son nom (eg. titre d'un film, d'un livre, etc.)
	 * 
	 * @throws BadEntry : si le nom n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 * 
	 * @return LinkedList <String> : la liste des représentations de tous les items ayant ce nom 
	 * Cette représentation contiendra la note de l'item s'il a été noté.
	 * (une liste vide si aucun item ne correspond) 
	 */	
	public LinkedList <String> consultItems(String nom) throws BadEntry {
		LinkedList<String> result = new LinkedList<String>();
		if(nom == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(nom.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");	
		film = getFilm(nom);
		book = getBook(nom);
		if(film !=null)
			result.add(film.toString());
		if(book !=null)
			result.add(book.toString());
		return result;
	}

	/**
	 * Consulter les items du <i>SocialNetwork</i> par mot clé
	 * 
	 * @param nom son nom (eg. titre d'un film, d'un livre ou les deux)
	 * @return LinkedList <String> : la liste des représentations de tous les items qui contient ce mot 
	 * Cette représentation contiendra la note de l'item s'il a été noté.
	 * (une liste vide si aucun item ne correspond) 
	 */	

	public LinkedList <String> consultFilmsEtLivres(String nom) throws BadEntry {

		LinkedList<String> result = new LinkedList<String>();
		if(nom == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(nom.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");	
		
		for(Film film : films){ 
			if (film.getTitre().trim().toLowerCase().contains(nom)){
				result.add(film.toStringRecherche());
			}

		}
		for(Book book : books){ 
			if (book.getTitre().trim().toLowerCase().contains(nom)){
				result.add(book.toStringRecherche());
			}

		}
		return result;
	}

	/**
	 * Donner son opinion sur un item film.
	 * Ajoute l'opinion de ce membre sur ce film au <i>SocialNetwork</i> 
	 * Si une opinion de ce membre sur ce film  préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo pseudo du membre émettant l'opinion
	 * @param password son mot de passe
	 * @param titre titre du film  concerné
	 * @param note la note qu'il donne au film 
	 * @param commentaire ses commentaires
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si la note n'est pas comprise entre 0.0 et 5.0. </li>
	 *  <li>  si le commentaire n'est pas instancié. </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws NotItem : si le titre n'est pas le titre d'un film.
	 * 
	 * @return la note moyenne des notes sur ce film  
	 */
	public float reviewItemFilm(String pseudo, String password, String titre, float note, String commentaire) throws BadEntry, NotMember, NotItem {
		if(pseudo == null)
			throw new BadEntry("Erreur: pseudo non instancie");
		if(pseudo.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractere autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancie");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caracteres autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");
		if(commentaire == null)
			throw new BadEntry("Erreur: commentaire non instancie");
		if(note < 0 || note > 5)
			throw new BadEntry("Erreur: note non comprise entre 0.0 et 5.0");
		
		film = getFilm(titre);
		if(film==null)
			throw new NotItem("Film n'existe pas");
		member = getMember(pseudo);
		this.getMember(pseudo, password);
		if(member==null)
			throw new NotMember("Member n'existe pas");
		Review review = member.getItemReview(film);
		if(review==null){
			Review newReview = new Review(note, commentaire,film, member);
			film.addReview(newReview);
			member.addReview(newReview);
		}
		else{
			review.updateReview(note, commentaire);
			Review oldReviewFilm = film.getReview(member);
			oldReviewFilm.updateReview(note, commentaire);
		}

		return film.note();
	}



	/**
	 * Donner son opinion sur un item livre.
	 * Ajoute l'opinion de ce membre sur ce livre au <i>SocialNetwork</i> 
	 * Si une opinion de ce membre sur ce livre  préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo pseudo du membre émettant l'opinion
	 * @param password son mot de passe
	 * @param titre titre du livre  concerné
	 * @param note la note qu'il donne au livre 
	 * @param commentaire ses commentaires
	 * 
	 * @throws BadEntry :
	 * <ul>
	 *  <li>  si le pseudo n'est pas instancié ou a moins de 1 caractère autre que des espaces .  </li>
	 *  <li>  si le password n'est pas instancié ou a moins de 4 caractères autres que des leadings or trailing blanks. </li>
	 *  <li>  si le titre n'est pas instancié ou a moins de 1 caractère autre que des espaces.  </li>
	 *  <li>  si la note n'est pas comprise entre 0.0 et 5.0. </li>
	 *  <li>  si le commentaire n'est pas instancié. </li>
	 * </ul><br>       
	 * @throws NotMember : si le pseudo n'est pas celui d'un membre ou si le pseudo et le password ne correspondent pas.
	 * @throws NotItem : si le titre n'est pas le titre d'un livre.
	 * 
	 * @return la note moyenne des notes sur ce livre
	 */
	public float reviewItemBook(String pseudo, String password, String titre, float note, String commentaire) throws BadEntry, NotMember, NotItem {
		if(pseudo == null)
			throw new BadEntry("Erreur: pseudo non instancie");
		if(pseudo.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractere autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancie");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caracteres autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");
		if(commentaire == null)
			throw new BadEntry("Erreur: commentaire non instancie");
		if(note < 0 || note > 5)
			throw new BadEntry("Erreur: note non comprise entre 0.0 et 5.0");
		
		book = getBook(titre);
		if(book==null)
			throw new NotItem("Book n'existe pas");
		member = getMember(pseudo);
		this.getMember(pseudo, password);
		if(member==null)
			throw new NotMember("Member n'existe pas");
		Review review = member.getItemReview(book);
		if(review==null){
			Review newReview = new Review(note, commentaire,book, member);
			book.addReview(newReview);
			member.addReview(newReview);
		}
		else{
			review.updateReview(note, commentaire);
			Review oldReviewFilm = book.getReview(member);
			oldReviewFilm.updateReview(note, commentaire);
		}
		return book.note();
	}


	/**
	 * Donner une opinion sur un avis existant (avis sur un livre)
	 * @param pseudo1 pseudo du membre qui va donner l'avis
	 * @param password mot de passe du membre
	 * @param titre Titre du livre
	 * @param pseudo2 pseudo du membre qui a donné un avis sur le livre
	 * @param commentaire les commentaires
	 * @param note la note attribuée
	 * @return la moyenne 
	 * @throws BadEntry
	 * @throws NotItem 
	 * @throws NotMember
	 */
	public float reviewOpinionBook(String pseudo1,String password,String titre,String pseudo2,String commentaire,float note) throws BadEntry, NotItem, NotMember{		
		if(pseudo1 == null || pseudo2 == null)
			throw new BadEntry("Erreur: pseudo non instancie");
		if(pseudo1.trim().length() < 1 || pseudo2.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractere autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancie");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caracteres autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");
		if(commentaire == null)
			throw new BadEntry("Erreur: commentaire non instancie");
		if(note < 0 || note > 5)
			throw new BadEntry("Erreur: note non comprise entre 0.0 et 5.0");
		this.getMember(pseudo1, password);
		book = getBook(titre);
		if(book==null)
			throw new NotItem("Book n'existe pas");
		member = getMember(pseudo1);
		if(member==null)
			throw new NotMember("Member n'existe pas");
		member2 = getMember(pseudo2);
		if(member2==null)
			throw new NotMember("Member n'existe pas");
		Review review = book.getReview(member2);
		if(review!=null){
			ReviewOfReview review2 = new ReviewOfReview(member,commentaire,note);
			review.addReview(review2);		
		}
		else{
			System.out.println("exception: review n'existe pas");			
		}		
		return review.getMoyenne();			
	}


	/**
	 * Donner une opinion sur un avis existant (avis sur un film)
	 * @param pseudo1 pseudo du membre qui va donner l'avis
	 * @param password mot de passe du membre
	 * @param titre Titre du film
	 * @param pseudo2 pseudo du membre qui a donné un avis sur le film
	 * @param commentaire les commentaires
	 * @param note la note attribuée
	 * @return la moyenne 
	 * @throws BadEntry
	 * @throws NotItem 
	 * @throws NotMember
	 */
	public float reviewOpinionFilm(String pseudo1,String password,String titre,String pseudo2,String commentaire,float note) throws BadEntry,NotItem, NotMember{
		if(pseudo1 == null || pseudo2 == null)
			throw new BadEntry("Erreur: pseudo non instancie");
		if(pseudo1.trim().length() < 1 || pseudo2.trim().length() < 1)
			throw new BadEntry("Erreur: Le pseudo contient moins de 1 caractere autre que des espaces");
		if(password == null)
			throw new BadEntry("Erreur: password non instancie");
		if(password.trim().length() < 4)
			throw new BadEntry("Erreur: Le password contient moins de 4 caracteres autre que des espaces");
		if(titre == null)
			throw new BadEntry("Erreur: titre non instancie");
		if(titre.trim().length() < 1)
			throw new BadEntry("Erreur: Le titre contient moins de 1 caractere autre que des espaces");
		if(commentaire == null)
			throw new BadEntry("Erreur: commentaire non instancie");
		if(note < 0 || note > 5)
			throw new BadEntry("Erreur: note non comprise entre 0.0 et 5.0");
		this.getMember(pseudo1, password);

		film = getFilm(titre);
		if(film==null)
			throw new NotItem("Book n'existe pas");
		member = getMember(pseudo1);
		if(member==null)
			throw new NotMember("Member n'existe pas");
		member2 = getMember(pseudo2);
		if(member2==null)
			throw new NotMember("Member n'existe pas");
		Review review = film.getReview(member2);
		if(review!=null){		
			ReviewOfReview review2 = new ReviewOfReview(member,commentaire,note);
			review.addReview(review2);		
		}
		else{
			System.out.println("exception: review n'existe pas");			
		}		
		return review.getMoyenne();						
	}

	/**
	 * Obtenir une représentation textuelle du <i>SocialNetwork</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle du <i>SocialNetwork</i> 
	 */
	@Override
	public String toString() {
		int nbBook =nbBooks();		
		int nbFilm = nbFilms();
		int nbMember=nbMembers();
		return "Social Network contient "+nbMember+" membres et "+nbFilm+" films et "+nbBook+" livres";
	}

}
