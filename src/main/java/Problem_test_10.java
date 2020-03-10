public class Problem_test_10 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "," + numWays(i));
        }
    }
    public static int fib(int n) {
        switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                int fn1 = 1,fn2 = 0,fn = 0;
                for (int i = 2; i <= n; i++) {
                    fn = (fn1 + fn2) % 1000000007;
                    fn2 = fn1;
                    fn1 = fn;
                }
                return fn;
        }
    }
    public static int numWays(int n) {
        switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int fn1 = 2,fn2 = 1,fn = 0;
                for (int i = 3; i <= n; i++) {
                    fn = (fn1 + fn2) % 1000000007;
                    fn2 = fn1;
                    fn1 = fn;
                }
                return fn;
        }
    }
}
