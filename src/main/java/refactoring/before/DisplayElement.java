package refactoring.before;

public abstract class DisplayElement {
	
	private DisplayElementType type;
	private DisplayElementState state = DisplayElementState.TAINTED;
	
	public void render() { 
		state = DisplayElementState.CLEAN;
	}
	
	public void taint() {
		state = DisplayElementState.TAINTED;
	}
	
	public DisplayElementType getType() {
		return type;
	}
	
	public DisplayElementState getState() {
		return state;
	}

}
