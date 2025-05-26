package gui.node;

import application.PropertyHandler;
import gamelogic.GameManager;
import gui.Nextable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PlayingScreen extends AbstractNode {

    private final GameManager gameManager;
    private Timeline loop;
    private Canvas canvas;
    private int blockSize;
    private int gridHeight;
    private int gridWidth;

    public PlayingScreen(Nextable nextable) {
        super(nextable);
        this.gameManager = new GameManager();
        this.gameManager.start();
    }

    @Override
    protected void initializeRoot() {
        this.blockSize = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("blockPixelWidth"));
        this.gridHeight = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridHeight"));
        this.gridWidth = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));

        VBox container = new VBox();
        this.root.setCenter(container);

        this.loop = new Timeline(new KeyFrame(
                Duration.millis(100), e -> updateGame()
        ));
        this.loop.play();

        this.canvas = new Canvas(this.blockSize * this.gridWidth,
                this.blockSize * this.gridHeight);

        this.root.setLeft(this.canvas);
    }

    private void updateGame() {
        this.gameManager.update();
        this.gameManager.draw(this.canvas.getGraphicsContext2D());
    }

    @Override
    protected void endNode() {
        this.loop.stop();
        this.gameManager.stop();
    }
}
