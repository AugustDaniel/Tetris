package gamelogic;

import application.PropertyHandler;

import java.awt.*;

public class Board {

    private final int WIDTH;
    private final int HEIGHT;
    private final Rectangle[][] grid;

    public Board() {
        this.WIDTH = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridWidth"));
        this.HEIGHT = Integer.parseInt((String) PropertyHandler.PROPERTIES.get("gridHeight"));

        this.grid = new Rectangle[this.WIDTH][this.HEIGHT];
    }
}
