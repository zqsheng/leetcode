import java.util.HashSet;
import java.util.Set;

public class Problem_202 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
//            System.out.println(isHappy(1));
        }
        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        return isHappy(n,new HashSet<Integer>());
    }
    // TODO set 判断空间复杂度过高
    public static boolean isHappy(int n, Set<Integer> set) {
        int s = 0;
        int l = Integer.valueOf(n).toString().length();
        for (int i = l -1;i >= 0 ;i--) {
            int d = Double.valueOf(Math.pow(10, i)).intValue();
            int t = n / d;
            s += t * t;
            n %= d;
        }
        if (s == 1) {
            return  true;
        } else {
            if (set.contains(s)) {
                return false;
            }
            set.add(s);
            return isHappy(s,set);
        }
    }
}
