package co.com.example.tasks;

import co.com.example.userInterfaces.exitoMainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SaveProductNameAndPrice implements Task {
    String title;
    Integer currentPrice;

    @Override
    public <T extends Actor> void performAs(T actor) {
        title = exitoMainPage.TITLE_OF_PRODUCT.resolveFor(actor).getText();
        currentPrice = Integer.valueOf(exitoMainPage.PRICE_TEXT.resolveFor(actor).getText().replace("$", "")
                .replace(".", "")
                .replace(" ", ""));
        actor.remember("productTitle", title);
        actor.remember("productPrice", currentPrice);
    }

    public static SaveProductNameAndPrice onActor() {
        return Tasks.instrumented(SaveProductNameAndPrice.class);
    }
}
