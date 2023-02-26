package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.questions.ComparePrices;
import org.example.tasks.SaveProductNameAndPrice;
import org.example.tasks.addRandomAmountOfProducts;
import org.example.tasks.getFinalPrice;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.example.userInterfaces.exitoMainPage.*;

public class exitoStepDefinitions {

    @Given("the user enters the page and selects a {string} and a {string}")
    public void theUserEntersThePageAndSelectsAAndA(String categoria, String subcategoria) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://www.exito.com/"),
                Click.on(DROPDOWN),
                Click.on(CATEGORIES.of(categoria)),
                Click.on(SUBCATEGORIES.of(subcategoria)),
                Click.on(PRODUCTS),
                SaveProductNameAndPrice.onActor()
        );
    }

    @When("the user selects a random product and take between {int} and {int} of it")
    public void theUserSelectsARandomProductAndTakeBetweenAndOfIt(Integer min, Integer max) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ADD_BTN),
                Scroll.to(TITLE_TO_SCROLL),
                addRandomAmountOfProducts.betweenARange(min, max),
                Click.on(CART_BUTTON),
                getFinalPrice.method()
        );
    }

    @Then("the result on the cart should be ok")
    public void theResultOnTheCartShouldBeOk() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ComparePrices.isOk(), Matchers.is(true))
        );
    }


}
