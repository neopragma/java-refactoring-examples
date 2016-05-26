package refactoring.samplesolution;

import java.util.Arrays;

public class Cell {
	
	private static final int MARKED = 4;
	private Integer[] values;
	
	public Cell(Integer... values) {
		this.values = values;
	}
	
	public boolean isMarked() {
		return values[0] == MARKED;
	}
	
	public Integer[] getValues() {
		return values;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}
}