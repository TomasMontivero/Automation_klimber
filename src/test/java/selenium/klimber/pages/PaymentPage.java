package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    By cardNumberInput = By.id("CardNumber");
    By agreementCheckbox = By.id("chkDebAuto");
    By submitButton = By.id("btnSubmitStep4");


    /*
     * Methods
     */

    public void fillInPaymentForm() {
        sendKeys(cardNumberInput, user.getProperty("card_number"));
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertTrue(isEmpty(cardNumberInput));
        Assertions.assertTrue(isChecked(agreementCheckbox));
    }

}
