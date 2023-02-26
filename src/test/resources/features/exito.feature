Feature: Exito test

  Scenario Outline: Selection of products

    Given the user enters the page and selects a "<category>" and a "<subcategory>"
    When the user selects a random product and take between 1 and 10 of it
    Then the result on the cart should be ok
    Examples:
      | category   | subcategory             |
      | Tecnología | Tablets                 |
      | Deportes   | Plataformas vibratorias |
      | Tecnología | Monitores               |
