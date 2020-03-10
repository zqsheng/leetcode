public class Problem_172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(12600));
    }
    public static int trailingZeroes(int n) {
        int t = 0,t1 = 5;
        while (t1 <= n) {
            t++;
            t1 *= 5;
        }
        int k = 0, k1 = 0;
//        while ()
        return t;
    }
}