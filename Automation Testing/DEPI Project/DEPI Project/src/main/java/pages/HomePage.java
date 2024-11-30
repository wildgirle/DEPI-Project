package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends base{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
   public WebElement homeBtnLocator;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement subscriptionTxtLocator;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[2]/div/div/p")
    public WebElement footerLocator;
//    public By subscriptionTxtLocator  =By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
//    @FindBy(id = "susbscribe_email")
//    WebElement subscriptionEmailLocator;
    private final By subscriptionEmailLocator = By.id("susbscribe_email");
//    @FindBy(id = "subscribe")
//    WebElement enterSubscripeLoctor;
    private final By enterSubscripeLoctor =By.id("subscribe");
    public  void scrollToElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footerLocator).perform();
    }
    public void enterSubscriptionEmail(String email){
        sendKeys( subscriptionEmailLocator,email);
    }
    public void clickEnterSupiscripe(){
        click(enterSubscripeLoctor);
    }

}

