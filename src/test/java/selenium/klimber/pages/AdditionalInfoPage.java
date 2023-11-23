package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionalInfoPage extends BasePage{
    public AdditionalInfoPage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    By nationalityDropdown = By.xpath("//*[contains(@id,\"Nationality\")]/following-sibling::*");
    By nationalityOption = By.xpath("//*[contains(@id,\"Nationality\")]//option[text()='Argentina']");
    By nationalityFirstOption = By.xpath("//*[contains(@id,\"Nationality\")]//option[1]");
    By birthLocationInput = By.id("PlaceOfBirth");
    By ocupationInput = By.id("txtOccupation");
    By incomeInput = By.id("txtSalaryAnual");
    By incomeOriginDropdown = By.xpath("//*[contains(@id,\"txtAnnualIncome\")]/following-sibling::*");
    By incomeOriginOption = By.xpath("//*[contains(@id,\"txtAnnualIncome\")]//option[text()='Sueldo']");
    By incomeOriginFirstOption = By.xpath("//*[contains(@id,\"txtAnnualIncome\")]//option[1]");
    By submitButton = By.id("btnSaveInfo");


    /*
     * Methods
     */

    public void fillInAdditionalInfoForm() {
        click(nationalityDropdown);
        click(nationalityOption);
        sendKeys(birthLocationInput, user.getProperty("birth_location"));
        sendKeys(ocupationInput, user.getProperty("occupation"));
        sendKeys(incomeInput, user.getProperty("annual_income"));
        click(incomeOriginDropdown);
        click(incomeOriginOption);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertEquals("Nacionalidad", getText(nationalityFirstOption));
        Assertions.assertTrue(isEmpty(birthLocationInput));
        Assertions.assertTrue(isEmpty(ocupationInput));
        Assertions.assertTrue(isEmpty(incomeInput));
        Assertions.assertEquals("-- Seleccionar --", getText(incomeOriginFirstOption));
    }

}
