package test.adapter;

import javax.swing.DefaultBoundedRangeModel;

import org.junit.Test;

import strategy.BubbleSortStrategy;
import strategy.DefaultSortStrategy;
import junit.framework.Assert;
import junit.framework.TestCase;


import adapter.SortListAdapter;
import adapter.Sorter;

public class AdapterTest extends TestCase {
	int[] numbers = {3,1,7,5,8};
	
	@Test
	public void testAdapterDefaultSort() {
		Sorter sorter = new SortListAdapter(new DefaultSortStrategy());
		int[] arr = sorter.sort(numbers);
		assertEquals(1, arr[0]);
	}
	
	@Test
	public void testAdapterBubbleSort() {
		Sorter sorter = new SortListAdapter(new BubbleSortStrategy());
		int[] arr = sorter.sort(numbers);
		assertEquals(1, arr[0]);
	}

}
