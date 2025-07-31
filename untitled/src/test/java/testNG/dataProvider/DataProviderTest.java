package testNG.dataProvider;

import org.testng.annotations.Test;

public class DataProviderTest {

    //username = abc@gmail.com
    //password = abc123

    @Test(dataProvider = "info", dataProviderClass = CustomDataProvider.class)  // can get the mothod name also
    public void loginTest(String name, String password){
        System.out.println(name + " " +password);
    }






}
