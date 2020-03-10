import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem_test_53 {
    public static void main(String[] args) {
        int len = 10,miss = 2;
        List<Integer> list = IntStream.range(0,len + 1).boxed().collect(Collectors.toList());
//        list.remove(miss);
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
//        System.out.println(missingNumber(nums));
//        System.out.println(missingNumber_1(nums));
        System.out.println(missingNumber_2(nums));

    }

    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return 0;
    }
    public static int missingNumber_1(int[] nums) {
        int n = nums.length + 1;
        return (n * (n-1) >> 1) - Arrays.stream(nums).reduce((left, right) -> left + right).getAsInt();
    }

    public static int missingNumber_2(int[] nums) {
        // 注意边界处理
        if (nums[0] > 0) { return 0;}
        if (nums[nums.length - 1] < nums.length) {
            return nums.length;
        }
        int left = 0,right = nums.length - 1;
        while (right - left > 1) {
            int mid = (left + right ) >> 1;
            int diff = nums[mid] - mid;
            if (diff == 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left + 1;
    }

}
