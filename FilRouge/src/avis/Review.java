package avis;

public class Review {
	private float note;
	private String text;
	private Member member;
	private Item item;
		
	
	public Review(float note, String text, Member member, Item item) {
		this.note = note;
		this.text = text;
		this.member = member;
		this.item = item;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
