package gamelogic.piece;

import application.PropertyHandler;
import gamelogic.Drawable;
import javafx.scene.canvas.GraphicsContext;

import java.awt.Point;

public class Block implements Drawable {

    private Point pos;
    private final int size;

    public Block(Point pos) {
        this.pos = pos;
        this.size = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("blockPixelWidth"));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(this.pos.getX() * this.size,
                this.pos.getY() * this.size,
                this.size,
                this.size);
    }

    protected void setPos(Point pos) {
        this.pos = pos;
    }

    protected Point getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return this.pos.toString();
    }
}
