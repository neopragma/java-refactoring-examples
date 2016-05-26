package refactoring.samplesolution;

import java.util.ArrayList;
import java.util.List;

public class MeaningfulNames {
	
	/**
	 * Collect all the marked cells in the grid.
	 * @param grid - List of all cells in the grid.
	 * @return List of all marked cells in the grid.
	 */
	public List<Cell> collectMarkedCells(List<Cell> grid) {
	    List<Cell> markedCells = new ArrayList<Cell>();
	    for (Cell cell : grid) {
	        if (cell.isMarked()) {
	            markedCells.add(cell);
	        }
	    }
	    return markedCells;
	}

}
