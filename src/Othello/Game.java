package Othello;

public class Game {
    private Player[] players;
    private Board board;
    private final int ROWS = 10;
    private final int COL = 10;
    private static Game game_instance;
    
    private Game() {
        board = new Board(ROWS, COL);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
        Automator.getInstance().initialize(players);
    }
    
    public static Game getGameInstance() {
        if(game_instance == null) {
            game_instance = new Game();
        }
        return game_instance;
    }
    
    public Board getBoard() {
        return board;
    }
}
