package test.adapter;

import org.junit.Before;
import org.junit.Test;

import strategy.ShoppingCart;
import visitor.Book;
import visitor.DomesticShipper;
import visitor.Film;

import junit.framework.TestCase;

public class VisitorTest extends TestCase {	
	
	Book book1 = new Book("Book 1", 10);
	Book book2 = new Book("Book 2", 20);
	Film film1 = new Film("Film 1", 50);
	ShoppingCart cart;

	@Before
	public void setUp() throws Exception {
		cart = new ShoppingCart();
	}
	
	@Test
	public void testBook() {
		cart.addItem(book1);
		cart.addItem(book2);
		assertEquals(3.0, cart.calculatePostage());
		cart.addItem(film1);
		assertEquals(5.5, cart.calculatePostage());
	}
}
