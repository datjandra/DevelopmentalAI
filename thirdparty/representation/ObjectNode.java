package representation;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectNode
 *
 * Represents a meaningful object detected in the environment.
 *
 * Instead of treating the world as raw pixels or grid cells,
 * the agent groups related information into objects.
 *
 * Examples:
 * - player
 * - wall
 * - key
 * - door
 * - enemy
 * - colored shape
 *
 * ARC-style reasoning becomes much easier when the agent
 * thinks in terms of objects and relationships.
 *
 * ------------------------------------------------------------
 * Example:
 *
 * A red square object:
 *
 *   type      = "square"
 *   color     = 2
 *   x         = 4
 *   y         = 7
 *   width     = 3
 *   height    = 3
 *
 * ------------------------------------------------------------
 *
 * ObjectNode can later evolve into:
 * - graph structures
 * - symbolic entities
 * - hierarchical objects
 * - tracked moving entities
 * - causal entities
 */
public class ObjectNode {

    /**
     * Unique identifier for this object.
     */
    private String id;

    /**
     * Human-readable object type.
     *
     * Examples:
     * - "player"
     * - "wall"
     * - "enemy"
     * - "square"
     */
    private String type;

    /**
     * Main object color/value.
     *
     * ARC environments commonly use values 0-15.
     */
    private int color;

    /**
     * Top-left x position.
     */
    private int x;

    /**
     * Top-left y position.
     */
    private int y;

    /**
     * Object width.
     */
    private int width;

    /**
     * Object height.
     */
    private int height;

    /**
     * Optional relationships to other objects.
     *
     * Examples:
     * - touching
     * - inside
     * - near
     * - aligned_with
     */
    private List<Relation> relations = new ArrayList<>();

    /**
     * Constructor.
     */
    public ObjectNode(
            String id,
            String type,
            int color,
            int x,
            int y,
            int width,
            int height) {

        this.id = id;
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Add relationship to another object.
     */
    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    /**
     * Returns object ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns object type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns object color.
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns object relations.
     */
    public List<Relation> getRelations() {
        return relations;
    }

    /**
     * Returns center X coordinate.
     */
    public int getCenterX() {
        return x + (width / 2);
    }

    /**
     * Returns center Y coordinate.
     */
    public int getCenterY() {
        return y + (height / 2);
    }

    /**
     * Simple overlap check.
     */
    public boolean overlaps(ObjectNode other) {

        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }

    /**
     * Returns readable debug string.
     */
    @Override
    public String toString() {

        return "ObjectNode{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
