package testNG.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)  //way 1 (can use multiple classes with { } this)
public class ListenersTest {

    @Test
    public void test1(){
        System.out.println("I am inside testMethod1");
    }

    @Test
    public void test2(){
        System.out.println("I am inside testMethod2");
        Assert.assertTrue(false);  //to fail the test case
    }

    @Test(timeOut = 1000)
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("I am inside testMethod3");  //to timeout test case
    }

    @Test(dependsOnMethods = "test3")
    public void test4(){
        System.out.println("I am inside testMethod4");  //to skip the test case
    }
}
