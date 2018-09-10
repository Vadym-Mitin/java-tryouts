
@ServiceAnnotation(name = "super Lazy ServiceAnnotation",
        lazyLoad = true)
public class LazyService {

    public void run() {
        System.out.println("run");
    }

    @InitAnnotation(suppressException = true)
    public void initLazy() throws Exception {
        System.out.println("SUPER LAZY CLASS METHOD AND OTHER INIT AND THROW EXCEPTION11!!!1111!!!");
//        throw new Exception("EXCEPTION");
    }
}
