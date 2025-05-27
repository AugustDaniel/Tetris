package gui.node;

import application.PropertyHandler;
import gamelogic.Game;
import gamelogic.GameController;
import gui.Nextable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PlayingScreen extends AbstractNode {

    private final GameController game;
    private Timeline loop;
    private Canvas canvas;
    private int blockSize;
    private int gridHeight;
    private int gridWidth;

    public PlayingScreen(Nextable nextable) {
        super(nextable);
        this.game = new Game(this.gridWidth, this.gridHeight);
    }

    @Override
    protected void initializeRoot() {
        this.blockSize = Integer.parseInt(PropertyHandler.getProperty("blockPixelWidth"));
        this.gridHeight = Integer.parseInt(PropertyHandler.getProperty("gridHeight"));
        this.gridWidth = Integer.parseInt(PropertyHandler.getProperty("gridWidth"));

        VBox container = new VBox();
        this.root.setCenter(container);

        this.loop = new Timeline(new KeyFrame(
                Duration.millis(250), e -> updateGame()
        ));
        this.loop.cycleCountProperty().setValue(Timeline.INDEFINITE);

        this.canvas = new Canvas(this.blockSize * this.gridWidth,
                this.blockSize * this.gridHeight);

        this.canvas.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                this.game.start();
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
        this.game.update();
        drawGrid();
        this.game.draw(this.canvas.getGraphicsContext2D());
    }

    private void drawGrid() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        for (int i = 0; i < this.gridWidth; i++) {
            for (int j = 0; j < this.gridHeight; j++) {
                gc.strokeRect(i * this.blockSize, j * this.blockSize, this.blockSize, this.blockSize);
            }
        }
    }

    @Override
    protected void endNode() {
        this.loop.stop();
        this.game.stop();
    }
}
