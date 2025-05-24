package gui.node;

import gamelogic.GameManager;
import gui.Nextable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayingScreen extends AbstractNode {

    private final GameManager gameManager;

    public PlayingScreen(Nextable nextable) {
        super(nextable);
        this.gameManager = new GameManager();
    }

    @Override
    protected void initializeRoot() {
        VBox container = new VBox();

        Label welcomeMessage = new Label("Its working");

        Button startButton = new Button("next");
        startButton.setOnAction((event) -> {
            this.nextable.next();
        });

        container.getChildren().addAll(welcomeMessage, startButton);

        this.root.setCenter(container);
    }
}
