package hystrix.requestcache.test;


import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionThread {
    private final ExecutorService tpe = Executors.newCachedThreadPool();
    public void requestCache() throws Exception{

        for(int i=0; i<10 ; i++) {
            Future result = tpe.submit(new SimpleCallable());
            System.out.println(result.get());
            i++;
        }
    }

}
