package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class p4_testCases extends base{
    public p4_testCases(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")
    WebElement testCaseBtn;
//    @FindBy(css = "#form > div > div.row > div > h2 > b")
//    WebElement testCaseTxtLocator;
    private final  By testCaseTxtLocator =By.cssSelector("#form > div > div.row > div > h2 > b");

    public void clickTestCaseBtn(){
       click( testCaseBtn);
    }
    public String TestCases(){
        String TestCases= driver.findElement(testCaseTxtLocator).getText();
        return TestCases;
    }
}
