package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p1_Register;
import pages.p2_login;

public class t1_Register extends testBase {
    p1_Register register;
    HomePage homePage;
    p2_login login;
    SoftAssert soft =new SoftAssert();
   public String email=fake.internet().safeEmailAddress();
   public String name =fake.name().name();
   public String Password =fake.internet().password(10,15);

    @Test
    public void test1_Register(){
        test =reports.createTest("validate creating new account");
        register=new p1_Register(testBase.driver);
        homePage=new HomePage(testBase.driver);
        login=new p2_login(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        System.out.println(register.getHomePage());
        soft.assertEquals(register.getHomePage(),"Home","not match");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));
        register.clickOnSignUpLocator();
        System.out.println(register.newUserSignup());
        soft.assertEquals(register.newUserSignup(),"New User Signup!","not match");
        register.fillSignUpData(email,name);
        register.clickOnSignUpButton();
        System.out.println(register.enterAccountInformation());
        soft.assertEquals(register.enterAccountInformation(),"ENTER ACCOUNT INFORMATION","not match");
        register.chooseRandomGender();
        register.selectRandomDate();
        register.fillInformation();
        register.createAccount();
        System.out.println(register.accountCreated());
        soft.assertEquals(register.accountCreated(),"ACCOUNT CREATED!","not match");
        register.continueAccount();
        System.out.println(register.loginAsUserName());
//        soft.assertEquals(register.loginAsUserName()," Logged in as ","not match");
        System.out.println(register.userNameLocator);
        soft.assertEquals("Logged in as"+" "+register.MyUserName,"Logged in as"+" "+ register.MyUserName);
        register.deleteAccount();
        soft.assertEquals(register.accountDeleted(),"ACCOUNT DELETED!");
        test.pass("register successfully");
        test.info("email is "+email);
        soft.assertAll();

    }
    @Test
    public void test5_RegisterWithExitingAccount(){
        test =reports.createTest("can,t create an account");
        register=new p1_Register(testBase.driver);
        homePage=new HomePage(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        System.out.println(register.getHomePage());
        soft.assertEquals(register.getHomePage(),"Home","not match");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));
        register.clickOnSignUpLocator();
        System.out.println(register.newUserSignup());
        soft.assertEquals(register.newUserSignup(),"New User Signup!","not match");
        register.fillSignUpData("yara.elsayed004@gmail.com","yara004");
        register.clickOnSignUpButton();
        System.out.println(register.emailAlreadyExist());
        soft.assertEquals(register.emailAlreadyExist(),"Email Address already exist!");
        test.pass("Can't register successfully");
        test.info("email is "+email);
        soft.assertAll();

    }



















//    p1_Register register;
//    @Test
//    public void signUpWthValidData(){
//        register.clickOnSignUpLocator();
//        register.fillSignUpData();
//        register.clickOnSignUpButton();
//        register.fillInformation();
//        register.createAccount();
//        register.deleteAccount();
//String firstName =fake.name().firstName();
//    String lastName = fake.name().lastName();
//    String company =fake.company().name();
//    String address_1 =fake.address().fullAddress();
//    String address_2 =fake.address().secondaryAddress();
//    String state =fake.address().state();
//    String city =fake.address().city();
//    String zipCode = fake.address().zipCode();
//    String mobileNumber =fake.phoneNumber().phoneNumber();
//    String password =fake.internet().password(10,15 );
//    }
}
