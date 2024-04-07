import java.awt.*;
import java.rmi.server.RemoteObjectInvocationHandler;

public class Reward {
    private boolean collected = false;
    protected final static int CELL_SIZE = 40;
    protected final static int ROWS = 10;
    private Color color;
    private int col;
    private int row;

    public Reward(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void collect() {
        collected = true;
    }

    public void draw() {
        if (!collected) {
            StdDraw.setPenColor(color);
            StdDraw.filledRectangle((col + 0.5) * CELL_SIZE, (ROWS - row - 0.5) * CELL_SIZE, CELL_SIZE * 0.3, CELL_SIZE * 0.3);
        }
    }
}
