package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.example.userInterfaces.googlePage.FIRST_RESULT;

public class ValidateFirstResult implements Question {
    String validation;

    public ValidateFirstResult(String validation) {
        this.validation = validation;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return FIRST_RESULT.resolveFor(actor).getText().equals(validation);
    }

    public static ValidateFirstResult ofGoogleIs(String validation){
        return new ValidateFirstResult(validation);
    }
}
