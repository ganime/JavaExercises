package strategy;

import java.util.Collections;
import java.util.List;

public class DefaultSortStrategy implements SortingStrategy {

	@Override
	public void sort(List<Integer> list) {
		Collections.sort(list);
	}

}
