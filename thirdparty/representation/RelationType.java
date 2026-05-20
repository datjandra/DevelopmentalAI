package representation;

/**
 * RelationType
 *
 * Defines common relationship types
 * between objects.
 *
 * This can grow over time as the
 * agent learns more abstract concepts.
 */
public enum RelationType {
    LEFT_OF,
    RIGHT_OF,
    ABOVE,
    BELOW,
    TOUCHES,
    INTERSECTS,
    CONTAINS,
    INSIDE,
    SAME_COLOR_AS,
    DIFFERENT_COLOR_FROM,
    SAME_SHAPE_AS,
    DIFFERENT_SHAPE_FROM,
    CONNECTED_TO,
    NEAR,
    OVERLAPS
}
