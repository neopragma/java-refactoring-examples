package refactoring.before;

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
	
	@Mock private HttpServletRequest request;
	@Mock private DisplayElement menu;
	private List<DisplayElement> elements;
	
	@Test
	public void testRenderMenu() {
		when(request.getHeader("user-agent")).thenReturn("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");
        when(menu.getType()).thenReturn(DisplayElementType.MENU);
        when(menu.getState()).thenReturn(DisplayElementState.TAINTED);
        elements = new ArrayList<DisplayElement>();
        elements.add(menu);
		BrowserFeature browserFeature = new BrowserFeature(request, elements);
		browserFeature.adjustFormat();
		verify(menu).render();
	}

}
