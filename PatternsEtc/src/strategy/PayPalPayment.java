package strategy;

public class PayPalPayment implements PaymentStrategy{
	private final String paypalUsername;
	private final String paypalPassword;

	public PayPalPayment(String paypalUsername, String paypalPassword) {
		super();
		this.paypalUsername = paypalUsername;
		this.paypalPassword = paypalPassword;
	}


	@Override
	public void pay(int amount) {
		System.out.println("Paying user paypal account:  " + this.paypalUsername);
	}

}
