package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepThreePage extends BasePage{
    public StepThreePage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    By name = By.id("Name");
    By surname = By.id("Surname");
    By birthday = By.id("Birthday");
    By id = By.id("ID_Number");
    By sexDropdown = By.id("select2-Gender-container");
    By sexOption = By.xpath("//*[contains(@id,\"Gender\")]//option[text()='Masculino']");
    By genderDropdown = By.id("select2-IdentificationGenderType-container");
    By genderOption = By.xpath("//*[contains(@id,\"IdentificationGenderType\")]//option[text()='Masculino']");
    By civilStatusDropdown = By.id("select2-CivilStatus-container");
    By civilStatusOption = By.xpath("//*[contains(@id,\"CivilStatus\")]//option[text()='Soltera/o']");
    By email = By.id("txtEmail");
    By passowrd = By.id("Password");
    By phoneCode = By.id("PhoneCode");
    By phoneNumber = By.id("PhoneNumber");
    By addressStreet = By.id("Street");
    By addressNumber = By.id("HouseNumber");
    By addressFloor = By.id("Floor");
    By addressApartment = By.id("Apartment");
    By addressZipCode = By.id("zipCode");
    By addressCityDropdown = By.id("select2-city-container");
    By addressCityOption = By.xpath("//*[contains(@id,\"city\")]//option[text()='C.A.B.A']");
    By addressProvinceOption = By.id("select2-province-container");
    By addressCountryOption = By.id("select2-country-container");
    By submitButton = By.id("btnRegister");

    /*
     * Methods
     */

    public void fillInRegisterForm() {
        sendKeys(name, user.getProperty("name"));
        sendKeys(surname, user.getProperty("surname"));
        sendKeys(id, user.getProperty("id"));
        click(sexDropdown);
        click(sexOption);
        click(genderDropdown);
        click(genderOption);
        click(civilStatusDropdown);
        click(civilStatusOption);
        sendKeys(email, user.getProperty("email"));
        sendKeys(passowrd, user.getProperty("password"));
        sendKeys(addressStreet, user.getProperty("address_street"));
        sendKeys(addressNumber, user.getProperty("address_number"));
        sendKeys(addressZipCode, user.getProperty("address_zipcode"));
        click(addressCityDropdown);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertEquals(user.getProperty("birthday"), getValue(birthday));
        Assertions.assertEquals(user.getProperty("phone_code"), getValue(phoneCode));
        Assertions.assertEquals(user.getProperty("phone_number"), getValue(phoneNumber));
        Assertions.assertEquals(user.getProperty("province"), getText(addressProvinceOption));
        Assertions.assertEquals(user.getProperty("country"), getText(addressCountryOption));
    }

}
