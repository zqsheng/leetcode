import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// 三数之和
public class Problem_15 {
    public static void main(String[] args) {
        threeSum_1(new int[] {-1,-1,2,0}).stream().forEach(System.out::println);
    }



    // 排序 + 双指针
    public static List<List<Integer>> threeSum_1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        int left,right;
        for (int curr = 0; curr < nums.length - 2; curr++) {
            left = curr + 1;
            right = nums.length - 1;
            while (left < right) {
                int s = nums[curr] + nums[left] + nums[right];
                if(s == 0) {
                    result.add(Arrays.asList(nums[curr], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
                else if (s > 0) {
                    while (left < right && nums[right] == nums[--right]);
                }
                else {
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result;
    }
}
