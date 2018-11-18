package mathematical.examples.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
public class Generator {
    public List<String> generate(int maxValue, int minValue, int iterations) {
        List<String> expression;
        Calculator calc = new Calculator();
        int calculate = 0;
        do {
            expression = createExpression(maxValue, iterations);
            calculate = calc.calculate(expression);
        } while (calculate < minValue);

        return expression;
    }

    public String generateFormated(int maxValue, int minValue, int iterations) {
        List<String> generate = generate(maxValue, minValue, iterations);
        String format = ExpressionFormatter.format(generate);
        return format;
    }

    public String formatExpression(List<String> expression) {
        String format = ExpressionFormatter.format(expression);
        return format;
    }

    private List<String> createExpression(int maxValue, int iterations) {
        Random rnd = new Random();
        List<String> expression = new ArrayList<>();

        // add firs value
        int value = rnd.nextInt(maxValue);
        expression.add(Integer.toString(value));

        for (int i = 0; i < iterations; i++) {

            int flag = rnd.nextInt(3);
//            System.out.println(flag);
            if (flag >= 1) {
                expression.add("+");

            } else expression.add("-");

            int nextValue = rnd.nextInt(maxValue);
            expression.add(Integer.toString(nextValue));

        }
        return expression;
    }
}
