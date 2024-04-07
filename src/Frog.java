import java.awt.*;

public class Frog extends Animal{
    private static int frogID = 1;

    public Frog(int row, int col) {
        super(row, col, Color.GREEN, frogID);
        frogID ++;
    }

    @Override
    protected void move() {
        int direction = RAND.nextInt(4);
        switch (direction) {
            case 0:
                if (row > 1) {
                    row -= 2;
                }
                break;

            case 1:
                if (row < ROWS - 2) {
                    row += 2;
                }
                break;

            case 2:
                if (col > 1) {
                    col -= 2;
                }
                break;

            case 3:
                if (col < COLS - 2) {
                    col += 2;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Frog %d collected %d reward", frogID, numRewards);
    }

}
