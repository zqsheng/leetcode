public class Problem_test_5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy"));
        System.out.println(replaceSpace_1("We are happy"));
    }
    public static String replaceSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0,i) + "%20" +  s.substring(i + 1);
                i += 2;
            }
        }
        return s;
    }
    public static String replaceSpace_1(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
