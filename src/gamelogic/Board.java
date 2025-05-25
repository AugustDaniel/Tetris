package gamelogic;

import application.PropertyHandler;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board implements Drawable {

    private final int WIDTH;
    private final int HEIGHT;
    private final ArrayList<Piece> pieces;

    public Board() {
        this.WIDTH = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));
        this.HEIGHT = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridHeight"));
        this.pieces = new ArrayList<>();


        ArrayList<Block> blocks = new ArrayList<>();

    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Piece piece : pieces) {
            piece.draw(gc);
        }
    }
}
