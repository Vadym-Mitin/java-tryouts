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
        int value = Integer.valueOf(number);
        int metrs = value / 1000;
        if (metrs > 0) {
            value -= metrs * 1000;
            sb.append(metrs);
            sb.append("M ");
        }
        int deci = value / 100;
        if (deci > 0) {
            value -= deci * 100;
            sb.append(deci);
            sb.append("DM ");
        }
        int santi = value / 10;
        if (santi > 0) {
            value -= santi * 10;
            sb.append(santi);
            sb.append("CM ");
        }
        if (value > 0) {
            sb.append(value);
            sb.append("MM ");
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

}
