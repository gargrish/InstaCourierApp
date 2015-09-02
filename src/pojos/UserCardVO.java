package pojos;

public class UserCardVO {
	private long cardNumber;
	private int cvv;
	private int expDate;
	private int expYear;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getExpDate() {
		return expDate;
	}

	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

}
