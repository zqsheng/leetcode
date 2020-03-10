public class Problem_test_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,0,1};
        System.out.println(minArray(arr));
    }

    public static int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i + 1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
