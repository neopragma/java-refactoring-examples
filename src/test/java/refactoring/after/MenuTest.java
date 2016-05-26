package refactoring.after;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MenuTest {
	
	private Menu menu;
	
	@Before
	public void beforeEachTestCase() {
		menu = new Menu();
	}
	
	@Test
	public void whenMenuIsCreatedItIsTainted() {
		assertEquals(DisplayElementState.TAINTED, menu.getState());
	}
	
	@Test
	public void whenMenuIsRenderedItIsUntainted() {
		menu.render();
		assertEquals(DisplayElementState.CLEAN, menu.getState());
	}

}
