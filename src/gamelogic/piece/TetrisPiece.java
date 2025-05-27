package gamelogic.piece;

import gamelogic.Drawable;
import javafx.scene.canvas.GraphicsContext;

import java.awt.Point;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            Point oldPos = block.getPos();
            block.setPos(new Point(
                    oldPos.x,
                    oldPos.y + 1
            ));
        }
    }

    public void rotate() {
        //TODO
    }

    public boolean intersects(TetrisPiece piece) {
        Set<Point> myPositions = this.blocks.stream()
                .map(Block::getPos)
                .collect(Collectors.toSet());

        for (Block b : piece.getBlocks()) {
            if (myPositions.contains(b.getPos())) {
                return true;
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
