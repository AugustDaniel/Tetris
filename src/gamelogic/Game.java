package gamelogic;


import gamelogic.piece.TetrisPiece;
import gamelogic.piece.TetrisPieceFactory;
import gamelogic.piece.TetrisPieceType;
import javafx.scene.canvas.GraphicsContext;

public class Game implements GameController {

    private final Board board;
    private TetrisPiece currentPiece;
    private final TetrisPieceFactory factory;

    public Game() {
        this.factory = new TetrisPieceFactory();
        this.board = new Board(this.factory.createTetrisPiece(TetrisPieceType.BOUNDARY));
    }

    @Override
    public void update() {
        if (this.board.canMoveDown(this.currentPiece)) {
            this.currentPiece.moveDown();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void start() {
        TetrisPiece firstPiece = this.factory.createTetrisPiece(TetrisPieceType.Z);
        this.board.addPiece(firstPiece);
        this.currentPiece = firstPiece;
    }

    @Override
    public void draw(GraphicsContext gc) {
        this.board.draw(gc);
    }
}
