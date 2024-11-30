package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class base {
    protected static WebDriver driver;
   protected Faker fake = new Faker();
    public base(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void click(By by){
        driver.findElement(by).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public void sendKeys(By by,String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void chooseRandomSelect(WebElement select,By option,int min){
        int selectNumber=driver.findElements(option).size();
        int random = fake.number().numberBetween(min,selectNumber+1);
        Select x =new Select(select);
        x.selectByIndex(random);
    }
    public void waitUntil(By by){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }
}
