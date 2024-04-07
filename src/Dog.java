import java.awt.*;

public class Dog extends Animal {
    private static int dogID = 1;

    public Dog(int row, int col) {
        super(row, col, Color.BLUE, dogID);
        dogID++;
    }

    @Override
    protected void move() {
        int direction = RAND.nextInt(4);
        switch (direction) {
            case 0:
                if (row > 0) {
                    row--;
                }
                break;

            case 1:
                if (row < ROWS - 1) {
                    row++;
                }
                break;

            case 2:
                if (col > 0) {
                    col--;
                }
                break;

            case 3:
                if (col < COLS - 1) {
                    col++;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("Dog %d collected %d reward", dogID, numRewards);
    }
}
