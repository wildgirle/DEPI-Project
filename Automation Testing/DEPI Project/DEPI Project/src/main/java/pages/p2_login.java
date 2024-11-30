package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class p2_login extends base{
    public p2_login(WebDriver driver) {
        super(driver);
//        String email = fake.internet().safeEmailAddress();
//        String password =fake.internet().password(10,15);

//        p1_Register register;
//        register=new reg;
//        String password =register.password;

    }
    private final By loginLocator = By.xpath("//*[@href=\"/login\"]");
    private final By loginEmailLocator =By .xpath("//*[@data-qa=\"login-email\"]");
    private final By loginPasswordLocator =By.xpath("//*[@data-qa=\"login-password\"]");
    private final By loginButtonLocator =By.xpath("//*[@data-qa=\"login-button\"]");
    private final By deleteAccountButtonLocator= By.xpath("//*[@href=\"/delete_account\"]");
    private final By logOutLocator=By.xpath("//*[@href=\"/logout\"]");
    public  By userNameLocator =By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
    private final By homeProductPriceLocator =By.xpath("//*[@class=\"col-sm-4\"][5]//*[@class=\"productinfo text-center\"]//h2");
    private final By homeProductNameLocator =By.xpath("//*[@class=\"col-sm-4\"][5]//*[@class=\"productinfo text-center\"]//p");
    private final  By homePageProductImgLocator =By.xpath("//*[@class=\"col-sm-4\"][5]//*[@class=\"productinfo text-center\"]//img");
    private final By viewProductLocator =By.xpath("//*[@class=\"col-sm-4\"][5]//*[@class=\"choose\"]");
    private final By productImgLocator =By.xpath("//*[@src=\"/get_product_picture/5\"]");
    private final By productPriceLocator =By.xpath("//*[@class=\"col-sm-7\"]//span//span");
    private final  By loginToYourAccountLocator =By.xpath("//*[@class=\"login-form\"]/h2");
    private final By yourEmailOrPasswordIsIncorrectLocator =By.xpath("//*[@class=\"login-form\"]//p");






    public void clickOnLoginLocator(){
        click(loginLocator);
    }
    public void fillLoginData(String email, String password){
        sendKeys(loginEmailLocator,email);
        sendKeys(loginPasswordLocator,password);
    }
    public void clickOnLonginButton(){
        click(loginButtonLocator);
    }
    public void deleteAccount(){

        click(deleteAccountButtonLocator);
    }
    public void logOutLocator(){
        click(logOutLocator);
    }
    public String loginToYourAccount(){
        String loginToYourAccount=driver.findElement(loginToYourAccountLocator).getText();
        return loginToYourAccount;
    }
    public String yourEmailOrPasswordIsIncorrect(){
        String yourEmailOrPasswordIsIncorrect =driver.findElement(loginToYourAccountLocator).getText();
        return yourEmailOrPasswordIsIncorrect;
    }
    public String myUserName (){
        String myUserName =driver.findElement(userNameLocator).getText();
        return myUserName;
    }


}
