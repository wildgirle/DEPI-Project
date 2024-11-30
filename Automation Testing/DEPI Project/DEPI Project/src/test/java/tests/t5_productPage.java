package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.p5_productsPage;

import java.util.List;

public class t5_productPage extends testBase{
    p5_productsPage productsPage;
    HomePage homePage;

    SoftAssert soft =new SoftAssert();
    @Test
    public void firstProductPage(){
        test =reports.createTest("validate first Product details");
        productsPage = new p5_productsPage(testBase.driver);
        homePage=new HomePage(testBase.driver);

        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        Assert.assertEquals("rgba(255, 165, 0, 1)",homePage.homeBtnLocator.getCssValue("color"));

        productsPage.clickProductPageBtn();
        System.out.println(productsPage.allProducts());
        soft.assertEquals(productsPage.allProducts(),"ALL PRODUCTS","not match");
        productsPage.firstProductView();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/product_details/1");
        System.out.println(productsPage.productName());
        soft.assertEquals(productsPage.productName(),"Blue Top","not match");
        System.out.println(productsPage.productCategory());
        soft.assertEquals(productsPage.productCategory(),"Category: Women > Tops","not match");
        System.out.println(productsPage.productPrice());
        soft.assertEquals(productsPage.productPrice(),"Rs. 500","not match");
        System.out.println(productsPage.productAvailability());
        soft.assertEquals(productsPage.productAvailability(),"Availability: In Stock","not match");
        System.out.println(productsPage.productCondition());
        soft.assertEquals(productsPage.productCondition(),"Condition: New","not match");
        System.out.println(productsPage.productBrand());
        soft.assertEquals(productsPage.productBrand(),"Brand: Polo","not match");
        soft.assertAll();
    }
    @Test
    public void searchProduct(){
        test =reports.createTest("validate searching for items");
        productsPage = new p5_productsPage(testBase.driver);
        soft.assertEquals(testBase.driver.getCurrentUrl(),"https://www.automationexercise.com/");
        productsPage.clickProductPageBtn();
        System.out.println(productsPage.allProducts());
        soft.assertEquals(productsPage.allProducts(),"ALL PRODUCTS","not match");
        productsPage.searchBox("top");
        productsPage.searchBtn();
        System.out.println(productsPage.searchedProducts());
        soft.assertEquals(productsPage.searchedProducts(),"SEARCHED PRODUCTS","NOT MATCH");
        List<String> productTexts = productsPage.getAllProductTexts();
        for (String productText : productTexts) {
            Assert.assertTrue(productText.contains("Top"), "Product text does not contain 'top': " + productText);
        }

    }
}
