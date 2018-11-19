package classload.tryout;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Vadym Mitin
 */
public class SystemPatchs {
    public static void main(String args[]) {
        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }


    }
}
