public class Problem_13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int[] vals = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        String[] strs = new String[] {"M", "CM", "D","CD","C","XC","L","XL","X", "IX", "V", "IV", "I" };
        int res = 0;
        String is = s;
        while (is.length() > 0) {
            int i = 0;
            while (i < 13) {
                if(is.startsWith(strs[i])) {
                    res += vals[i];
                    is = is.substring(strs[i].length());
                    break;
                }
                i++;
            }
        }
        return res;
    }
}
