package lys.javabase.clone;

public class Card implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private int cardNum;
	
	private String cardType;

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	
}
