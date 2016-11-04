package inputParsing;

import java.util.ArrayList;
import functionStructure.Number;
import functionStructure.Operation;
/**
 * Created by Maciej on 2016-11-02.
 */
public class InputParsing {
    public static String removeWhitespaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    // FIX THIS FUNCTION!
    public static ArrayList<Number> getNumberList(String input) {
        ArrayList<Number> list = new ArrayList<>();
        input += " ";

        for(int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                for(int j = i + 1; j < input.length(); j++) {
                    if(!Character.isDigit(input.charAt(j))) {
                        list.add(new Number(input.substring(i, j)));
                        i = j + 1;
                        break;
                    }
                }
            }
        }

        return list;
    }

    public static ArrayList<Operation> getOperationList(String input) {
        ArrayList<Operation> operationList = new ArrayList<>();
        ArrayList<Number> numberList = getNumberList(input);

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                operationList.add(new Operation(input.charAt(i), numberList.get(operationList.size()), numberList.get(operationList.size() + 1)));
            }
        }

        return operationList;
    }
}
