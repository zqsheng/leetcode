package backtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Permutation {

    public static void main(String[] args) {
        ArrayList<int[]> result = new ArrayList<>();
        backTrack(new int[] {1,2,3,4},result,0);
        result.stream().forEach(Permutation::print);

    }

    public static void backTrack(int[] nums,List<int[]> result,int j) {
        if (j == nums.length) {
            result.add(nums.clone());
        }
        for (int i = j; i < nums.length; i++) {
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
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
}
