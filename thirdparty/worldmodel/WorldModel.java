package worldmodel;

/**
 * WorldModel
 *
 * A WorldModel represents the agent's internal understanding
 * of how the environment behaves.
 *
 * Instead of only reacting to the current situation,
 * the agent can use this model to:
 *
 * 1. Predict what may happen next
 * 2. Learn from previous experiences
 * 3. Simulate future actions before acting
 * 4. Improve planning and decision making
 *
 * ------------------------------------------------------------
 * Example:
 *
 * Current State:
 *   Agent is at position (2,3)
 *
 * Action:
 *   MOVE_RIGHT
 *
 * Predicted Next State:
 *   Agent moves to (3,3)
 *
 * ------------------------------------------------------------
 *
 * ARC-AGI style agents need a world model because
 * the meaning of actions changes between environments.
 *
 * The agent must learn:
 *
 *   State + Action -> Next State
 *
 * over time through exploration.
 */
public interface WorldModel {

    /**
     * Predict the next state of the world.
     *
     * The agent uses its current knowledge
     * to imagine what may happen if an action is executed.
     *
     * This does NOT change the real environment.
     * It is only an internal prediction/simulation.
     *
     * Example:
     *
     *   currentState = player at (1,1)
     *   action = MOVE_UP
     *
     *   predictedState = player at (1,0)
     *
     * @param currentState Current observed world state
     * @param action Action the agent wants to test
     *
     * @return Predicted future state
     */
    State predict(State currentState, Action action);

    /**
     * Learn from a real experience.
     *
     * After the agent performs an action in the environment,
     * it compares:
     *
     *   what it predicted
     *   versus
     *   what actually happened
     *
     * The world model should improve itself using this feedback.
     *
     * Example:
     *
     *   predicted:
     *     MOVE_RIGHT -> moved successfully
     *
     *   actual:
     *     MOVE_RIGHT -> hit wall
     *
     * The model updates its knowledge so future predictions
     * become more accurate.
     *
     * @param previousState State before action
     * @param action Action performed
     * @param actualNextState Real resulting state
     */
    void update(
        State previousState,
        Action action,
        State actualNextState
    );

    /**
     * Reset internal memory/state.
     *
     * Useful when:
     * - starting a new game
     * - entering a new environment
     * - restarting training
     */
    void reset();

    /**
     * Return how confident the model is
     * about its predictions.
     *
     * Range:
     *   0.0 = no confidence
     *   1.0 = very confident
     *
     * This can help the agent decide:
     * - explore more
     * - trust current knowledge
     *
     * @return confidence value between 0 and 1
     */
    double getConfidence();
}
