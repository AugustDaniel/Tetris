package gamelogic;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Piece implements Drawable {

    private List<Block> blocks;

    public Piece(List<Block> blocks) {
        this.blocks = blocks;
    }


    @Override
    public void draw(GraphicsContext gc) {
        for (Block block : blocks) {
            block.draw(gc);
        }
    }
}
