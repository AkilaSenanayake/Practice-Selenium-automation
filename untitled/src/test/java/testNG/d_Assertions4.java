package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class d_Assertions4 {

    SoftAssert softAssert = new SoftAssert();

    String actualValue = "Akila";

    @Test(priority = 0)
    public void valuesEqualCheck(){   //Hard assertion

        String expectedValue = "Akila123";
        System.out.println("Prior to valuesEqualCheck");
//        Assert.assertEquals(actualValue,expectedValue,"Values miss matched");
        softAssert.assertEquals(actualValue,expectedValue,"Values miss matched");
        System.out.println("After valuesEqualCheck assertion");
        softAssert.assertAll();  // call in the final
    }

    @Test(priority = 1)
    public void valuesNotEqualCheck(){  //Hard assertion
        String expectedValue = "Test";
        System.out.println("Prior to valuesNotEqualCheck assertion");
//        Assert.assertNotEquals(actualValue,expectedValue,"Values matched");
        softAssert.assertNotEquals(actualValue,expectedValue,"Values matched");
        System.out.println("After to valuesNotEqualCheck assertion");
    }

    @Test(priority = 2)
    public void trueConditionCheck(){  //Hard assertion

        System.out.println("Prior to trueConditionCheck assertion");
//        Assert.assertTrue(actualValue.startsWith("A"),"Condition return a False");
        softAssert.assertTrue(actualValue.startsWith("A"),"Condition return a False");
        System.out.println("After to trueConditionCheck assertion");
    }

    @Test(priority = 3)
    public void falseConditionCheck(){  //Hard assertion

        System.out.println("Prior to falseConditionCheck assertion");
//        Assert.assertFalse(actualValue.isBlank(),"Condtion return a True");
        softAssert.assertFalse(actualValue.isBlank(),"Condtion return a True");
        System.out.println("After to falseConditionCheck assertion");
    }
}

