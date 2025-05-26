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
    }

    @Override
    protected void initializeRoot() {
        this.blockSize = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("blockPixelWidth"));
        this.gridHeight = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridHeight"));
        this.gridWidth = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));

        VBox container = new VBox();
        this.root.setCenter(container);

        this.loop = new Timeline(new KeyFrame(
                Duration.millis(1000), e -> updateGame()
        ));
        this.loop.cycleCountProperty().setValue(Timeline.INDEFINITE);

        this.canvas = new Canvas(this.blockSize * this.gridWidth,
                this.blockSize * this.gridHeight);

        this.canvas.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                System.out.println("canvas displayed");
                this.gameManager.start();
                this.loop.play();
            }
        });

        this.root.setLeft(this.canvas);
    }

    private void updateGame() {
        this.canvas.getGraphicsContext2D().clearRect(0,
                0,
                this.gridWidth * this.blockSize,
                this.gridHeight * this.blockSize);
        System.out.println("update");
        this.gameManager.update();
        this.gameManager.draw(this.canvas.getGraphicsContext2D());
    }

    @Override
    protected void endNode() {
        this.loop.stop();
        this.gameManager.stop();
    }
}
