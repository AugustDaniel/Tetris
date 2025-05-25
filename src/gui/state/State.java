package gui.state;

public enum State implements StateTransition {

    MENU {
        @Override
        public State getNextState() {
            return PLAYING;
        }
    },

    PLAYING {
        @Override
        public State getNextState() {
            return MENU;
        }
    }
}
