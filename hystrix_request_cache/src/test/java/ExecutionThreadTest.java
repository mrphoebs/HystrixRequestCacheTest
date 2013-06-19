import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import hystrix.requestcache.test.ExecutionThread;
import org.testng.annotations.Test;

public class ExecutionThreadTest {

    @Test
    public void testRequestCache(){
        ExecutionThread executionThread = new ExecutionThread();
        boolean exceptionThrown = false;
        HystrixRequestContext context = HystrixRequestContext.initializeContext();


        try {
            executionThread.requestCache();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            exceptionThrown = true;
        } finally {
            context.shutdown();
        }

        assert !exceptionThrown;
    }

}
