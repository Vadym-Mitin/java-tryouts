
@ServiceAnnotation(name = "Simple Service")
public class SimpleService {

    public void run() {
        System.out.println("RUN");
    }

    @InitAnnotation
    public void initService() {
        System.out.println("SIMPLESS METHOD CLASS INIT SERVICE");
    }

    @InitAnnotation(returned = true)
    public String returnService() {
//        System.out.println("SIMPLESS METHOD CLASS INIT SERVICE");
        return "SIMPLESS METHOD WHO RETURN STRING CLASS INIT SERVICE";
    }


}
