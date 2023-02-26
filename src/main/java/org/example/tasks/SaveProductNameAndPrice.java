package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static org.example.userInterfaces.exitoMainPage.PRICE_TEXT;
import static org.example.userInterfaces.exitoMainPage.TITLE_OF_PRODUCT;

public class SaveProductNameAndPrice implements Task {
    String title;
    Integer currentPrice;

    @Override
    public <T extends Actor> void performAs(T actor) {
        title = TITLE_OF_PRODUCT.resolveFor(actor).getText();
        currentPrice = Integer.valueOf(PRICE_TEXT.resolveFor(actor).getText().replace("$", "")
                .replace(".", "")
                .replace(" ", ""));
        actor.remember("productTitle", title);
        actor.remember("productPrice", currentPrice);
    }

    public static SaveProductNameAndPrice onActor() {
        return Tasks.instrumented(SaveProductNameAndPrice.class);
    }
}
