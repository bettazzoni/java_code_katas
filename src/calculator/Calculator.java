package calculator;

@SuppressWarnings("serial")
class NotACommandException extends NullPointerException{};

abstract class MathOperation { 
	protected int valOne;
	protected int valTwo;
	
	public MathOperation(String val1, String val2) {
		valOne = Integer.parseInt(val1);
		valTwo = Integer.parseInt(val2);
	};
	
	abstract public String execute();
};

class AddOperation extends MathOperation {
	public AddOperation(String val1, String val2) {
		super(val1, val2);
	}
	
	public String execute() {
		return Integer.toString(valOne + valTwo);
	}
};

class SubOperation extends MathOperation {
	public SubOperation(String val1, String val2) {
		super(val1, val2);
	}
	
	public String execute() {
		return Integer.toString(valOne - valTwo);
	}
};

class MulOperation extends MathOperation {
	public MulOperation(String val1, String val2) {
		super(val1, val2);
	}
	
	public String execute() {
		return Integer.toString(valOne * valTwo);
	}
};

class DivOperation extends MathOperation {
	public DivOperation(String val1, String val2) {
		super(val1, val2);
	}
	
	public String execute() {
		if (valTwo == 0) throw new ArithmeticException();
		return  Float.toString( ((float)valOne ) / ((float)valTwo) );
	}
};


public class Calculator {
	public String calc(String cmd, String val1, String val2) {
		if (cmd.equalsIgnoreCase("ADD")) { 
			return new AddOperation(val1, val2).execute();		
		}
		if (cmd.equalsIgnoreCase("SUB")) { 
			return new SubOperation(val1, val2).execute();		
		}
		if (cmd.equalsIgnoreCase("MUL")) { 
			return new MulOperation(val1, val2).execute();		
		}
		if (cmd.equalsIgnoreCase("DIV")) { 
			return new DivOperation(val1, val2).execute();		
		}
		throw new NotACommandException();
	}
}
