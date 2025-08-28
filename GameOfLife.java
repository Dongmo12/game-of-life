public class GameOfLife {

    private static final int ROWS = 5;
    private static final int COLS = 5;

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };

        System.out.println("Initial Generation:");
        printGrid(grid);

        for (int generation = 1; generation <= 10; generation++) {
            grid = nextGeneration(grid);
            System.out.println("Generation " + generation + ":");
            printGrid(grid);
        }
    }

    private static int[][] nextGeneration(int[][] currentGrid) {
        int[][] nextGrid = new int[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int liveNeighbors = countLiveNeighbors(currentGrid, row, col);

                if (currentGrid[row][col] == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextGrid[row][col] = 1;
                    } else {
                        nextGrid[row][col] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGrid[row][col] = 1;
                    } else {
                        nextGrid[row][col] = 0;
                    }
                }
            }
        }
        return nextGrid;
    }

    private static int countLiveNeighbors(int[][] grid, int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
                    count += grid[newRow][newCol];
                }
            }
        }
        return count;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "1 " : "0 ");
            }
            System.out.println();
        }
        System.out.println();
    }
}