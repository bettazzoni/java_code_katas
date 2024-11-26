package calculator;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


abstract class IntegerTwoValMathOperation {
    abstract public Number execute(int val1, int val2);
};

class AddTwoIntegerOperation extends IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne + valTwo; }
};

class SubTwoIntegerOperation extends IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne - valTwo; }
};

class MulTwoIntegerOperation extends IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) { return valOne * valTwo; }
};

class DivTwoIntegerOperation extends IntegerTwoValMathOperation {
    public Number execute(int valOne, int valTwo) {
        if (valTwo == 0) throw new ArithmeticException();
        return Double.valueOf(valOne) / Double.valueOf(valTwo);
    }
};


public class JsonCalculator {

    public static void main(String[] args) {
        JsonCalculator jc  = new JsonCalculator();
        System.out.println("Result: " + jc.processJsonString( "{ \"Cmd\": \"add\", \"val1\": -12, \"val2\": 42 }" ) );
    }

    private static final Map<String, IntegerTwoValMathOperation> operationsMap = new HashMap<String, IntegerTwoValMathOperation>()
    {
        {
            put("add", new AddTwoIntegerOperation());
            put("sub", new SubTwoIntegerOperation());
            put("mul", new MulTwoIntegerOperation());
            put("div", new DivTwoIntegerOperation());
        };
    };


    public Number processJsonString(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);

        String command = jsonObject.getString("Cmd");
        IntegerTwoValMathOperation operation = operationsMap.get(command);

        int val1 = jsonObject.getInt("val1");
        int val2 = jsonObject.getInt("val2");

        return operation.execute(val1, val2);
    }
}
