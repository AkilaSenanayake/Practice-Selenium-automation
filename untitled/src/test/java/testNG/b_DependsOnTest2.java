package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class b_DependsOnTest2 {

    @Test()
    public void oLevel(){
        System.out.println("O/level");
        Assert.assertEquals(1,1);
    }

    @Test(dependsOnMethods = "oLevel")
    public void aLevel(){
        System.out.println("a/level");
    }

    @Test(dependsOnMethods = {"oLevel","aLevel"}, alwaysRun = true)
    public void campus(){
        System.out.println("Campus");
    }

}
