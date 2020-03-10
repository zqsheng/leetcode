
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_7 {

    private static int reverse(int x) {
        String s = Long.valueOf(Math.abs((long)x)).toString();
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        Collections.reverse(chars);
        char[] cc = new char[s.length()];
        for (int i = 0; i < chars.size(); i++) {
            cc[i] = chars.get(i);
        }
        String s1 = String.valueOf(cc);
        Long l = Long.valueOf(s1);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        Integer i = Integer.valueOf(s1);
        return x > 0 ? i : -i;
    }

    public static void main(String[] args) {
       System.out.println(reverse(-2147483648));
//        System.out.println(Integer.valueOf("-0003"));
    }

}
