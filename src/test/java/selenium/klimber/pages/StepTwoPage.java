package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepTwoPage extends BasePage{
    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    // Form
    By illnessCheckboxFalse = By.xpath("//*[@name='UnderwritingCustom[0].ResponseBool' and @value='false']");
    By assistanceNeededCheckboxFalse = By.xpath("//*[@name='UnderwritingCustom[1].ResponseBool' and @value='false']");
    By heightInput = By.id("txtHeight");
    By weightInput = By.id("txtWeight");
    By hospitalizedCheckboxFalse = By.xpath("//*[@name='UnderwritingCustom[2].ResponseBool' and @value='false']");
    By submitButton = By.id("btnSaveStep2");


    /*
     * Methods
     */

    public void fillInHealthForm() {
        click(illnessCheckboxFalse);
        click(assistanceNeededCheckboxFalse);
        sendKeys(heightInput, user.getProperty("height"));
        sendKeys(weightInput, user.getProperty("weight"));
        click(hospitalizedCheckboxFalse);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertTrue(isChecked(illnessCheckboxFalse));
        Assertions.assertTrue(isChecked(assistanceNeededCheckboxFalse));
        Assertions.assertTrue(isEmpty(heightInput));
        Assertions.assertTrue(isEmpty(weightInput));
        Assertions.assertTrue(isChecked(hospitalizedCheckboxFalse));
    }

}
