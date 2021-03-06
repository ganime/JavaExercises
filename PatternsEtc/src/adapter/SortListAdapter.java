package adapter;

import java.util.ArrayList;
import java.util.List;

import strategy.SortingStrategy;

public class SortListAdapter implements Sorter {
	private final SortingStrategy sortingStrategy;

	public SortListAdapter(SortingStrategy sortingStrategy) {
		super();
		this.sortingStrategy = sortingStrategy;
	}

	@Override
	public int[] sort(int[] arr) {
		ArrayList<Integer> numbersAsList = new ArrayList<Integer>(arr.length);
		for(int i=0; i< arr.length; i++) {
			numbersAsList.add(arr[i]);
		}
		NumberSorter sorter = new NumberSorter();
		List<Integer> retList= sorter.sort(numbersAsList, sortingStrategy);
		
		int[] returnArr = new int[retList.size()];
		int i=0;
		for(Integer number: retList) {
			returnArr[i++] = number;
		}
		return returnArr;
	}
}
