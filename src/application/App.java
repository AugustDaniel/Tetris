package application;

import gui.GuiManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application implements Updatable {

    private VBox root;
    private GuiManager guiManager;

    @Override
    public void start(Stage primaryStage) {
        update();
        Scene scene = new Scene(this.root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.root = new VBox();
        this.guiManager = new GuiManager(this);
    }

    @Override
    public void update() {
        this.root.getChildren().setAll(this.guiManager.getNode());
    }
}
