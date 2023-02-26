package co.com.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ComparePrices implements Question {
    Integer price;
    Integer finalPrice;
    Integer quantity;

    @Override
    public Boolean answeredBy(Actor actor) {
        quantity = actor.recall("quantity");
        price = actor.recall("productPrice");
        finalPrice = actor.recall("productFinalPrice");
        price *= quantity;
        return price.equals(finalPrice);
    }

    public static ComparePrices isOk() {
        return new ComparePrices();
    }
}
