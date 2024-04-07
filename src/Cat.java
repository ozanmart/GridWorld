import java.awt.*;

public class Cat extends Animal{
    private static int catID = 1;

    public Cat(int row, int col) {
        super(row, col, Color.RED, catID);
        catID ++;
    }

    @Override
    protected void move() {
        int direction = RAND.nextInt(4);
        switch (direction) {
            case 0:
                if (row > 1) {
                    row --;
                }
                break;
            case 1:
                if (row < ROWS - 2) {
                    row ++;
                }
                break;
            case 2:
                if (col > 1) {
                    col --;
                }
                break;
            case 3:
                if (col < COLS - 2) {
                    col ++;
                }
                break;
        }

    }

    @Override
    public String toString() {
        return String.format("Cat %d collected %d reward", catID, numRewards);
    }
}
