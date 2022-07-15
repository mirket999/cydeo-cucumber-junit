Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "visa"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table

@saucelabs
  Scenario Outline: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<streetName>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipcode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expiryDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table
    @femaleScientists
    Examples: Famous female scientists
      | productType | quantity | customerName | streetName          | city   | state      | zipcode | cardType   | cardNumber   | expiryDate | expectedName  |
      | MoneyCog    | 3        | Marie        | London Street 42836 | London | England    | 43836   | visa       | 123456789012 | 16/26      | Marie Curie   |
      | Familybea   | 5        | Omer Demirel | Ankara Street 42836 | Ankara | Africa     | 43836   | mastercard | 123456789012 | 15/35      | Omer Demirel  |
      | Screenable  | 500      | Merve        | Konya Street 42836  | Konya  | Antarctica | 43836   | visa       | 123456789012 | 16/23      | Merve Demirel |

    @maleScientists
    Examples: Famous male scientists
      | productType | quantity | customerName | streetName          | city   | state      | zipcode | cardType   | cardNumber   | expiryDate | expectedName |
      | MoneyCog    | 3        | invalid      | London Street 42836 | London | England    | 43836   | visa       | 123456789012 | 16/26      | Charlie      |
      | Familybea   | 5        | invalid      | Ankara Street 42836 | Ankara | Africa     | 43836   | mastercard | 123456789012 | 15/35      | Ali          |
      | Screenable  | 500      | invalid      | Konya Street 42836  | Konya  | Antarctica | 43836   | visa       | 123456789012 | 16/23      | Veli         |
