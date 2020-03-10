import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_1 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target =9;
        Arrays.stream(twoSum_0(nums,target)).forEach(System.out::println);
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = target - nums[i];
            for(int j = i + 1; j < nums.length ; j++) {
                if (diff == nums[j]) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
    public static int[] twoSum_0(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer val = map.get(diff);
            if (val != null) {
                result[0] = val;
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
