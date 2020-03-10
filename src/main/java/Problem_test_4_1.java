public class Problem_test_4_1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 30;
        System.out.println(findNumberIn2DArray(matrix,target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int n = matrix.length,m = matrix[0].length;
        int row = 0,col = m - 1;
        while (row < n && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if(target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
