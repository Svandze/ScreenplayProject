package co.com.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.example.userInterfaces.googlePage.FIRST_RESULT;

public class AwaitabilityTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               WaitUntil.the(FIRST_RESULT, WebElementStateMatchers.isClickable())
       );
    }
}
