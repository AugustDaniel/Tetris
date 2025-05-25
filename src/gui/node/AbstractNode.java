package gui.node;

import gui.Nextable;
import gui.NodeProvider;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

public abstract class AbstractNode implements NodeProvider {

    protected BorderPane root;
    protected Nextable nextable;

    public AbstractNode(Nextable nextable) {
        this.root = new BorderPane();
        this.nextable = nextable;
        this.root.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        initializeRoot();
    }

    abstract protected void initializeRoot();

    @Override
    public Node getNode() {
        return this.root;
    }
}
