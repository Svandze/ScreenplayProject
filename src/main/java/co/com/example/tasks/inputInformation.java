package co.com.example.tasks;

import co.com.example.userInterfaces.googlePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class inputInformation implements Task {

    String information;

    public inputInformation(String information) {
        this.information = information;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(information).into(googlePage.INPUT_FIELD).thenHit(Keys.ENTER));
        actor.remember("validation",information);
    }

    public static inputInformation onSearcher (String information){
        return Tasks.instrumented(inputInformation.class,information);
    }
}
