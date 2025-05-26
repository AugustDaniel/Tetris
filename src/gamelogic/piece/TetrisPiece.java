package gamelogic.piece;

import gamelogic.Drawable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class TetrisPiece implements Drawable {

    private final List<Block> blocks;

    public TetrisPiece(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public void moveDown() {
        for (Block block : this.blocks) {
            Point2D oldPos = block.getPos();
            block.setPos(new Point2D(
                    oldPos.getX(),
                    oldPos.getY() + 1
            ));
        }
    }

    public void rotate() {
        //TODO
    }

    public boolean intersects(TetrisPiece piece) {
        List<Block> otherBlocks = piece.getBlocks();
        for (Block block : otherBlocks) {
            for (Block block1 : this.blocks) {
                if (block1.getPos().equals(block.getPos())) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Block block : this.blocks) {
            block.draw(gc);
        }
    }
}
