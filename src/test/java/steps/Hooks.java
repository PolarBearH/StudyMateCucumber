package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {


    @Before
    public void beforeS() {
        System.out.println("---- BEFORE ----");
    }


    @After
    public void afterS() {
        System.out.println("Test complete");
        System.out.println("---- AFTER ----");
        System.out.println();
    }


}
