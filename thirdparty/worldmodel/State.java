package worldmodel;

import java.util.Arrays;

/**
 * Represents the current state of the environment.
 *
 * This can later evolve into:
 * - object representations
 * - spatial maps
 * - symbolic structures
 * - memory graphs
 */
public class State {

    /**
     * Simple grid representation.
     *
     * Example:
     * 0 = empty
     * 1 = wall
     * 2 = player
     */
    private int[][] grid;

    public State(int[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the environment grid.
     */
    public int[][] getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(grid);
    }
}
