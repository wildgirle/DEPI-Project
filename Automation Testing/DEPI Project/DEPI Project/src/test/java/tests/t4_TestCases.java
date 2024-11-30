package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p3_contectUs;
import pages.p4_testCases;

public class t4_TestCases extends testBase{
    p4_testCases testCases;
    HomePage homePage;

    SoftAssert soft =new SoftAssert();
    @Test
    public void Test_testCasesPage(){

        test =reports.createTest("validate Test Cases Page ");
        testCases=new p4_testCases(testBase.driver);
        homePage=new HomePage(testBase.driver);

        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        testCases.clickTestCaseBtn();
        soft.assertEquals(testCases.TestCases(),"TEST CASES", "not match");
        soft.assertAll();
    }
}
