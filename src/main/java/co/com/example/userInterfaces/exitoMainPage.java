package co.com.example.userInterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class exitoMainPage {
    public static final Target DROPDOWN = Target.the("Selects the dropdown menu on main the page")
            .located(By.id("category-menu"));

    public static final Target CATEGORIES = Target.the("Selects a category")
            .locatedBy("//p[contains(text(),'{0}')]");

    public static final Target SUBCATEGORIES = Target.the("Selects a random subcategory")
            .locatedBy("//p[contains(text(),'{0}')]");

    public static final Target PRODUCTS = Target.the("Selects a product")
            .locatedBy("//div[@id='gallery-layout-container']/div/section/a/article");

    public static final Target ADD_BTN = Target.the("Clicks on the add product button")
            .locatedBy("(//button[@tabindex])[3]");

    public static final Target PLUS_SYMBOL_BTN = Target.the("Clicks the plus button to add more items")
            .locatedBy("//*[@class='product-details-exito-vtex-components-buy-button-manager-more']");

    public static final Target TITLE_TO_SCROLL = Target.the("Targets the title to avoid the whatsapp icon")
            .locatedBy("//*[contains(text(),'Vendido')]");

    public static final Target TITLE_OF_PRODUCT = Target.the("Targets the title to avoid the whatsapp icon")
            .locatedBy("//span[@class='vtex-store-components-3-x-productBrand ']");

    public static final Target CART_BUTTON = Target.the("Cart icon")
            .locatedBy("//a[@class='exito-header-3-x-minicartLink']");

    public static final Target PRICE_TEXT = Target.the("Product price")
            .locatedBy("//div[@class='exito-vtex-components-4-x-PricePDP']/span");

    public static final Target QUANTITY_TEXT = Target.the("Product quantity")
            .locatedBy(".exito-vtex-components-4-x-stepperContainerQty");

}

