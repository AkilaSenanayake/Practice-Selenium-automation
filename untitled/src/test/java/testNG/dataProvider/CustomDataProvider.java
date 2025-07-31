package testNG.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "info")
    public Object[][] getData(){
        Object[][] data = {{"abc@gmail.com","abc123"},{"abc@gmail.com","123"},{"def@gmail.com","def"}};
        return data;
    }
}
