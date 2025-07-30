package testNG;

import org.testng.annotations.Test;

public class TestNG_Annotation_01 {
    public static void main(String[] args) {
        System.out.println("This is not a TestNG test 01");
        TestNG_Annotation_01 testanno01 = new TestNG_Annotation_01();
        testanno01.notTestNGMethod();
    }

    public void notTestNGMethod(){
        System.out.println("This is not a TestNG test 02");
    }

    @Test
    public void test(){
        System.out.println("TestNG Test 01");
    }
}
