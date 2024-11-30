package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class p5_productsPage extends base {

    public p5_productsPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> products;


    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a")
    WebElement productPageBtn;
//    public By productPageBtnLocator =By.xpath("//*[@class=\"shop-menu pull-right\"]//*[@href=\"/products\"]");

    //    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a")
//    WebElement firstProductViewBtn;
    public By firstProductViewBtnLocator = By.xpath("//*[@class=\"col-sm-4\"]//*[@href=\"/product_details/1\"]");
    //    @FindBy (xpath = "//*[@class=\"features_items\"]/h2")
//    WebElement allProductsTxt;
    public By allProductsTxtLocator = By.xpath("//*[@class=\"features_items\"]/h2");
    public By productNameLocator = By.xpath("//*[@class=\"product-information\"]/h2");
    public By productCategoryLocator = By.xpath("//*[@class=\"product-information\"]/p");
    public By productPriceLocator = By.xpath("//*[@class=\"product-information\"]/span/span");
    public By productAvailabilityLocator = By.xpath("//*[@class=\"product-information\"]/p[2]");
    public By productConditionLocator = By.xpath("//*[@class=\"product-information\"]/p[3]");
    public By productBrandLocator = By.xpath("//*[@class=\"product-information\"]/p[4]");
    public By searchBoxLocator=By.id("search_product");
    public By searchBtnLocator = By.id("submit_search");
    public By searchedProductTxtLocator = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    public By productsListLocator =By.xpath("//*[@class=\"col-sm-4\"]");




    public void clickProductPageBtn() {
        click(productPageBtn);
    }
//    int products =driver.findElements(productsListLocator).size();
//   public List<WebElement> products = driver.findElements(productsListLocator);
//   for (WebElement product : products) {
//        String productTxt = product.getText().toLowerCase();
//    }
    public List<WebElement>productsList() {
        List<WebElement> products = driver.findElements(productsListLocator);
        return products;
    }
    public List<String> getAllProductTexts() {
        List<WebElement> products = productsList();
        List<String> productTexts = new ArrayList<>();
        for (int i = 1; i < products.size() - 3; i++) {
            WebElement product = products.get(i);
            String productTxt = product.getText();
            productTexts.add(productTxt);
        }

        return productTexts;
    }



    //    public String allProducts =driver.findElement(allProductsTxtLocator).getText();
    public String allProducts() {
        String allProducts = driver.findElement(allProductsTxtLocator).getText();
        return allProducts;
    }
    public String searchedProducts(){
        String searchedProductTxt = driver.findElement(searchedProductTxtLocator).getText();
        return searchedProductTxt;
    }
    public void firstProductView() {
        click(firstProductViewBtnLocator);
    }
    public void searchBox(String item){sendKeys(searchBoxLocator,item);}
    public void searchBtn(){click(searchBtnLocator);}
    public String productName() {
        String productName = driver.findElement(productNameLocator).getText();
        return productName;
    }
    public String productCategory() {
        String productCategory = driver.findElement(productCategoryLocator).getText();
        return productCategory;
    }
    public String productPrice() {
        String productPrice = driver.findElement(productPriceLocator).getText();
        return productPrice;
    }
    public String productAvailability() {
        String productAvailability= driver.findElement(productAvailabilityLocator).getText();
        return productAvailability;
    }
    public String productCondition() {
        String productCondition = driver.findElement(productConditionLocator).getText();
        return productCondition;
    }
    public String productBrand(){
        String productBrand = driver.findElement(productBrandLocator).getText();
        return productBrand;
    }
}
