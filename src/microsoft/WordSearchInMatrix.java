package microsoft;

public class WordSearchInMatrix {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {
                        'a', 'b', 'c', 'e'
                }, {
                        's', 'f', 'c', 's'
                }, {
                        'a', 'd', 'e', 'e'
                }
        };
        System.out.println(checkWordExistsInBorad("abcced", board));
    }

    private static boolean checkWordExistsInBorad(String input, char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == input.charAt(0)) {
                    return dfs(visited, input, i, j, 0, board);                        
                }
            }
        }

        return false;

    }

    private static boolean dfs(boolean[][] visited, String input, int i, int j, int index, char[][] board) {

        if ((input.length() - 1) == index) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != input.charAt(
                index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (dfs(visited, input, i + 1, j, index + 1, board) || dfs(visited, input, i - 1, j, index + 1, board) || dfs(
                visited, input, i, j + 1, index + 1, board) || dfs(visited, input, i, j - 1, index + 1, board)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }

}
