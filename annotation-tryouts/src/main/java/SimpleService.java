
@Service(name = "Simple Service")
public class SimpleService {

    void run() {
        System.out.println("run");
    }

    @Init
    void initService() {
        System.out.println("init Service");
    }
}
