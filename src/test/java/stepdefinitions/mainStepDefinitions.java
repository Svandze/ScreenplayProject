package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import co.com.example.exceptions.ItemNotFoundException;
import co.com.example.questions.ValidateFirstResult;
import co.com.example.tasks.inputInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

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
