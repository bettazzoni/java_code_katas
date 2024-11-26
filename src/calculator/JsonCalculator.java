package calculator;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


interface  IntegerTwoValMathOperation {
    Number execute(int val1, int val2);
}

class AddTwoIntegerOperation implements IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne + valTwo; }
}

class SubTwoIntegerOperation implements IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne - valTwo; }
}

class MulTwoIntegerOperation implements IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne * valTwo; }
}

class DivTwoIntegerOperation implements IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) {
        if (valTwo == 0) throw new ArithmeticException();
        return (double) valOne / (double) valTwo;
    }
}


public class JsonCalculator {

    private static final Map<String, IntegerTwoValMathOperation> operationsMap = new HashMap<>() {
        {
            put("add", new AddTwoIntegerOperation());
            put("sub", new SubTwoIntegerOperation());
            put("mul", new MulTwoIntegerOperation());
            put("div", new DivTwoIntegerOperation());
        }
    };

    public Number processJsonString(String jsonString) {
        JSONObject jsonObj = new JSONObject(jsonString);
        IntegerTwoValMathOperation operation = operationsMap.get(jsonObj.getString("Cmd"));
        return operation.execute(jsonObj.getInt("val1"),  jsonObj.getInt("val2"));
    }
}
