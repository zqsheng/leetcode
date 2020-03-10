import org.omg.CORBA.INTERNAL;
import sun.security.krb5.internal.crypto.Aes128;

import java.math.BigInteger;
import java.util.*;

public class Problem_8 {

    static Map<Character,Character> map = new HashMap<>();

    static {
        map.put('-','-');
        map.put('0','0');
        map.put('1','1');
        map.put('2','2');
        map.put('3','3');
        map.put('4','4');
        map.put('5','5');
        map.put('6','6');
        map.put('7','7');
        map.put('8','8');
        map.put('9','9');
    }
    public static int myAtoi(String str) {
        List<Character> list = new ArrayList<>();
        boolean b = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && b) {
                continue;
            }
            Character c1 = map.get(c);
            if (c1 != null) {
                list.add(c);
                b = false;
            } else {
                break;
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        char[] ch = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ch[i] = list.get(i);
        }
//        BigInteger.valueOf(String.valueOf(ch));
        Long l = null;
        try {
            l = Long.valueOf(String.valueOf(ch));
        } catch (NumberFormatException e) {
            return 0;
        }
        return Long.valueOf(l < 0 ? Math.max(l, Integer.MIN_VALUE) : Math.min(l,Integer.MAX_VALUE)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
    }
}
