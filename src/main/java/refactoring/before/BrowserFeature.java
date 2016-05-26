package refactoring.before;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class BrowserFeature {

	private HttpServletRequest request;
	private List<DisplayElement> elements;
	private DisplayElement menu = null;
	
	public BrowserFeature(HttpServletRequest request, List<DisplayElement> elements) {
		this.request = request;
		this.elements = elements;
		menu = findMenu();
	}
	
	private DisplayElement findMenu() {
		for (DisplayElement element : elements) {
			if (element.getType() == DisplayElementType.MENU) {
				return element;
			}
		}
		return null;
	}
	
	private void renderMenu() {
		menu.render();
	}

	public void adjustFormat() {
		String userAgent = request.getHeader("user-agent");
		// If Chrome version 27 is running in 32-bit mode on 64-bit Windows 8,
		// we have to tweak the menu layout after a resize.
		if (userAgent.indexOf("Windows NT 6") > -1 &&
			    userAgent.indexOf("WOW64") > -1 &&
			    userAgent.indexOf("Chrome/27") > -1 &&
			    menu.getState() == DisplayElementState.TAINTED) {
			renderMenu();
		}
	}

}
