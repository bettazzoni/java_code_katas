package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerTwoValMathOperationTest {

    @Test
    public void testAdd(){
        AddTwoIntegerOperation a = new AddTwoIntegerOperation();
        assertEquals( 69, a.execute(60, 9));
    }
    @Test
    public void testSub(){
        SubTwoIntegerOperation a = new SubTwoIntegerOperation();
        assertEquals( 51, a.execute(60, 9));
    }
    @Test
    public void testMul(){
        MulTwoIntegerOperation a = new MulTwoIntegerOperation();
        assertEquals( 540, a.execute(60, 9));
    }
    @Test
    public void testDiv(){
        DivTwoIntegerOperation a = new DivTwoIntegerOperation();
        assertEquals( 0.5, a.execute(1, 2));
    }
    @Test (expected = ArithmeticException.class)
    public void testDivisionByZero(){
        DivTwoIntegerOperation a = new DivTwoIntegerOperation();
        a.execute(1, 0);
    }
}
