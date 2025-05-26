package gamelogic.piece;

import application.PropertyHandler;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class TetrisPieceFactory {

    private final int gridWidth;
    private final int pieceWidth;
    private List<Block> blocks;

    public TetrisPieceFactory() {
        this.gridWidth = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));
        this.pieceWidth = 4;
    }

    public TetrisPiece createTetrisPiece(TetrisPieceType type) {
        TetrisPiece piece = null;
        this.blocks = new ArrayList<>();

        switch (type) {
            case I:
                return createIPiece();
            case Z:
                return createZPiece();
        }

        return piece;
    }

    private TetrisPiece createIPiece() {
        int startX = (gridWidth - pieceWidth) / 2;

        for (int i = 0; i < pieceWidth; i++) {
            Point2D pos = new Point2D(startX + i, 0);
            blocks.add(new Block(pos));
        }

        return new TetrisPiece(this.blocks);
    }

    private TetrisPiece createZPiece() {
        blocks.add(new Block(new Point2D(4, 0)));
        blocks.add(new Block(new Point2D(5, 0)));
        blocks.add(new Block(new Point2D(5, 1)));
        blocks.add(new Block(new Point2D(6, 1)));
        return new TetrisPiece(this.blocks);
    }
}
