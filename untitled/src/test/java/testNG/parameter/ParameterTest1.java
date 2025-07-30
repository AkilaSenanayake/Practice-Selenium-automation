package testNG.parameter;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest1 {

    @Test
    @Parameters({"value1","value2"})
    public void Sum(@Optional("1000") int v1,@Optional("520") int v2){
        int finalSum = v1 + v2;
        System.out.println("The final sum of the given values is : "+finalSum);
    }
}
