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

    public void validatePrices() {
        wait.until(ExpectedConditions.textToBe(totalInsuranceValue, "$ 230.000"));
        Assertions.assertEquals("$ 44", getText(monthlyPriceValue));
        Assertions.assertEquals("$ 230.000", getText(disabilityValue));
        Assertions.assertEquals("$ 460.000", getText(accidentValue));
        Assertions.assertEquals("$ 57.500", getText(illnessValue));
        Assertions.assertEquals("$ 230.000", getText(coverageBoxValue));
        Assertions.assertEquals("$ 460.000", getText(accidentBoxValue));
        Assertions.assertEquals("$ 230.000", getText(disabilityBoxValue));
        Assertions.assertEquals("$ 57.500", getText(illnessBoxValue));
    }



}
