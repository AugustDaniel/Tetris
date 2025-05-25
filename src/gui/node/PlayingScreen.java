package gui.node;

import gamelogic.GameManager;
import gui.Nextable;
import javafx.animation.Timeline;
import javafx.scene.layout.VBox;

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
    }

    @Override
    protected void endNode() {

    }
}
