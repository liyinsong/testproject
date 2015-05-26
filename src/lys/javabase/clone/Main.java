package lys.javabase.clone;

public class Main {

	public static void main(String[] args) {
		
		Card card = new Card();
		card.setCardNum(1);
		card.setCardType("master");
		
		System.out.println("Card1 class: " + card.hashCode());
		
		Person p = new Person();
		p.setCard(card);
		p.setId(2);
		p.setName("ERIC");
		
		System.out.println("p class: " + p.hashCode());
		
		try {
			Person p2 = p.clone();
			System.out.println("p2 Class: " + p2.hashCode());
			System.out.println("Card2 class: " + p2.getCard().hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			System.err.println("clone error");
		}
		
		
	}

}
