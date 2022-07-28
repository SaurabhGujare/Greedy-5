// Time Complexity : O(S*P)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sl = s.length();
            int pl = p.length();
            int pp  = 0;
            int pStar = -1;
            int sp = 0;
            int sStar = -1;

            while(sp < sl) {
                if(pp < pl && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                    pp++;
                    sp++;
                } else if(pp < pl && p.charAt(pp) == '*') {
                    pStar = pp;
                    sStar = sp;
                    pp++;
                } else if(pStar == -1) {
                    return false;
                } else {
                    pp = pStar + 1;
                    sp = sStar + 1;
                    sStar = sp;
                }
            }

            while(pp<pl) {
                if(p.charAt(pp) != '*')
                    return false;
                pp++;
            }
            return true;
        }
    }
}
