import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        Class<ServiceAnnotation> annotation = ServiceAnnotation.class;
        Class<InitAnnotation> initAnnotation = InitAnnotation.class;
        if (service.isAnnotationPresent(annotation)) {
            System.out.println("Class name: " + service.getAnnotation(annotation).name());
            for (Method method : service.getDeclaredMethods()) {
                if (method.isAnnotationPresent(initAnnotation)) {
                    InitAnnotation methodAnnotation = method.getAnnotation(initAnnotation);
                    if (methodAnnotation.suppressException()) {
                        System.out.print("in method: " + method.getName());
                        System.out.println(":-> SUPPRESS warning");
                        try {
                            if (methodAnnotation.returned()) {
                                Class<?> returnType = method.getReturnType();
                                System.out.println("_______________");
                                System.out.println("return tupe is: "+returnType);
                                System.out.println("____________");
//                                returnType.newInstance();
                            } else {
                                Object o = service.newInstance();
                                method.invoke(o);
                            }
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print("in method: " + method.getName());
                        System.out.println(":-> WARNING is present");
                        try {
                            if (methodAnnotation.returned()) {
                                Class<?> returnType = method.getReturnType();
                                System.out.println("_______________");
                                System.out.println("return tupe is: "+returnType);
                                System.out.println("____________");
                            } else {
                                Object o = service.newInstance();
                                method.invoke(o);
                            }
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            System.out.println("WARNING EXCEPTION");
                        }
                    }
                } else {
                    System.out.print("in method: " + method.getName());
                    System.out.println(":-> init NOT FOUND");
                }
            }
        } else {
            System.out.print("in Class: " + service.getName());
            System.out.println(":--> ServiceAnnotation NOT FOUND");
        }
        System.out.println("__________________________");

    }
}
