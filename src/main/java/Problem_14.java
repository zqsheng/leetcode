public class Problem_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.length() == 0) {
                return prefix;
            }
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;
    }
}
