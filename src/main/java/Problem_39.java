import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_39 {
    public static void main(String[] args) {

        combinationSum(new int[] {2,3,6,7},7).forEach(System.out::println);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        back(candidates,0,target,new ArrayList<Integer>(),0,result);
        return result;
    }

    public static void back(int[] candidates,int i,int target,List<Integer> tmp, int sum,List<List<Integer>> result){
        if (sum == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        int v = candidates[i];
        sum += v;
        if (sum <= target) {
            tmp.add(v);
            back(candidates,i + 1,target,tmp,sum,result);
            tmp.remove(tmp.size() - 1);
        }
        back(candidates,i + 1,target,tmp,sum - v,result);
    }
}
