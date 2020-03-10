import java.util.Arrays;

public class ArrayUtils {

    public static void print(int[] nums) {
        Arrays.stream(nums).forEach(e -> System.out.print(e + ","));
        System.out.println();
    }
}
