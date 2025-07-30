package testNG.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest2 {

    @Test
    @Parameters({"value1","value2"})
    public void diff(int v1,int v2){
        int finalDiff = v1-v2;
        System.out.println("The final difference of the given value is "+finalDiff);
    }
}
