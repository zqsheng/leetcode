public class Problem_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("zttzfsknks"));
    }

    // TODO 未达最优
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {return s;}
        int max = 1;
        String res = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            int b = i - 1, e = i + 1, m = 1;
            char c = s.charAt(i);
            int t = 0 ;
            while (t < s.length() - i && c == s.charAt(t + i)) {
                t++;
            }
            if (t > 1) {
                if (t % 2 == 0) {
                    i = i + t / 2;
                    b = i - 1;
                    e = i;
                    m = 0;
                } else {
                    i = i + t / 2;
                    b = i - 1;
                    e = i + 1;
                }
            }
            while (b >= 0 && e < s.length()) {
                if (s.charAt(b--) == s.charAt(e++)) {
                    m += 2;
                    if (m > max) {
                        max = m;
                        res = s.substring(b + 1,e);
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
