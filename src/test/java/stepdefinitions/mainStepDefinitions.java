package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.internal.tool.Main;
import jxl.common.Logger;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.example.exceptions.ItemNotFoundException;
import org.example.questions.ValidateFirstResult;
import org.example.tasks.inputInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class mainStepDefinitions {
    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("actor");
    }


    @Given("User opens navigator")
    public void user_opens_navigator() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.google.com/"));
    }

    @When("input {string} on searcher")
    public void inputOnSearcher(String information) {
        OnStage.theActorInTheSpotlight().attemptsTo(inputInformation.onSearcher(information));
    }

    @Then("he will get return containing that string")
    public void he_will_get_return_containing_that_string() {
        String validation = OnStage.theActorInTheSpotlight().recall("validation");
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ValidateFirstResult.ofGoogleIs(validation), is(true))
                        .orComplainWith(ItemNotFoundException.class, "Page title was not found"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
