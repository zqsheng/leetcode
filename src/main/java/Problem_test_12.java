public class Problem_test_12 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
    }
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == chars[0]){

                }
            }
        }
        return false;
    }
}
