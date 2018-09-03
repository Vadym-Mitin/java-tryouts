/**
 * annotation test
 * https://www.youtube.com/watch?v=9BbxPd3GPeU&t=100s
 */

public class Main {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);


    }

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            System.out.println(service.getAnnotation(Service.class).name());
        } else System.out.println("annotation epsent");
    }
}
