package gamelogic;


import gamelogic.piece.TetrisPiece;
import gamelogic.piece.TetrisPieceFactory;
import javafx.scene.canvas.GraphicsContext;

public class GameManager implements Drawable {

    private final Board board;
    private TetrisPiece currentPiece;
    private final TetrisPieceFactory factory;

    public GameManager() {
        this.board = new Board();
        this.factory = new TetrisPieceFactory();
    }

    public void update() {

    }

    public void stop() {

    }

    public void start() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        this.board.draw(gc);
    }
}
