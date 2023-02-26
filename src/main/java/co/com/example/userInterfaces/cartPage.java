package co.com.example.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class cartPage {
    public static final Target FINAL_PRICE = Target.the("Final price of products")
            .locatedBy("//td[@class='monetary exito-checkout-monetary']");
}
