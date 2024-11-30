package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class p1_Register extends base {
    public p1_Register(WebDriver driver) {
        super(driver);
    }
    public String password =fake.internet().password(10,15 );
   public String firstName=fake.name().firstName();
    public String lastName=fake.name().lastName();

    public By signUpLocator =By.xpath("//*[@class=\"col-sm-8\"]//*[@href=\"/login\"]");
    public By name1Locator = By.xpath("//*[@data-qa=\"signup-name\"]");
   public By emailLocator = By .xpath("//*[@data-qa=\"signup-email\"]");
    public By signUpButton =By.xpath("//*[@data-qa=\"signup-button\"]");
    private final By genderLocator = By.xpath("//*[@class=\"radio-inline\"]//input");
    private final By name2Locator = By.xpath("//*[@data-qa=\"name\"]");
    private final By passwordLocator =By .xpath("//*[@data-qa=\"password\"]");
    private final By dayLocator = By.xpath("//*[@data-qa=\"days\"]/option");
    private final By monthLocator = By.xpath("//select[@data-qa=\"months\"]/option");
    private final By yearLocator = By.xpath("//*[@data-qa=\"years\"]");
    private final By chickBoxLocator1 = By.xpath("//*[@class=\"checkbox\"]//*[@name=\"newsletter\"]");
    private final By chickBoxLocator2 = By.xpath("//*[@class=\"checkbox\"]//*[@name=\"optin\"]");
    private final By firstNameLocator= By.xpath("//*[@data-qa=\"first_name\"]");
    private final By lastNameLocator= By.xpath("//*[@data-qa=\"last_name\"]");
    private final By companyNameLocator= By.xpath("//*[@data-qa=\"company\"]");
    private final By address1Locator= By.xpath("//*[@data-qa=\"address\"]");
    private final By address2Locator= By.xpath("//*[@data-qa=\"address2\"]");
    private final By countryLocator= By.xpath("//*[@data-qa=\"country\"]//option");
    private final By stateLocator= By.xpath("//*[@data-qa=\"state\"]");
    private final By cityLocator= By.xpath("//*[@data-qa=\"city\"]");
    private final By zipCodeLocator= By.xpath("//*[@data-qa=\"zipcode\"]");
    private final By mobilePhoneLocator= By.xpath("//*[@data-qa=\"mobile_number\"]");
    private final By createAccountButtonLocator= By.xpath("//*[@data-qa=\"create-account\"]");
    private final By continueButtonLocator= By.xpath("//*[@class=\"pull-right\"]");
    private final By deleteAccountButtonLocator= By.xpath("//*[@href=\"/delete_account\"]");
   public By  homePageLocator = By.xpath("//*[@class=\"nav navbar-nav\"]//*[@href=\"/\"]");
    private final By newUserSignupLocator =By.xpath("//*[@class=\"signup-form\"]//h2");
    private final By enterAccountInformationLocator =By.xpath("//*[@class=\"login-form\"]//h2");
    private final By accountCreatedLocator =By.xpath("//*[@class=\"col-sm-9 col-sm-offset-1\"]//b");
    public By loginAsUserNameLocator =By .xpath("//*[@class=\"nav navbar-nav\"]//li[10]");
    public  By userNameLocator =By.xpath("//*[@class=\"nav navbar-nav\"]//b");
    private final By accountDeletedLocator = By.xpath("//*[@class=\"col-sm-9 col-sm-offset-1\"]//h2");
    private final By emailAddressAlreadyExistLocator =By.xpath("//*[@class=\"signup-form\"]//p");





    @FindBy(xpath = "//*[@data-qa=\"days\"]")
    private WebElement daySelector;

    @FindBy(xpath = "//*[@data-qa=\"months\"]")
    private WebElement monthSelector;
    @FindBy(xpath = "//*[@data-qa=\"years\"]")
    private WebElement yearSelector;
    @FindBy(xpath = "//*[@data-qa=\"country\"]")
    private WebElement countrySelector;
    public void clickOnSignUpLocator(){
        click(signUpLocator);
    }
    public void fillSignUpData(String email,String name){
        sendKeys(emailLocator,email);
        sendKeys(name1Locator,name);

    }
    public void clickOnSignUpButton(){

        click(signUpButton);
    }
    public void chooseRandomGender(){
        int num = driver.findElements(genderLocator).size();
        int random = fake.number().numberBetween(1,num+1);
        By gender =By.xpath("//*[@class=\"radio-inline\"]["+random+"]//input");
        click(gender);
    }
    public void selectRandomDate(){
        chooseRandomSelect(daySelector,dayLocator,2);
        chooseRandomSelect(yearSelector,yearLocator,2);
        chooseRandomSelect(monthSelector, monthLocator,2);
        chooseRandomSelect(countrySelector,countryLocator,1);
    }
    public void fillInformation(){
        sendKeys(passwordLocator,password);
        click(chickBoxLocator1);
        click(chickBoxLocator2);
        sendKeys(firstNameLocator,firstName);
        sendKeys(lastNameLocator,lastName);
        sendKeys(companyNameLocator,"jchsui");
        sendKeys(address1Locator,"JFHOIHEOWHE");
        sendKeys(address2Locator,"HIEHOHOEQI");
        sendKeys(stateLocator,"KAHOEHOQH");
        sendKeys(cityLocator,"HFEUQHFQ");
        sendKeys(zipCodeLocator,"2516849");
        sendKeys(mobilePhoneLocator,"lihpifhpihfpi");

    }
    public void createAccount(){
        click(createAccountButtonLocator);


    }


    public void  continueAccount(){
        click(continueButtonLocator);


    }
    public String MyUserName =firstName+" "+lastName;


    public void deleteAccount(){

        click(deleteAccountButtonLocator);
    }
    public String getHomePage(){
        String homePage =driver.findElement(homePageLocator).getText();
        return homePage;

    }
    public String newUserSignup(){
        String newUser =driver.findElement(newUserSignupLocator).getText();
        return newUser;

    }
    public String enterAccountInformation(){
        String accountInformation=driver.findElement(enterAccountInformationLocator).getText();
        return accountInformation;

    }
    public String accountCreated(){
        String accountCreated=driver.findElement(accountCreatedLocator).getText();
        return accountCreated;

    }
    public String loginAsUserName(){
        String loginAsUserName=driver.findElement(loginAsUserNameLocator).getText();
        return loginAsUserName;

    }


    public String accountDeleted(){
        String accountDeleted=driver.findElement(accountDeletedLocator).getText();
        return accountDeleted;
    }
    public String emailAlreadyExist(){
        String emailAddressAlreadyExist=driver.findElement(emailAddressAlreadyExistLocator).getText();
        return emailAddressAlreadyExist;

    }

}
