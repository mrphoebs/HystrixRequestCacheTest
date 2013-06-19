package hystrix.requestcache.test;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class SimpleCallable implements Callable {
    @Override
    public Object call() throws Exception {
        HelloWorldCommand helloWorldCommand1 = new HelloWorldCommand("hello");
        Future<String> msg1 = helloWorldCommand1.queue();
        HelloWorldCommand helloWorldCommand2 = new HelloWorldCommand("world");
        Future<String> msg2 = helloWorldCommand2.queue();
        return msg1.get() +" "+msg2.get();
    }
}
