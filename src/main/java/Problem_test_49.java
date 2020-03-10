public class Problem_test_49 {
    public static void main(String[] args) {

    }
    public static int nthUglyNumber(int n) {
        int curr = 0,p1,p2,p3;
        int i = 0;
        switch (n) {
            case 1:
                curr = 1;
                i = 1;
                break;
            case 2:
                curr = 2;
                i = 2;
                break;
            case 3:
                curr = 3;
                i = 3;
                break;
            case 4:
                curr = 5;
                i = 4;
                break;
            default:
                p1 = 5;
                p2 = 3;
                p3 = 2;
                for (; i < n; i++) {
                    

                }
        }
        return curr;
    }
}
