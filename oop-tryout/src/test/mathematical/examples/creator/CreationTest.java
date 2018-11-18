package mathematical.examples.creator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Mitin
 */
@DisplayName("Creator should")
public class CreationTest {

    @Test
    @DisplayName("create list of expressions")
    void generationTest() {

        Generator generator = new Generator();
        List<String> e1 = generator.generate(2000, 0, 4);
        List<String> e2 = generator.generate(1000, 0, 3);
        List<String> e3 = generator.generate(500, 0, 2);
        List<String> e4 = generator.generate(300, 0, 1);
        Calculator calc = new Calculator();

        System.out.println(generator.formatExpression(e1) + " = " + calc.calculate(e1));
        System.out.println(generator.formatExpression(e2) + " = " + calc.calculate(e2));
        System.out.println(generator.formatExpression(e3) + " = " + calc.calculate(e3));
        System.out.println(generator.formatExpression(e4) + " = " + calc.calculate(e4));

    }

    @Test
    @DisplayName("calculator calculate expression")
    public void calculatorTest() {

        ArrayList<String> expression = new ArrayList<>();
        expression.add("15");
        expression.add("+");
        expression.add("5");
        expression.add("-");
        expression.add("1");


        Calculator calc = new Calculator();
        int calculate = calc.calculate(expression);
        Assertions.assertEquals(19, calculate);

    }

}
