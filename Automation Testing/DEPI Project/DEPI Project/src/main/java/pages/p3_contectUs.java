package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class p3_contectUs extends base{
    public p3_contectUs(WebDriver driver) {
        super(driver);

    }
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a")
    WebElement contactUsBtn;
    private final By contactNameLocator =By.name("name");
//    @FindBy(name = "name")
//    WebElement contactNameLocator;
    private final By contactEmailLocator =By.cssSelector("#contact-us-form > div:nth-child(3) > input");
//    @FindBy(css = "#contact-us-form > div:nth-child(3) > input")
//    WebElement contactEmailLocator;
    private final By contactSubjectLocator=By.cssSelector("#contact-us-form > div:nth-child(4) > input");
//    @FindBy(css = "#contact-us-form > div:nth-child(4) > input")
//    WebElement contactSubjectLocator;
    private final By contactMessageLocator = By.id("message");
//    @FindBy(id = "message")
//    WebElement contactMessageLocator;
    @FindBy(css = "#contact-us-form > div:nth-child(6) > input")
    WebElement uploadFile;
    private final By submitBtn = By.name("submit");
    private final By submitMassageLocator =By.xpath("//*[@class=\"status alert alert-success\"]");
    private final By continueHomeBtnLocator = By.xpath("//*[@class=\"btn btn-success\"]");

    public void contactUsBtn() {
        contactUsBtn.click();
    }
    public void fillContactUsInfo(String contactName, String contactEmail,String contactSubject,String contactMassage){
        sendKeys((By) contactNameLocator,contactName);
        sendKeys((By) contactEmailLocator, contactEmail);
        sendKeys((By) contactSubjectLocator,contactSubject);
        sendKeys((By) contactMessageLocator,contactMassage);
    }
    public void uploadFile() {
        String filePath = "C:\\Users\\Orbit Laptop\\OneDrive\\Desktop\\HELLO CONTACT US MASSAGE.pdf";
        File file = new File(filePath);
        if (file.exists()) {
            uploadFile.sendKeys(filePath);
        } else {
            System.out.println("File does not exist: " + filePath);
        }

    }
    public void clickSubmit(){
        click(submitBtn);
    }
    public String submitMassageTxt(){
       String submitMassageTxt = driver.findElement(submitMassageLocator).getText();
       return submitMassageTxt;

    }
    public void clickContinueHome (){
        click(continueHomeBtnLocator);
    }
}
