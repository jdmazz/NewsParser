import org.jsoup.select.Elements;

public class JSHelp {
	public static String[] toStrArr(Elements elems) {
		String[] strs = new String[elems.size()];
        for (int i = 0; i < elems.size(); ++i) {
        	strs[i] = elems.get(i).text();
        }
        return strs;
	}
	
	public static StrPair[] toStrPairs(Elements elems) {
		StrPair[] strPairs = new StrPair[elems.size()];
        for (int i = 0; i < elems.size(); ++i) {
        	strPairs[i] = new StrPair(elems.get(i).text(), elems.get(i).attr("href"));
        }
        return strPairs;
	}
}
