package hystrix.requestcache.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String>{

    String key;

    public HelloWorldCommand(String key){
        super(HystrixCommandGroupKey.Factory.asKey("test"));
        this.key = key;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(10000);
        return key;
    }

    @Override
    protected String getCacheKey(){
        return key;
    }
}
