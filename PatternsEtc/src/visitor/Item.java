package visitor;

public abstract class Item implements Shippable {
	private String name;
	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	private double price;
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
