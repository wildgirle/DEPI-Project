package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p5_productsPage;

public class t6_Subscription extends testBase{
    HomePage homePage;
    SoftAssert soft =new SoftAssert();
@Test
    public void verifySubscriptionInHomePage() throws InterruptedException {
    test = reports.createTest("verify Subscription In Home Page ");
    homePage = new HomePage(testBase.driver);
    System.out.println(homePage.homeBtnLocator.getCssValue("color"));
    Assert.assertEquals("rgba(255, 165, 0, 1)", homePage.homeBtnLocator.getCssValue("color"));
    homePage.scrollToElement();
    Thread.sleep(4000);
    Assert.assertEquals("SUBSCRIPTION",homePage.subscriptionTxtLocator.getText());
    Thread.sleep(4000);
    homePage.enterSubscriptionEmail("yara@gmail.com");
    homePage.clickEnterSupiscripe();

  }
}
