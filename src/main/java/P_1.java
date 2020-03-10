import java.util.Arrays;

public class P_1 {

    public  static String[] fizzBuzz(int n) {
        String[] str = new String[n];
        for (int i = 1; i <= n; i++) {
            String s = null;
            if ( i % 3 == 0 && i % 5 == 0) {
                s = "FizzBuzz";

            } else if (i % 3 == 0) {
                s = "Fizz";
            } else  if (i % 5 == 0) {
                s = "Buzz";
            } else {
                s = String.valueOf(i);
            }
            str[i-1] = s;
        }
        return str;
    }

    public static void main(String[] args) {
        Arrays.stream(fizzBuzz(15)).forEach(System.out::println);
    }
}
