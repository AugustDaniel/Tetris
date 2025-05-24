package gui.node;

import gui.Nextable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenu extends AbstractNode {

    public MainMenu(Nextable nextable) {
        super(nextable);
    }

    @Override
    protected void initializeRoot() {
        VBox container = new VBox();

        Label welcomeMessage = new Label("Welcome to Tetris");

        Button startButton = new Button("start");
        startButton.setOnAction((event) -> {
            endNode();
        });

        container.getChildren().addAll(welcomeMessage, startButton);

        this.root.setCenter(container);
    }

    private void endNode() {
        this.nextable.next();
    }
}
