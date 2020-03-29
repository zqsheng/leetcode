import javax.security.sasl.SaslServer;

public class Problem_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int left = 0,right = nums.length - 1;
        int area = 0;
        while (left < right) {
           int h = Math.min(nums[left], nums[right]) ;
           int a = (right - left) * h;
           if(a > area) {
               area = a;
           }
           if (h == nums[left]) {
               left++;
           } else {
               right--;
           }
        }
        return area;
    }
}
