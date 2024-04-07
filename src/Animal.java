import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Animal {
    protected int numRewards = 0;
    protected Color color;
    protected static final Random RAND = new Random();
    protected static final int COLS = 10;
    protected static final int CELL_SIZE = 40;
    protected static final int ROWS = 10;
    protected final int animalID;
    protected int col;
    protected int row;

    protected Animal(int row, int col, Color color, int animalId) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.animalID = animalId;
    }

    protected int getRow() {
        return row;
    }

    protected int getCol() {
        return col;
    }
    protected abstract void move();
    protected void draw() {
        StdDraw.setPenColor(color);
        StdDraw.text((col + 0.5) * CELL_SIZE, (ROWS - row - 0.5) * CELL_SIZE, Integer.toString(animalID));
        StdDraw.circle((col + 0.5) * CELL_SIZE, (ROWS - row - 0.5) * CELL_SIZE, CELL_SIZE * 0.4);
    }
}
