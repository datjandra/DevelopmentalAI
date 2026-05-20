package worldmodel;

/**
 * Represents an action the agent can perform.
 */
public class Action {

    private String name;

    public Action(String name) {
        this.name = name;
    }

    /**
     * Returns action name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
