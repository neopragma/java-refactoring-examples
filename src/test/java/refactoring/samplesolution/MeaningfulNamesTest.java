package refactoring.samplesolution;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MeaningfulNamesTest {
	
	@Test
	public void itCollectsAllTheMarkedCellsInTheGrid() {
		MeaningfulNames testSubject = new MeaningfulNames();
		List<Cell> grid = new ArrayList<Cell>();
		grid.add(new Cell( 0, 4, 3, 2 ));
		grid.add(new Cell( 4, 5, 4, 3 ));
		grid.add(new Cell( 1, 4, 3, 2 ));
		grid.add(new Cell( 4, 8, 0, 2 ));
        List<Cell> markedCells = new ArrayList<Cell>();
		markedCells.add(new Cell( 4, 5, 4, 3 ));
		markedCells.add(new Cell( 4, 8, 0, 2 ));
        assertArrayEquals(markedCells.toArray(),  testSubject.collectMarkedCells(grid).toArray());
	}

}
