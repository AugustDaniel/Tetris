package gamelogic;


import gamelogic.piece.TetrisPiece;
import gamelogic.piece.TetrisPieceFactory;
import gamelogic.piece.TetrisPieceType;
import javafx.scene.canvas.GraphicsContext;

public class Game implements GameController {

    private final TetrisBoard board;
    private TetrisPiece currentPiece;
    private final TetrisPieceFactory factory;

    public Game() {
        this.factory = new TetrisPieceFactory();
        this.board = new TetrisBoard(this.factory.createTetrisPiece(TetrisPieceType.BOUNDARY));
    }

    @Override
    public void update() {
        if (this.board.canMoveDown(this.currentPiece)) {
            this.currentPiece.moveDown();
            return;
        }

        TetrisPiece nextPiece = getNextPiece();
        if (this.board.addPiece(nextPiece)) {
            this.currentPiece = nextPiece;
        } else {
            stop();
        }
    }

    @Override
    public TetrisPiece getNextPiece() {
        return this.factory.createTetrisPiece(TetrisPieceType.Z);
    }

    @Override
    public void stop() {
        System.out.println("stopped");
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
