import java.util.ArrayList;
import java.util.List;

public class Problem_47 {
    public static void main(String[] args) {
//        Utils.print(permuteUnique(new int[] {1,1,2}));
        Utils.print(permuteUnique(new int[] {1,1,2,2}));
//        Utils.print(permuteUnique(new int[] {2,2,1,1,2}));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums,result,0);
        return result;
    }
    public static void backTrack(int[] nums,List<List<Integer>> result,int j) {
        if (j == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < nums.length;i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }
        for (int i = j; i < nums.length; i++) {
            if(i != j && nums[i] == nums[j]) {continue;}
            swap(nums,i, j);
            backTrack(nums,result,j + 1);
            swap(nums,i,j);
        }

    }
    private static void swap(int[] nums,int i,int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
