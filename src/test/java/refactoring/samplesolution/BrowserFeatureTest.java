package refactoring.samplesolution;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BrowserFeatureTest {
	
	private BrowserFeature browserFeature;
	@Mock private HttpServletRequest request;
	@Mock private BrowserInfo browserInfo;
	@Mock private DisplayElement menu;
	private List<DisplayElement> elements;
	
	@Test
	public void itRendersMenu_whenTainted_for_Chrome27_Windows8_WOW64() {
        setupMenuRenderTestCase();
		browserFeature.adjustFormat();
		verify(menu).render();
	}
	
	@Test
	public void itDoesNotRenderMenu_whenNotTainted_for_Chrome27_Windows8_WOW64() {
        setupMenuRenderTestCase();
        when(menu.getState()).thenReturn(DisplayElementState.CLEAN);
		browserFeature.adjustFormat();
		verify(menu, never()).render();
	}
	
	private void setupMenuRenderTestCase() {
		when(browserInfo.isChromeVersion27()).thenReturn(true);
        when(browserInfo.isWindows8()).thenReturn(true);
        when(browserInfo.isRunningUnder32bitEmulation()).thenReturn(true);		
        when(menu.getType()).thenReturn(DisplayElementType.MENU);
        when(menu.getState()).thenReturn(DisplayElementState.TAINTED);
        elements = new ArrayList<DisplayElement>();
        elements.add(menu);
		browserFeature = new BrowserFeature(browserInfo, elements);
	}

}
