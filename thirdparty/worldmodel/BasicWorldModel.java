package worldmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * BasicWorldModel
 *
 * A very simple implementation of a WorldModel.
 *
 * This model learns from experience using:
 *
 *     State + Action -> Next State
 *
 * The model stores transitions in memory and
 * uses them later to predict future outcomes.
 *
 * --------------------------------------------------
 * Example:
 *
 * The agent experiences:
 *
 *     State A + MOVE_RIGHT -> State B
 *
 * The model remembers this transition.
 *
 * Later, if the agent is again in State A
 * and wants to MOVE_RIGHT,
 * the model predicts State B.
 *
 * --------------------------------------------------
 *
 * This is NOT a sophisticated AI model yet.
 *
 * It is intentionally simple so it can evolve later into:
 * - probabilistic models
 * - neural world models
 * - object-centric models
 * - causal reasoning systems
 * - planning systems
 */
public class BasicWorldModel implements WorldModel {

    /**
     * Stores learned transitions.
     *
     * Key format:
     *
     *     state + action
     *
     * Value:
     *
     *     predicted next state
     */
    private Map<String, State> transitions = new HashMap<>();

    /**
     * Number of successful predictions.
     */
    private int correctPredictions = 0;

    /**
     * Number of total predictions made.
     */
    private int totalPredictions = 0;

    /**
     * Predict what may happen next.
     *
     * If the model has seen this situation before,
     * it returns the learned next state.
     *
     * Otherwise it returns the current state unchanged.
     */
    @Override
    public State predict(State currentState, Action action) {

        String key = buildKey(currentState, action);

        // Return learned prediction if known
        if (transitions.containsKey(key)) {
            return transitions.get(key);
        }

        // Unknown situation:
        // return current state as fallback
        return currentState;
    }

    /**
     * Learn from a real interaction.
     *
     * The model stores:
     *
     *     previousState + action -> actualNextState
     *
     * so future predictions become more accurate.
     */
    @Override
    public void update(
            State previousState,
            Action action,
            State actualNextState
    ) {

        String key = buildKey(previousState, action);

        // Check old prediction before updating
        State predicted = transitions.get(key);

        totalPredictions++;

        // Compare prediction with reality
        if (predicted != null &&
                predicted.toString().equals(actualNextState.toString())) {

            correctPredictions++;
        }

        // Learn/update transition
        transitions.put(key, actualNextState);
    }

    /**
     * Remove all learned transitions.
     *
     * Useful for:
     * - new game
     * - new environment
     * - restarting experiments
     */
    @Override
    public void reset() {

        transitions.clear();

        correctPredictions = 0;
        totalPredictions = 0;
    }

    /**
     * Returns prediction confidence.
     *
     * Confidence is based on:
     *
     *     correct predictions / total predictions
     *
     * Range:
     *     0.0 -> no confidence
     *     1.0 -> high confidence
     */
    @Override
    public double getConfidence() {

        if (totalPredictions == 0) {
            return 0.0;
        }

        return (double) correctPredictions / totalPredictions;
    }

    /**
     * Build unique transition key.
     *
     * Combines:
     * - state
     * - action
     *
     * into one lookup string.
     */
    private String buildKey(State state, Action action) {

        return state.toString() + "::" + action.getName();
    }
}
