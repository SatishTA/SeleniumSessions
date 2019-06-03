//reverse the number
package SeleniumSessions.PackageSeleniumSessions;

public class ERS_TestCom {
	
	public static void main(String[] args) {
	String revstring= revarse("ERS member rate");
	System.out.println(revstring);
	}
public static String revarse(String source) {
	if ((source ==null)|| source.isEmpty()) {
		return source;
	}
	String revarse="";
	for (int i=source.length() -1;i>=0;i--) {
		revarse=revarse + source.charAt(i);
		
	}
	//System.out.println(reverse);
	return revarse;
	
}
}
