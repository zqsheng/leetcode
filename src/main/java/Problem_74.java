public class Problem_74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 50;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,columns = matrix[0].length;
        int left = 0,right = rows * columns - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            int row = mid / columns;
            int column = mid % columns;
            if (target == matrix[row][column]) {
                return true;
            }
            if (target > matrix[row][column]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
