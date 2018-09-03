
@Service(name = "super Lazy Service",
        lazyLoad = true)
public class LazyService {

    public void run() {
        System.out.println("run");
    }

    @Init(suppressException = true)
    public void initLazy() throws Exception {
        System.out.println("SUPER LAZY CLASS METHOD AND OTHER INIT AND THROW EXCEPTION11!!!1111!!!");
        throw new Exception("EXCEPTION");
    }
}
