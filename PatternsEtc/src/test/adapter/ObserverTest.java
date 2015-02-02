package test.adapter;

import static org.junit.Assert.*;

import observer.DataStore;
import observer.Screen;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {

	DataStore ds;
	Screen screen1;
	Screen screen2;
	
	@Before
	public void setUp() throws Exception {
		ds =  new DataStore();
		screen1 = new Screen("1");
		screen2 = new Screen("2");
		ds.addObserver(screen1);
		ds.addObserver(screen2);
	}

	@Test
	public void test() {
		ds.setData("Data 1");
	}

	@Test
	public void testDetach() {
		ds.deleteObserver(screen1);
		ds.setData("Data 1");
	}

}
