import java.awt.*;
import java.util.Random;

public class GridWorld {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int CELL_SIZE = 40;
    private static final int NUM_CATS = 3;
    private static final int NUM_DOGS = 2;
    private static final int NUM_FROGS = 4;
    private static final int NUM_REWARDS = 5;
    private static int rewardLeft = 5;
    private static final Random random = new Random();
    private static Animal[] animals;
    private static Reward[] rewards;
    private static boolean[][] grid = new boolean[ROWS][COLS];

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        drawMap();
        setAnimals();
        setRewards();
        long startTime = System.currentTimeMillis();
        while (rewardLeft > 0) {
            StdDraw.clear();
            StdDraw.setPenRadius();
            StdDraw.setPenColor(Color.black);
            for (int i = 0; i <= COLS; i++) {
                StdDraw.line(0, i * CELL_SIZE, ROWS * CELL_SIZE, i * CELL_SIZE);
            }
            for (int i = 0; i <= ROWS; i++) {
                StdDraw.line(i * CELL_SIZE, 0, i * CELL_SIZE, COLS * CELL_SIZE);
            }
            StdDraw.setPenRadius(.012);
            for (Animal animal : animals) {
                animal.move();
                animal.draw();
                checkReward(animal);
            }
            for (Reward reward : rewards) {
                reward.draw();
            }
            StdDraw.pause(100);
            StdDraw.show();
        }
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime) / 1000;
        StdDraw.setFont(new Font("Helvetica", Font.BOLD, 25));
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.text(COLS / 2 * CELL_SIZE, (ROWS / 2 + 0.5) * CELL_SIZE, "FINISHED");
        StdDraw.text(COLS / 2 * CELL_SIZE, (ROWS / 2 - 0.5) * CELL_SIZE, String.format("TIME: %ds", time));
        StdDraw.show();
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static void drawMap() {
        StdDraw.setCanvasSize(COLS * CELL_SIZE, ROWS * CELL_SIZE);
        StdDraw.setXscale(0, COLS * CELL_SIZE);
        StdDraw.setYscale(0, ROWS * CELL_SIZE);
    }

    private static void setAnimals() {
        animals = new Animal[NUM_CATS + NUM_DOGS + NUM_FROGS];
        for (int i = 0; i < animals.length; i++) {
            if (i < NUM_CATS) {
                animals[i] = new Cat(random.nextInt(ROWS), random.nextInt(COLS));
            } else if (i < NUM_CATS + NUM_DOGS) {
                animals[i] = new Dog(random.nextInt(ROWS), random.nextInt(COLS));
            } else {
                animals[i] = new Frog(random.nextInt(ROWS), random.nextInt(COLS));
            }
        }
    }

    private static void setRewards() {
        rewards = new Reward[NUM_REWARDS];
        for (int i = 0; i < rewards.length; i++) {
            int row = random.nextInt(2) + i * 2;
            int col = random.nextInt(2) + i * 2;
            rewards[i] = new Reward(row, col, new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            grid[row][col] = true;
        }
    }

    private static void checkReward(Animal animal) {
        int row = animal.getRow();
        int col = animal.getCol();
        if (grid[row][col]) {
            for (Reward reward : rewards) {
                if ((reward.getRow() == row) && (reward.getCol() == col)) {
                    reward.collect();
                    grid[row][col] = false;
                    rewardLeft--;
                    animal.numRewards ++;
                    break;
                }
            }
        }
    }
}