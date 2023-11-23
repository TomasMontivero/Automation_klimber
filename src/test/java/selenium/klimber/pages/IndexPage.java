package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndexPage extends BasePage{
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    /*
    * Attributes
    */

    // Form inputs
    By birthdayInput = By.id("BirthdayStep1");
    By provinceDropdown = By.xpath("//*[contains(@id,\"province\")]//following-sibling::span");
    By provinceFirstOption = By.xpath("//*[contains(@id,\"province\")]//option[1]");
    By provinceOption = By.xpath("//*[contains(@id,\"province\")]//option[text()='CABA']");
    By phoneCodeInput = By.id("txtPhoneCode");
    By phoneNumberInput = By.id("txtPhoneNumber");
    By coverageAmountSlider = By.className("slider-handle");
    By totalInsuranceValue = By.id("suma_aseguradatotal");
    By monthlyPriceValue = By.className("monthlyPrice");

    // Additional options
    By disabilityCheckbox = By.id("chkDisability");
    By accidentCheckbox = By.id("chkAccident");
    By illnessCheckbox = By.id("chkIllness");
    By disabilityValue = By.xpath("//*[contains(@id,\"chkDisability\")]//following-sibling::*[contains(@class, 'GroupLife_Coverage_Value_3')]");
    By accidentValue = By.xpath("//*[contains(@id,\"chkAccident\")]//following-sibling::*[contains(@class, 'GroupLife_Coverage_Value_2')]");
    By illnessValue = By.xpath("//*[contains(@id,\"chkIllness\")]//following-sibling::*[contains(@class, 'GroupLife_Coverage_Value_4')]");


    // Details boxes
    By coverageBoxValue = By.xpath("//div[contains(@id,\"GroupLife_Coverage_1\")]//*[contains(@class, 'GroupLife_Coverage_Value_1')]");
    By accidentBoxValue = By.xpath("//div[contains(@id,\"GroupLife_Coverage_2\")]//*[contains(@class, 'GroupLife_Coverage_Value_2')]");
    By disabilityBoxValue = By.xpath("//div[contains(@id,\"GroupLife_Coverage_3\")]//*[contains(@class, 'GroupLife_Coverage_Value_3')]");
    By illnessBoxValue = By.xpath("//div[contains(@id,\"GroupLife_Coverage_4\")]//*[contains(@class, 'GroupLife_Coverage_Value_4')]");

    // Submit
    By submitButton = By.id("btnSaveStep1");

    // Alert
    By alertMessage = By.xpath("//div[text()='Lamentablemente, no se pudo procesar los datos, contactese con centro de soporte: Policy per person limit 1 reached.']");


    /*
    * Methods
    */

    public void navigateToIndexPage() {
        driver.get(urls.getProperty("index"));
    }

    public void fillInInsuranceForm() {
        sendKeys(birthdayInput, user.getProperty("birthday"));
        click(provinceDropdown);
        click(provinceDropdown);
        click(provinceOption);
        sendKeys(phoneCodeInput, user.getProperty("phone_code"));
        sendKeys(phoneNumberInput, user.getProperty("phone_number"));
        click(phoneCodeInput);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertEquals("Provincia", getText(provinceFirstOption));
        Assertions.assertTrue(isEmpty(birthdayInput));
        Assertions.assertTrue(isEmpty(phoneCodeInput));
        Assertions.assertTrue(isEmpty(phoneNumberInput));

    }

    public void validatePrices() {
        wait.until(ExpectedConditions.textToBe(totalInsuranceValue, insurance.getProperty("total_insurance_value")));
        Assertions.assertEquals(insurance.getProperty("monthly_price_value"), getText(monthlyPriceValue));
        Assertions.assertEquals(insurance.getProperty("disability_value"), getText(disabilityValue));
        Assertions.assertEquals(insurance.getProperty("accident_value"), getText(accidentValue));
        Assertions.assertEquals(insurance.getProperty("illness_value"), getText(illnessValue));
        Assertions.assertEquals(insurance.getProperty("coverage_box_value"), getText(coverageBoxValue));
        Assertions.assertEquals(insurance.getProperty("accident_box_value"), getText(accidentBoxValue));
        Assertions.assertEquals(insurance.getProperty("disability_box_value"), getText(disabilityBoxValue));
        Assertions.assertEquals(insurance.getProperty("illness_box_value"), getText(illnessBoxValue));
    }

    public void validateFinalMessage() {
        Assertions.assertTrue(isPresent(alertMessage));
    }


}
