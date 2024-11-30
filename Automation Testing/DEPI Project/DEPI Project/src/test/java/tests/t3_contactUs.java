package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p1_Register;
import pages.p2_login;
import pages.p3_contectUs;


public class t3_contactUs extends testBase{
    p3_contectUs contactUs;
    HomePage homePage;

    p2_login login;
    t2_login testLogin;
    t1_Register testRegister;
    p1_Register register;
    SoftAssert soft =new SoftAssert();
    @Test
    public void contactUsWithData(){
        test =reports.createTest("validate fill ContactUs With Data");
        contactUs=new p3_contectUs(testBase.driver);
        homePage=new HomePage(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        contactUs.contactUsBtn();
//        contactUs.fillContactUsInfo("yara","yara@gmail.com","hello","my name is yara");
        contactUs.fillContactUsInfo("Yara","yara@gmial.com","HELLO","My Name Is Yara");
        contactUs.uploadFile();
        soft.assertAll();
        contactUs.clickSubmit();
        Alert confirmAlert = driver.switchTo().alert();
        Assert.assertEquals("Press OK to proceed!",confirmAlert.getText());
        confirmAlert.accept();
        System.out.println(contactUs.submitMassageTxt());
        soft.assertEquals(contactUs.submitMassageTxt(),"Success! Your details have been submitted successfully.");
        contactUs.clickContinueHome();
        test.pass(" successfully contactUs");
//        test.fail("fail");
        soft.assertAll();


    }
}
