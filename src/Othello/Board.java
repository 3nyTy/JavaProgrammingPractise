package Othello;

public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;
    
    public Board(int rows, int col) {
        board = new Piece[rows][col];
    }
    
    public void initialise() {
        int middleRow = board.length / 2;
        int middleCol = board[0].length / 2;
        board[middleRow][middleCol] = new Piece(Color.White);
        board[middleRow][middleCol + 1] = new Piece(Color.Black);
        board[middleRow + 1][middleCol + 1] = new Piece(Color.White);
        board[middleRow +1][middleCol] = new Piece(Color.Black);
        blackCount = 2;
        whiteCount = 2;
        
    }

    public int getScoreForColor(Color c) {
        if (c == Color.Black) {
            return blackCount;
        } else {
            return whiteCount;
        }
    }

    public boolean placeColor(int row, int col, Color color) {
        if(board[row][col] != null) {
            return false;
        }
        
        int[] results = new int[4];
        results[0] = flipSection(row - 1, col, color, Direction.up);
        results[1] = flipSection(row + 1, col, color, Direction.down);
        results[2] = flipSection(row, col + 1, color, Direction.right);
        results[3] = flipSection(row, col - 1, color, Direction.left);
        
        int flipped = 0;
        
        for(int result : results) {
            if (result > 0) {
                flipped += result;
            }
        }
        
        if (flipped < 0) {
            return false;
        }
        
        board[row][col] = new Piece(color);
        updateScore(color, flipped + 1);
        
        return false;
    }
    
    private void updateScore(Color newColor, int newPieces) {
        if(newColor == Color.Black) {
            whiteCount -= newPieces - 1;
            blackCount += newPieces; 
        } else {
            blackCount -= newPieces - 1;
            whiteCount += newPieces; 
        }
        
    }

    private int flipSection(int row, int col, Color color, Direction d) {
        
        int r = 0; 
        int c = 0;
        
        switch (d) {
        case up : 
            r = -1;
            break;
        case down :
            r = 1;
            break;
        case left :
            c = -1;
            break;
        case right :
            c = 1;
            break;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == null) {
            return -1;
        }
        
        if (color == board[row][col].getColor()) {
            return 0;
        }
        
        int flipped = flipSection(row + r, col + c, color, d);
        if (flipped < 0) return -1;
        
        board[row][col].flip();
        
        return flipped + 1;
    }

    public void printBoard() {
        for (int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if (board[r][c] == null) {
                    //System.out.println("_");
                } else if (board[r][c].getColor() == Color.White) {
                    System.out.println("W");
                } else {
                    System.out.println("B");
                }
            }
            System.out.println();
        }
        
    }

}
