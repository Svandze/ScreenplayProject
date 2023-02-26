package org.example.userInterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class googlePage {
    public static final Target INPUT_FIELD = Target.the("Input field locator")
            .located(By.name("q"));

    public static final Target FIRST_RESULT = Target.the("First google result")
            .located(By.xpath("(//h3)[1]"));
}
