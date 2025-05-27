package gamelogic;

import gamelogic.piece.TetrisPiece;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board implements Drawable {

    private final ArrayList<TetrisPiece> pieces;
    private final TetrisPiece boundary;

    public Board(TetrisPiece boundary) {
        this.boundary = boundary;
        this.pieces = new ArrayList<>();
        this.pieces.add(boundary);
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (TetrisPiece piece : pieces) {
            piece.draw(gc);
        }
    }

    protected boolean addPiece(TetrisPiece piece) {
        if (canBeAdded(piece)) {
            return this.pieces.add(piece);
        }

        return false;
    }

    protected boolean canMoveDown(TetrisPiece piece) {
        TetrisPiece clone = new TetrisPiece(new ArrayList<>(piece.getBlocks()));
        clone.moveDown();

        return !(intersectsPieces(clone) || clone.intersects(this.boundary));
    }

    protected boolean canBeAdded(TetrisPiece piece) {
        return intersectsPieces(piece);
    }

    private boolean intersectsPieces(TetrisPiece piece) {
        for (TetrisPiece piece1 : pieces) {
            if (piece1.intersects(piece)) {
                return true;
            }
        }

        return false;
    }
}
