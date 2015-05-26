package lys.javabase.clone;

public class Person implements Cloneable {

	@Override
	protected Person clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Person person = (Person)super.clone();
		person.card = (Card)card.clone();
		
		return person;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", card=" + card + "]";
	}

	private int id;
	
	private String name;

	private Card card;
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
