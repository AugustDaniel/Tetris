package gamelogic;

import application.PropertyHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Block implements Drawable {

    private Point2D pos;
    private int size;

    public Block(Point2D pos) {
        this.pos = pos;
        this.size = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("blockWidth"));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(this.pos.getX(), this.pos.getY(), this.size, this.size);
    }

    protected void setPos(Point2D pos) {
        this.pos = pos;
    }

    protected Point2D getPos() {
        return pos;
    }
}
