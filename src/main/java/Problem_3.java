import java.util.HashMap;
import java.util.Map;

public class Problem_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_0("abcdfd"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            int e = i + 1;
            String substring = s.substring(i, e);
            while (e < s.length() && !substring.contains(Character.toString(s.charAt(e++)))){
                n = Math.max(n,e - i);
                substring = s.substring(i,e);
            }
        }
        return n;
    }

    public static int lengthOfLongestSubstring_0(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);

        }
        return max;
    }
}
