import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_15 {
    public static void main(String[] args) {
        threeSum(new int[] {-1, 0, 1, 2, -1, -4}).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return result;
    }
}
