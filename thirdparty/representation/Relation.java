package representation;

import java.util.Objects;

/**
 * Relation
 *
 * Represents a relationship between two objects
 * inside the agent's internal representation.
 *
 * ARC-style reasoning depends heavily on relations.
 *
 * Examples:
 *
 *   - object A is LEFT_OF object B
 *   - object A TOUCHES object B
 *   - object A CONTAINS object B
 *   - object A SAME_COLOR_AS object B
 *
 * Relations help the agent move beyond
 * simple pixel processing into structured reasoning.
 */
public class Relation {

    /**
     * First object in the relation.
     */
    private ObjectNode source;

    /**
     * Type of relationship.
     */
    private RelationType type;

    /**
     * Second object in the relation.
     */
    private ObjectNode target;

    /**
     * Optional confidence value.
     *
     * Useful when the agent is uncertain.
     *
     * Range:
     *   0.0 = no confidence
     *   1.0 = complete confidence
     */
    private double confidence;

    /**
     * Creates a relation with default confidence.
     */
    public Relation(
            ObjectNode source,
            RelationType type,
            ObjectNode target) {

        this(source, type, target, 1.0);
    }

    /**
     * Creates a relation with custom confidence.
     */
    public Relation(
            ObjectNode source,
            RelationType type,
            ObjectNode target,
            double confidence) {

        this.source = source;
        this.type = type;
        this.target = target;
        this.confidence = confidence;
    }

    public ObjectNode getSource() {
        return source;
    }

    public RelationType getType() {
        return type;
    }

    public ObjectNode getTarget() {
        return target;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return source.getId()
                + " "
                + type
                + " "
                + target.getId()
                + " (confidence="
                + confidence
                + ")";
    }

    /**
     * Relations are considered equal if:
     * - source matches
     * - type matches
     * - target matches
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Relation)) {
            return false;
        }

        Relation relation = (Relation) o;

        return Objects.equals(source, relation.source)
                && type == relation.type
                && Objects.equals(target, relation.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, type, target);
    }
}
