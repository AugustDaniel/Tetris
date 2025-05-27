package application;

import gui.GuiManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application implements Updatable {

    private GuiManager guiManager;
    private StackPane root;

    @Override
    public void start(Stage primaryStage) {
        update();

        double height = Double.parseDouble(PropertyHandler.getProperty("height"));
        double width = Double.parseDouble(PropertyHandler.getProperty("width"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.root = new StackPane();
        this.guiManager = new GuiManager(this);
    }

    @Override
    public void update() {
        this.root.getChildren().setAll(this.guiManager.getNode());
    }
}
