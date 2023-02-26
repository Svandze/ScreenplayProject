package co.com.example.tasks;

import co.com.example.userInterfaces.exitoMainPage;
import co.com.example.utils.returnRandomAmount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class addRandomAmountOfProducts implements Task {
    int max;
    int min;
    String quantity;
    addRandomAmountOfProducts(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int totalItems = returnRandomAmount.getRandomIntInARange(1, 9);
        for (int i = 0; i < totalItems; i++) {
            actor.attemptsTo(
                    Click.on(exitoMainPage.PLUS_SYMBOL_BTN)
            );
        }
        quantity = String.valueOf(exitoMainPage.QUANTITY_TEXT.resolveFor(actor).getText().charAt(0));
        actor.remember("quantity", Integer.valueOf(quantity));
    }

    public static addRandomAmountOfProducts betweenARange(int max, int min) {
        return Tasks.instrumented(addRandomAmountOfProducts.class, max, min);
    }

}
