package gamelogic;


import gamelogic.piece.TetrisPiece;
import gamelogic.piece.TetrisPieceFactory;
import gamelogic.piece.TetrisPieceType;
import javafx.scene.canvas.GraphicsContext;

public class GameManager implements Drawable {

    private final Board board;
    private TetrisPiece currentPiece;
    private final TetrisPieceFactory factory;

    public GameManager() {
        this.factory = new TetrisPieceFactory();
        this.board = new Board(this.factory.createTetrisPiece(TetrisPieceType.BOUNDARY));
    }

    public void update() {
        if (this.board.canMoveDown(this.currentPiece)) {
            this.currentPiece.moveDown();
            System.out.println(this.currentPiece.getBlocks());
        }
    }

    public void stop() {

    }

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
