package gui.node;

import gamelogic.GameManager;
import gui.Nextable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PlayingScreen extends AbstractNode {

    private final GameManager gameManager;
    private Timeline loop;

    public PlayingScreen(Nextable nextable) {
        super(nextable);
        this.gameManager = new GameManager();
    }

    @Override
    protected void initializeRoot() {
        VBox container = new VBox();
        this.root.setCenter(container);

        loop = new Timeline(new KeyFrame(
                Duration.millis(100), e -> updateGame()
        ));
    }

    private void updateGame() {
        this.gameManager.update();
    }

    @Override
    protected void endNode() {

    }
}
