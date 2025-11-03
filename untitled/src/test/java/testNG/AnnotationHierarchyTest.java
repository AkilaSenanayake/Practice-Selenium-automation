package testNG;

import org.testng.annotations.*;

public class AnnotationHierarchyTest {


    @Test
    public void Test1(){
        System.out.println("Test 1");
    }

    @Test
    public void Test2(){
        System.out.println("Test 2");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("After Suite");
    }

}
