package refactoring.after;

import java.util.List;

public class BrowserFeature {

	private BrowserInfo browserInfo;
	private List<DisplayElement> elements;
	private DisplayElement menu = null;
	
	public BrowserFeature(BrowserInfo browserInfo, List<DisplayElement> elements) {
		this.browserInfo = browserInfo;
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

	public void adjustFormat() {
		if (menuRenderNeeded()) {
			renderMenu();
		}
	}
	
	private void renderMenu() {
		menu.render();
	}

	private boolean menuRenderNeeded() {
		return browserInfo.isWindows8() && 
			   browserInfo.isRunningUnder32bitEmulation() &&
			   browserInfo.isChromeVersion27() &&
			   isMenuTainted();
	}
	
	private boolean isMenuTainted() {
		return menu.getState() == DisplayElementState.TAINTED;
	}

}
