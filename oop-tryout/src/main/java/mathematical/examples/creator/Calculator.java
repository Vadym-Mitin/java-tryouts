package mathematical.examples.creator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vadym Mitin
 */
public class Calculator {
    public int calculate(List<String> expression) {
        int summ = 0;
        Queue<Integer> q = new ArrayDeque<>();
        String sign = "";
        for (int i = 0; i < expression.size(); i++) {
            String value = expression.get(i);
            if (i == 0 || (i % 2 == 0)) {
                q.add(Integer.parseInt(value));
            } else sign = value;

            if (q.size() == 2) {
                int a = q.remove();
                int b = q.remove();
                summ = calc(a, b, sign);
                q.add(summ);
            }
        }
        return summ;
    }

    private int calc(int a, int b, String sign) {
        switch (sign) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return 0;
        }
    }
}
