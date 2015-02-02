package visitor;

public class Book extends Item {

	public Book(String name, double price) {
		super(name, price);
	}

	@Override
	public void send(Shipper shipper) {
		shipper.ship(this);
	}
}
