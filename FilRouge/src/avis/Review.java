package avis;

import java.util.LinkedList;

public class Review {
	private float note;
	private String commentaire;
	private Member member;
	private Item item;
	private LinkedList<String> reviewOpinions;
	private float noteReview; 
	private LinkedList <ReviewOfReview> listeReviewOfReview = new LinkedList <ReviewOfReview>();

	
	public Review(float note, String commentaire,  Item item,Member member) {
		this.note = note;
		this.commentaire = commentaire;
		this.item = item;
		this.member = member;
		
	}
	
	public Review(Member member,Member member2,float noteReview) {
		this.noteReview = noteReview;
		this.member = member;
		this.member = member2;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public float getNoteReview() {
		return noteReview;
	}
	public void setNoteReview(float noteReview) {
		this.noteReview = noteReview;
	}
	
	public void addReview(Member member, float note, String commentaire){
		listeReviewOfReview.add(new ReviewOfReview(member, commentaire, note));
	
	}
	
	public float getMoyenne(){
		int nbAvis = 0;
		float sommeNote = 0;

		for(ReviewOfReview a : listeReviewOfReview){
			sommeNote += a.getNote();
			nbAvis++;
		}
		
		if(nbAvis==0) 	
			return 0;
		else			
			return sommeNote/nbAvis;
	}
	
	
	public void noteReviewUpdate(float noteReview){
		this.noteReview=noteReview;
	}
	
	public void updateReview(float note,String commentaire){
		this.note=note;
		this.commentaire=commentaire;
		
	}
	
}
