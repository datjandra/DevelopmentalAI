package action;

public enum ActionType {
    SIMPLE,     // basic discrete action (move, interact)
    PARAMETER,  // action with coordinates or parameters
    MACRO       // composite action (sequence of actions)
}
