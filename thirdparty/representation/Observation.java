package representation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Observation
 *
 * Represents what the agent currently perceives
 * from the environment.
 *
 * An Observation is NOT the agent's full understanding
 * of the world.
 *
 * It only contains the information directly visible
 * at the current moment.
 *
 * ---------------------------------------------------
 * Examples:
 *
 * - Current ARC grid/frame
 * - Visible objects
 * - Colors and positions
 * - Score or metadata
 * - Available actions
 *
 * ---------------------------------------------------
 *
 * In a developmental AI architecture:
 *
 * Observation = perception
 * State       = internal belief/model
 *
 * The agent uses observations to build and update
 * its internal world model.
 */
public class Observation {

    /**
     * Grid representing the visible environment.
     *
     * Example:
     *
     * 0 = empty
     * 1 = wall
     * 2 = player
     * 3 = goal
     */
    private int[][] grid;

    /**
     * Optional metadata associated with this observation.
     *
     * Examples:
     * - score
     * - level number
     * - game status
     * - available actions
     */
    private Map<String, Object> metadata;

    /**
     * Creates a new observation using a visible grid.
     *
     * @param grid current visible environment
     */
    public Observation(int[][] grid) {
        this.grid = grid;
        this.metadata = new HashMap<>();
    }

    /**
     * Returns the visible grid.
     *
     * @return environment grid
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Replaces the current grid.
     *
     * @param grid new visible grid
     */
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    /**
     * Adds metadata to the observation.
     *
     * Example:
     *   observation.putMetadata("score", 100);
     *
     * @param key metadata key
     * @param value metadata value
     */
    public void putMetadata(String key, Object value) {
        metadata.put(key, value);
    }

    /**
     * Returns metadata value by key.
     *
     * @param key metadata key
     * @return metadata value
     */
    public Object getMetadata(String key) {
        return metadata.get(key);
    }

    /**
     * Returns all metadata values.
     *
     * @return metadata map
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Creates a readable string version
     * of the observation.
     */
    @Override
    public String toString() {
        return "Observation{" +
                "grid=" + Arrays.deepToString(grid) +
                ", metadata=" + metadata +
                '}';
    }
}
