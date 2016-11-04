package functionStructure;

/**
 * Created by Maciej on 2016-11-01.
 */
public enum OperationType {
    Multiplication  (1),
    Division        (1),
    Addition        (2),
    Subtraction     (2);

    private final int priority;

    OperationType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
