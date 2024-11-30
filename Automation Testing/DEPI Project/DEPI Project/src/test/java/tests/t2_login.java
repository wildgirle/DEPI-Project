package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p1_Register;
import pages.p2_login;
import tests.t1_Register;

public class t2_login extends testBase {
    p2_login login;
    HomePage homePage;

    t1_Register testRegister;
    p1_Register register;
    SoftAssert soft =new SoftAssert();
    @Test
    public void test2_WithValidData(){
        test =reports.createTest("validate logingIn to my account");
        login=new p2_login(testBase.driver);
        homePage=new HomePage(testBase.driver);

        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
//        soft.assertEquals(register.getHomePage(),"Home","not match");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        login.clickOnLoginLocator();
        soft.assertEquals(login.loginToYourAccount(),"Login to your account","not match");
        login.fillLoginData("yara.elsayed004@gmail.com","yara004");
        login.clickOnLonginButton();
        soft.assertEquals(login.myUserName()," Logged in as Keiko Mosley");
        test.pass("Loged IN successfully");
        test.info("email is yara.elsayed004@gmail.com "+"password is yara004");
//
        soft.assertAll();


    }
    @Test
    public void test3_WithInvalidData(){
        test =reports.createTest("Can't log in to invalid account");
        login=new p2_login(testBase.driver);
        homePage=new HomePage(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
//        soft.assertEquals(register.getHomePage(),"Home","not match");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        login.clickOnLoginLocator();
        soft.assertEquals(login.loginToYourAccount(),"Login to your account","not match");
        login.fillLoginData("ahmed.com","11");
        login.clickOnLonginButton();
        soft.assertEquals(login.yourEmailOrPasswordIsIncorrect(),"Your email or password is incorrect!", "not match");
        test.pass(" Can't LogIN ");
        test.info("email is uncorrected");
        soft.assertAll();

    }
    @Test
    public void test4_LogOut(){
        test =reports.createTest(" logingout my account");
        login=new p2_login(testBase.driver);
        homePage=new HomePage(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
//        soft.assertEquals(register.getHomePage(),"Home","not match");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        login.clickOnLoginLocator();
        soft.assertEquals(login.loginToYourAccount(),"Login to your account","not match");
        login.fillLoginData("yara.elsayed004@gmail.com","yara004");
        login.clickOnLonginButton();
        soft.assertEquals("Logged in as"+" "+login.myUserName(),"Logged in as"+" "+ login.myUserName());
        login.logOutLocator();
        soft.assertEquals(login.loginToYourAccount(),"Login to your account","not match");
        test.pass("LogedOut successfully");
        soft.assertAll();

    }


}










