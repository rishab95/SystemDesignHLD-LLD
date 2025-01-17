package SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    int boardSize;
    private final Dice dice;
    private final Queue<Player> playerQueue;
    private final List<Jumper> snakeJumperList;
    private final List<Jumper> ladderJumperList;
    private final Map<Player, Position> playerPositionMap;

    public GameBoard(int boardSize, Dice dice,
                     Queue<Player> playerQueue,
                     List<Jumper> snakeJumperList,
                     List<Jumper> ladderJumperList,
                     Map<Player, Position> playerPositionMap) {
        this.boardSize = boardSize;
        this.dice = dice;
        this.playerQueue = playerQueue;
        this.snakeJumperList = snakeJumperList;
        this.ladderJumperList = ladderJumperList;
        this.playerPositionMap = playerPositionMap;
    }
}
