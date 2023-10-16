package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtilities {


    public WebElement findElement(WebDriver driver, By locator){
        try {
            return driver.findElement(locator);
        }catch (NoSuchElementException e){
            System.out.println("Element was not found " + e.getMessage());
            return null;
        }
    }


    public WebElement findElementRetry(WebDriver driver, By locator, int numOfTries) throws InterruptedException {
        for ( int x = 1 ; x <= numOfTries ; x++){
            try {
                return driver.findElement(locator);
            }catch (NoSuchElementException e){
                Thread.sleep(1000);
            }
        }
        return null;


    }


}
