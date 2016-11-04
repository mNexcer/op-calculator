package functionStructure;

/**
 * Created by Maciej on 2016-11-01.
 */
public class Operation {
    private char sign;
    private OperationType operation;
    private Number leftNumber;
    private Number rightNumber;

    public Operation(char sign, Number leftNumber, Number rightNumber) {

        this.sign = sign;
        this.operation = setOperationType(sign);
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    private OperationType setOperationType(char input) {
        if(input == '*')
            return OperationType.Multiplication;
        else if (input == '/')
            return OperationType.Division;
        else if(input == '+')
            return OperationType.Addition;
        else
            return OperationType.Subtraction;
    }

    private double Evaluate() {
        if(operation == OperationType.Multiplication)
            return leftNumber.getValue() * rightNumber.getValue();
        else if (operation == OperationType.Division)
            return leftNumber.getValue() / rightNumber.getValue();
        else if(operation == OperationType.Addition)
            return leftNumber.getValue() + rightNumber.getValue();
        else
            return leftNumber.getValue() - rightNumber.getValue();
    }

    public double getValue() {
        return Evaluate();
    }

    public OperationType getOperationType() { return operation; }

    public String toString() {
        if(operation == OperationType.Multiplication)
            return leftNumber.getValue() + " * " + rightNumber.getValue();
        else if (operation == OperationType.Division)
            return leftNumber.getValue() + " / " + rightNumber.getValue();
        else if(operation == OperationType.Addition)
            return leftNumber.getValue() + " + " + rightNumber.getValue();
        else
            return leftNumber.getValue() + " - " + rightNumber.getValue();
    }

    public void setRightNumber(Number number) {
        this.rightNumber = number;
    }

    public void setLeftNumber(Number number) {
        this.leftNumber = number;
    }
}
