package mathematical.examples.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Vadym Mitin
 */
public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Calculator calc = new Calculator();
        ExpressionFormatter ef = new ExpressionFormatter();
        ArrayList<String> strings = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<String> expression = generator.generate(random.nextInt(5000), 0, 3);
            String format = ExpressionFormatter.format(expression);
            strings.add(format);
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
