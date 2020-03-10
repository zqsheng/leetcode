import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_78 {
    public static void main(String[] args) {
        subsets(new int[]{1,2,2}).forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        back(nums,0,nums.length,new ArrayList<>(),list);
        return list;
    }

    public static void back(int[] nums,int i,int len,List<Integer> list,List<List<Integer>> result) {
        if (len == list.size() || i == nums.length) {
            result.add(list);
            return;
        }
        ArrayList<Integer> clone = new ArrayList<>(list);
        back(nums,i + 1,len,list,result);
        clone.add(nums[i]);
        back(nums,i+1,len,clone,result);
    }


}
