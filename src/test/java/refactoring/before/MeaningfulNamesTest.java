package refactoring.before;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import refactoring.before.MeaningfulNames;
import static org.junit.Assert.assertArrayEquals;

public class MeaningfulNamesTest {
	
	@Test
	public void testList() {
		MeaningfulNames thing = new MeaningfulNames();
		List<int[]> aList = new ArrayList<int[]>();
		aList.add(new int[] { 0, 4, 3, 2 });
		aList.add(new int[] { 4, 5, 4, 3 });
		aList.add(new int[] { 1, 4, 3, 2 });
		aList.add(new int[] { 4, 8, 0, 2 });
        List<int[]> bList = new ArrayList<int[]>();
		bList.add(new int[] { 4, 5, 4, 3 });
		bList.add(new int[] { 4, 8, 0, 2 });
        assertArrayEquals(bList.toArray(), thing.getList(aList).toArray());
	}

}
