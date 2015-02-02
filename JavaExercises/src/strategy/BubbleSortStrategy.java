package strategy;

import java.util.List;

public class BubbleSortStrategy implements SortingStrategy {

	@Override
	public void sort(List<Integer> list) {
		int size = list.size();
		for(int i=0; i < size -1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (list.get(i) > list.get(j)) {
					Integer temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

}
