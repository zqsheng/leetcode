import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Problem_test_20 {
    public static void main(String[] args) {
        ArrayUtils.print(getLeastNumbers(new int[]{3,2,1},2));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

}
