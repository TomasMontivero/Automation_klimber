package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends BasePage{
    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    By fullName = By.xpath("//*[text()='Nombre Titular']//following-sibling::input");
    By id = By.id("ID_Number");
    By birthDate = By.xpath("//*[text()='Fecha de nacimiento']//following-sibling::input");
    By insuranceAmount = By.xpath("//*[text()='Suma asegurada']//following-sibling::input");
    By insuranceDisability = By.xpath("//*[text()='Adelanto de la Suma Asegurada por Invalidez por Accidente']//following-sibling::input");
    By insuranceAccident = By.xpath("//*[text()='Pago Doble por Muerte Accidental']//following-sibling::input");
    By insuranceIllness = By.xpath("//*[text()='Adelanto de la Suma Asegurada por Enfermedad Grave']//following-sibling::input");
    By monthlyPriceValue = By.id("txtSummaryTotalPremium");
    By agreementCheckbox = By.id("chkTC");
    By submitButton = By.id("btnSummarySubmit");


    /*
     * Methods
     */

    public void submitForm() {
        click(agreementCheckbox);
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertEquals(user.getProperty("name") + " " + user.getProperty("surname"), getValue(fullName));
        Assertions.assertEquals(user.getProperty("id"), getValue(id));
        Assertions.assertEquals(user.getProperty("birthday"), getValue(birthDate));
        Assertions.assertEquals(insurance.getProperty("total_insurance_value"), getValue(insuranceAmount));
        Assertions.assertEquals(insurance.getProperty("final_disability_value"), getValue(insuranceDisability));
        Assertions.assertEquals(insurance.getProperty("final_accident_value"), getValue(insuranceAccident));
        Assertions.assertEquals(insurance.getProperty("final_illness_value"), getValue(insuranceIllness));
        Assertions.assertEquals(insurance.getProperty("monthly_price_value"), getValue(monthlyPriceValue));
        Assertions.assertFalse(isChecked(agreementCheckbox));
    }

}
