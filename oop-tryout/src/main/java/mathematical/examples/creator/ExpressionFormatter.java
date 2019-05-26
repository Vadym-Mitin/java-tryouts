package mathematical.examples.creator;

import java.util.*;

/**
 * @author Vadym Mitin
 */
public class ExpressionFormatter {
    public static String format(List<String> expresion) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expresion.size(); i++) {
            String value = expresion.get(i);
            if (i == 0 || i % 2 == 0) {
                String formattedNumber = numberFormat(value);
                sb.append(formattedNumber);
            } else {
                sb.append(value);
                sb.append(" ");
            }
        }
        sb.append(" =");

        return sb.toString();
    }

    private static String numberFormat(String number) {
        StringBuffer sb = new StringBuffer();
        int millimeters = Integer.valueOf(number);
        int meters = millimeters / 1000;
        if (meters > 0) {
            millimeters -= meters * 1000;
            sb.append(meters);
            sb.append("M ");
        }
        int deciMeters = millimeters / 100;
        if (deciMeters > 0) {
            millimeters -= deciMeters * 100;
            sb.append(deciMeters);
            sb.append("DM ");
        }
        int centiMeters = millimeters / 10;
        if (centiMeters > 0) {
            millimeters -= centiMeters * 10;
            sb.append(centiMeters);
            sb.append("CM ");
        }
        if (millimeters > 0) {
            sb.append(millimeters);
            sb.append("MM ");
        }
        return sb.toString();
    }

}
