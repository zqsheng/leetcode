import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_90 {
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2}).forEach(System.out::println);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        back(nums,0,nums.length,new ArrayList<>(),list);
        return list;
    }

    public static void back(int[] nums,int start,int len,List<Integer> list,List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            back(nums,i + 1,len,list,result);
            list.remove(list.size() - 1);
        }
    }


}
