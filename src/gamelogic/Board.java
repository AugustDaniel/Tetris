package gamelogic;

import application.PropertyHandler;
import gamelogic.piece.TetrisPiece;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board implements Drawable {

    private final int WIDTH;
    private final int HEIGHT;
    private final ArrayList<TetrisPiece> pieces;

    public Board() {
        this.WIDTH = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));
        this.HEIGHT = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridHeight"));
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
        return true; //TODO
    }

    protected boolean canBeAdded(TetrisPiece piece) {
        for (TetrisPiece piece1 : pieces) {
            if (piece1.intersects(piece)) {
                return false;
            }
        }

        return true;
    }
}
