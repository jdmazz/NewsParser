/* 
 * Note: a generic pair would require array lists (inefficient) instead of arrays
 * we only need string pairs, so this is more efficient and handles all cases
 */
public class StrPair {
    public StrPair(String lh, String rh) {
        this.lh = lh;
        this.rh = rh;
    }

    public String lh() { return lh; }
    public String rh() { return rh; }

    private String lh, rh;
}
