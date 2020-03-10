public class Problem_263 {

    public static void main(String[] args) {
        int n = 30;
        n = mod(n,2);
        n = mod(n,3);
        n = mod(n,5);
        System.out.println(n == 1);
    }
    private static int mod(int n,int d) {
        while (n % d == 0) {
            n /= d;
        }
        return n;
    }
}
