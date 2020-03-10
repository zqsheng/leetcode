public class Problem_12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman_0(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int n_1000 = num / 1000;
        num -= n_1000 * 1000;

        int n_900 = num / 900;
        num -= n_900 * 900;

        int n_500 = num / 500;
        num -= n_500 * 500;

        int n_400 = num / 400;
        num -= n_400 * 400;

        int n_100 = num / 100;
        num -= n_100 * 100;

        int n_90 = num / 90;
        num -= n_90 * 90;

        int n_50 = num / 50;
        num -= n_50 * 50;

        int n_40 = num / 40;
        num -= n_40 * 40;

        int n_10 = num / 10;
        num -= n_10 * 10;

        int n_9 = num / 9;
        num -= n_9 * 9;

        int n_5 = num / 5;
        num -= n_5 * 5;

        int n_4 = num / 4;
        num -= n_4 * 4;
        for (int i = 0; i < n_1000; i++) {
            sb.append("M");
        }
        for (int i = 0; i < n_900; i++) {
            sb.append("CM");
        }
        for (int i = 0; i < n_500; i++) {
            sb.append("D");
        }
        for (int i = 0; i < n_400; i++) {
            sb.append("CD");
        }
        for (int i = 0; i < n_100; i++) {
            sb.append("C");
        }
        for (int i = 0; i < n_90; i++) {
            sb.append("XC");
        }
        for (int i = 0; i < n_50; i++) {
            sb.append("L");
        }
        for (int i = 0; i < n_40; i++) {
            sb.append("XL");
        }
        for (int i = 0; i < n_10; i++) {
            sb.append("X");
        }
        for (int i = 0; i < n_9; i++) {
            sb.append("IX");
        }
        for (int i = 0; i < n_5; i++) {
            sb.append("V");
        }
        for (int i = 0; i < n_4; i++) {
            sb.append("IV");
        }
        for (int i = 0; i < num; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public static String intToRoman_0(int num) {
        StringBuilder sb = new StringBuilder();
        int[] vals = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        String[] strs = new String[] {"M", "CM", "D","CD","C","XC","L","XL","X", "IX", "V", "IV", "I" };
        int index = 0;
        int n = num;
        while (index < 13) {
            int t = n / vals[index];
            int i = 0;
            while (i < t) {
                sb.append(strs[index]);
                i++;
            }
            n -= t * vals[index++];
        }
        return sb.toString();
    }
}
