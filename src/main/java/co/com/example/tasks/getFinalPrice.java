package co.com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.example.userInterfaces.cartPage.FINAL_PRICE;

public class getFinalPrice implements Task {
    Integer price;

    @Override
    public <T extends Actor> void performAs(T actor) {
        price = Integer.valueOf(FINAL_PRICE.resolveFor(actor).getText().replace("$", "")
                .replace(".", "")
                .replace(" ", ""));
        actor.remember("productFinalPrice", price);
    }


    public static getFinalPrice method() {
        return Tasks.instrumented(getFinalPrice.class);
    }
}
