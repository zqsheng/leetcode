import java.util.HashSet;
import java.util.Set;

public class Problem_test_3 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2,3,0,2,5,3}));
        System.out.println(findRepeatNumber_1(new int[]{0,1,0}));
    }
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int findRepeatNumber_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
