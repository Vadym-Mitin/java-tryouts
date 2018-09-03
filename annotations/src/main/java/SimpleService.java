
@Service(name = "Simple Service")
public class SimpleService {

    public void run() {
        System.out.println("RUN");
    }

    @Init
    public void initService() {
        System.out.println("SIMPLESS METHOD CLASS INIT SERVICE");
    }
}
