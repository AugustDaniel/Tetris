package gamelogic;


import javafx.scene.canvas.GraphicsContext;

public class GameManager implements Drawable {

    private Board board;
    private Piece currentPiece;

    public GameManager() {
        this.board = new Board();
    }

    public void update() {

    }

    public void stop() {

    }

    public void start() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        this.board.draw(gc);
    }
}
