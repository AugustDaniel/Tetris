package gamelogic;

import gamelogic.piece.TetrisPiece;

public interface GameController extends Drawable{

    void start();

    void stop();

    void update();

    TetrisPiece getNextPiece();
}
