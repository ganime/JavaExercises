package adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import strategy.SortingStrategy;

public class NumberSorter{
	public List<Integer> sort (List<Integer> numbers, SortingStrategy sortingStrategy) {
		ArrayList<Integer> nos = new ArrayList<Integer>(numbers);
		
		Collections.copy(nos, numbers);
		
		sortingStrategy.sort(nos);
		
		return nos;
	}
}
