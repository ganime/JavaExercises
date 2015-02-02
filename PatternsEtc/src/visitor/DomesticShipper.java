package visitor;

public class DomesticShipper implements Shipper {
	double totalPandP = 0;

	@Override
	public void ship(Book book) {
		double pAndP = book.getPrice() * 0.1;
		totalPandP += pAndP;
	}

	@Override
	public void ship(Film cd) {
		double pAndP = cd.getPrice() * 0.05;
		totalPandP += pAndP;
	}

	public double getTotalPandP() {
		return totalPandP;
	}
}
