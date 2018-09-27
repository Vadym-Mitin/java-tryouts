/**
 * @author Vadym Mitin
 */
public class Shifts {
    public static void main(String[] args) {
        int i = -1;
        int j = i >> 1;
        int k = i >>> 1;
        System.out.println(">>> 1");
        System.out.println("i = " + i + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(i));
        System.out.println("j = " + j + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(j));
        System.out.println("k = " + k + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(k));
        System.out.println("_________________________");

        j = i >> 2;
        k = i >>> 2;
        System.out.println(">>> 2");
        System.out.println("i = " + i + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(i));
        System.out.println("j = " + j + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(j));
        System.out.println("k = " + k + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(k));
        System.out.println("_________________________");

        j = i >> 4;
        k = i >>> 4;
        System.out.println(">>> 4");
        System.out.println("i = " + i + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(i));
        System.out.println("j = " + j + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(j));
        System.out.println("k = " + k + "\t\t<=> ");
        System.out.println(Integer.toBinaryString(k));
        System.out.println("_________________________");


    }
}
