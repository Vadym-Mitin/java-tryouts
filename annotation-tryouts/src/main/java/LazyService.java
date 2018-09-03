
@Service(name = "super Lazy Service",
        lazyLoad = true)
public class LazyService {

    void run() {
        System.out.println("run");
    }

    @Init(suppressException = true)
    void initLazy() throws Exception {
        System.out.println("lazy init");
        throw new Exception("exception");
    }
}
