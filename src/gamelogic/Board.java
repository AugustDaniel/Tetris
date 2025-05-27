package gamelogic;

import application.PropertyHandler;
import gamelogic.piece.Block;
import gamelogic.piece.TetrisPiece;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Board implements Drawable {

    private final ArrayList<TetrisPiece> pieces;
    private final TetrisPiece boundary;

    public Board(TetrisPiece boundary) {
        this.boundary = boundary;
        this.pieces = new ArrayList<>();
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
        //TODO check if piece is on board
        TetrisPiece clone = new TetrisPiece(
                piece.getBlocks()
                        .stream()
                        .map(Block::clone)
                        .collect(Collectors.toList())
        );
        clone.moveDown();

        return !(intersectsPieces(clone, piece) || clone.intersects(this.boundary));
    }

    private boolean canBeAdded(TetrisPiece piece) {
        return !intersectsPieces(piece, null);
    }

    private boolean intersectsPieces(TetrisPiece piece, TetrisPiece ignore) {
        for (TetrisPiece piece1 : pieces) {
            if (piece1.intersects(piece) && piece1 != ignore) {
                return true;
            }
        }

        return false;
    }
}
