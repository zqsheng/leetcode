public class Problem_test_21 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,4,1};
        ArrayUtils.print(exchange(nums));
    }

    public static int[] exchange(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (right > left) {
            if (nums[left] % 2 == 1) {
               left++;
            } else {
                while (left < right && nums[right] % 2 == 0) {
                   right--;
                }
                swap(nums,left,right);
            }
        }
        return nums;
    }
    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
