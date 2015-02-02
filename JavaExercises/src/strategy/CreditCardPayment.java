package strategy;

public class CreditCardPayment implements PaymentStrategy {
	private final String creditCardNo;
	private final int expiryDateMonth;
	private final int expiryDateYear;
	private final int cvvCode;
	
	public CreditCardPayment(String creditCardNo, int expiryDateMonth,
			int expiryDateYear, int cvvCode) {
		super();
		this.creditCardNo = creditCardNo;
		this.expiryDateMonth = expiryDateMonth;
		this.expiryDateYear = expiryDateYear;
		this.cvvCode = cvvCode;
	}
	@Override
	public void pay(int amount) {
		System.out.println("Paying with credit card :" + creditCardNo);
	}

}
