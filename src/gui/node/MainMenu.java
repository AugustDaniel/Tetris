package gui.node;

import gui.Nextable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenu extends AbstractNode {

    public MainMenu(Nextable nextable) {
        super(nextable);
    }

    @Override
    protected void initializeRoot() {
        Label welcomeMessage = new Label("Welcome to Tetris");

        Button startButton = new Button("Start");
        startButton.setOnAction((event) -> {
            endNode();
        });

        VBox vbox = new VBox(20, welcomeMessage, startButton);
        vbox.setAlignment(Pos.CENTER);

        this.root.setCenter(vbox);
    }

    private void endNode() {
        this.nextable.next();
    }
}
