package avis;

public class ReviewOfReview{
	private Member member;
	private String commentaire;
	private float note;

		/**
		 * Constructeur de la classe AvisDavis
		 * @param auteur membre correspondant à l'auteur
		 * @param commentaire chaîne de caractères du commentaire
		 * @param note réel représentant la note attribuée
		 */
		public ReviewOfReview(Member member, String commentaire, float note) {
			this.member=member;
			this.commentaire=commentaire;
			this.note=note;			
		}				
		
		public Member getMember() {
			return member;
		}

		public void setMember(Member member) {
			this.member = member;
		}
		
		public String getCommentaire() {
			return commentaire;
		}
		
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
     	public float getNote() {
			return note;
		}
		public void setNote(float note) {
			this.note = note;
		}
		
		public String toString() {
			String s = null;
			
			s = "			Avis de "+member.getPseudo();
			s += "\n			Commentaire : "+commentaire;
			s += "\n			Note : "+note+"\n\n";
			
			return s;
		}

	}

