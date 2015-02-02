package visitor;

public class Film extends Item implements Shippable {

	public Film(String name, double price) {
		super(name, price);
	}

	@Override
	public void send(Shipper shipper) {
		shipper.ship(this);
	}
}
