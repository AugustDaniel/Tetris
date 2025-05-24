package gui;

import application.Updatable;
import gui.node.AbstractNode;
import gui.node.MainMenu;
import gui.node.PlayingScreen;
import gui.state.State;
import javafx.scene.Node;

import java.util.EnumMap;

public class GuiManager implements NodeProvider, Nextable {

    private final Updatable app;
    private final EnumMap<State, AbstractNode> stateMap;
    private State currentState;

    public GuiManager(Updatable app) {
        this.app = app;
        this.currentState = State.MENU;
        this.stateMap = new EnumMap<>(State.class);
        populateStateMap();
    }

    private void populateStateMap() {
        this.stateMap.put(State.MENU, new MainMenu(this));
        this.stateMap.put(State.PLAYING, new PlayingScreen(this));
    }

    @Override
    public Node getNode() {
        return this.stateMap.get(this.currentState).getNode();
    }

    @Override
    public void next() {
        this.currentState = this.currentState.getNextState();
        this.app.update();
    }
}
