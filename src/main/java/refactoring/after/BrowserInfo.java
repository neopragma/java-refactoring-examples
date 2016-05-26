package refactoring.after;
import javax.servlet.http.HttpServletRequest;

public class BrowserInfo {
	private static final String CHROME_27 = "Chrome/27";
	private static final String WOW64 = "WOW64";
	private static final String WINDOWS_NT_6 = "Windows NT 6";
	private static final String USER_AGENT = "user-agent";
	private String userAgent;

	public BrowserInfo(HttpServletRequest request) {
		userAgent = request.getHeader(USER_AGENT);
	}
	
	public boolean isWindows8() {
		return userAgent.indexOf(WINDOWS_NT_6) > -1;
	}
	
	public boolean isRunningUnder32bitEmulation() {
		return userAgent.indexOf(WOW64) > -1;
		
	}
	
	public boolean isChromeVersion27() {
		return userAgent.indexOf(CHROME_27) > -1;		
	}

}
