import java.util.ArrayList;
import java.util.List;

public class Problem_784 {
    public static void main(String[] args) {
        letterCasePermutation("ai18b2").forEach(System.out::println);
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        back(S.toCharArray(),0,result);
        return result;
    }

    public static void back(char[] arr, int i, List<String> result) {
        while (i < arr.length && Character.isDigit(arr[i])) {
            i++;
        }
        if (arr.length == i) {
            result.add(new String(arr));
            return;
        }
        char ch = arr[i];
        back(arr, i + 1, result);
        if (Character.isLetter(ch)) {
            ch = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
        }
        arr[i] = ch;
        back(arr, i + 1, result);
        arr[i] = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
    }
}
