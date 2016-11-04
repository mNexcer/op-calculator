package mainMechanism;

import java.lang.reflect.Array;
import java.util.ArrayList;
import functionStructure.Operation;
import functionStructure.Number;
import functionStructure.OperationType;
/**
 * Created by Maciej on 2016-11-02.
 */
public class mainMechanism {
    // FIX THIS FUNCTION

    private static void preformCalculations(ArrayList<Operation> operations, int i) {
        if (i == 0) {
            operations.get(i + 1).setLeftNumber(new Number(operations.get(i).getValue()));
        } else if (i > 0 && i < operations.size() - 1) {
            operations.get(i - 1).setRightNumber(new Number(operations.get(i).getValue()));
            operations.get(i + 1).setLeftNumber(new Number(operations.get(i).getValue()));
        } else if (i == operations.size() - 1) {
            operations.get(i - 1).setRightNumber(new Number(operations.get(i).getValue()));
        }
    }

    public static double Calculate(ArrayList<Operation> operations) {
        boolean operationDone = false;

        while(operations.size() > 1) {

            for(int i = 0; i < operations.size(); i++) {
                operationDone = false;
                if ((operations.get(i).getOperationType() == OperationType.Multiplication) || (operations.get(i).getOperationType() == OperationType.Division)) {
                    preformCalculations(operations, i);
                    operations.remove(i);
                    operationDone = true;
                    break;
                }
            }

            if(!operationDone) {
                for(int i = 0; i < operations.size(); i++) {
                    if ((operations.get(i).getOperationType() == OperationType.Addition) || (operations.get(i).getOperationType() == OperationType.Subtraction)) {
                        preformCalculations(operations, i);
                        operations.remove(i);
                        break;
                    }
                }
            }
        }

        return operations.get(0).getValue();
    }
}
