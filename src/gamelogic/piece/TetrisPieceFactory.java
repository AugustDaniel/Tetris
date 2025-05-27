package gamelogic.piece;

import application.PropertyHandler;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class TetrisPieceFactory {

    private final int gridWidth;
    private final int gridHeight;
    private final int pieceWidth;
    private List<Block> blocks;

    public TetrisPieceFactory() {
        this.gridWidth = Integer.parseInt(PropertyHandler.getProperty("gridWidth"));
        this.gridHeight = Integer.parseInt(PropertyHandler.getProperty("gridHeight"));
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
            case BOUNDARY:
                return createBoundaryPiece();
        }

        return piece;
    }

    private TetrisPiece createBoundaryPiece() {
        for (int y = 0; y < this.gridHeight; y++) {
            blocks.add(new Block(new Point(-1, y)));
            blocks.add(new Block(new Point(this.gridWidth, y)));
        }

        for (int x = -1; x <= this.gridWidth; x++) {
            blocks.add(new Block(new Point(x, this.gridHeight)));
        }

        return new TetrisPiece(blocks);
    }

    private TetrisPiece createIPiece() {
        int startX = (gridWidth - pieceWidth) / 2;

        for (int i = 0; i < pieceWidth; i++) {
            Point pos = new Point(startX + i, 0);
            blocks.add(new Block(pos));
        }

        return new TetrisPiece(this.blocks);
    }

    private TetrisPiece createZPiece() {
        blocks.add(new Block(new Point(4, 0)));
        blocks.add(new Block(new Point(5, 0)));
        blocks.add(new Block(new Point(5, 1)));
        blocks.add(new Block(new Point(6, 1)));
        return new TetrisPiece(this.blocks);
    }
}
