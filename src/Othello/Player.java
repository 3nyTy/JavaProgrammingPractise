package Othello;

public class Player {
    private Color c;
    public Player(Color c) {
        this.c = c;
    }
    
    public Color getColor() {
        return c;
    }
    
    public int getScore() {
        return Game.getGameInstance().getBoard().getScoreForColor(c);
    }
    
    public boolean playPiece(int row, int col) {
        return Game.getGameInstance().getBoard().placeColor(row, col, c);
    }

}
