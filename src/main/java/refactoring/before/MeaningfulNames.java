package refactoring.before;

import java.util.ArrayList;
import java.util.List;

public class MeaningfulNames {
	
	/**
	 * Get the list
	 * @param theList
	 * @return list1
	 */
	public List<int[]> getList(List<int[]> theList) {
	    List<int[]> list1 = new ArrayList<int[]>();
	    for (int[] x : theList) {
	        if (x[0] == 4) {
	            list1.add(x);
	        }
	    }
	    return list1;
	}

}
