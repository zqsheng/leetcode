public class Problem_test_15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.MAX_VALUE));
        System.out.println(hammingWeight_1(Integer.MAX_VALUE));
    }
    public static int hammingWeight(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }

    public static int hammingWeight_1(int n) {
        int i = 0;
        while (n != 0){
            if((n & 1) == 1) {
                i++;
            }
            n >>= 1;
        }
        return i;
    }
}
