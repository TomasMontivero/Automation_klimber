package selenium.klimber.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BeneficiaryPage extends BasePage{
    public BeneficiaryPage(WebDriver driver) {
        super(driver);
    }

    /*
     * Attributes
     */

    By addBeneficiaryPersonButton = By.id("btnAddBeneficiaryNatural");
    By name = By.name("Beneficiaries[0].Name");
    By surname = By.name("Beneficiaries[0].Surname");
    By id = By.name("Beneficiaries[0].IdNumber");
    By relationshipDropdown = By.id("select2-Beneficiaries0PersonRelationshipType-container");
    By relationshipOption = By.xpath("//*[contains(@id,\"Beneficiaries[0].PersonRelationshipType\")]//option[text()='Cónyuge']");
    By relationshipFirstOption = By.xpath("//*[contains(@id,\"Beneficiaries[0].PersonRelationshipType\")]//option[1]");
    By birthDay = By.name("Beneficiaries[0].DateDay");
    By birthMonth = By.name("Beneficiaries[0].DateMonth");
    By birthYear = By.name("Beneficiaries[0].DateYear");
    By order = By.name("Beneficiaries[0].BeneficiaryOrder");
    By percentage = By.name("Beneficiaries[0].BeneficiaryPercentage");
    By submitButton = By.className("submitFinal");


    /*
     * Methods
     */

    public void addBeneficiary() {
        click(addBeneficiaryPersonButton);
    }

    public void fillInBeneficiaryForm() {
        sendKeys(name, user.getProperty("beneficiary_name"));
        sendKeys(surname, user.getProperty("beneficiary_surname"));
        sendKeys(id, user.getProperty("beneficiary_id"));
        click(relationshipDropdown);
        click(relationshipOption);
        sendKeys(birthDay, user.getProperty("beneficiary_birthday"));
        sendKeys(birthMonth, user.getProperty("beneficiary_birthmonth"));
        sendKeys(birthYear, user.getProperty("beneficiary_birthyear"));
        sendKeys(order, user.getProperty("beneficiary_order"));
        sendKeys(percentage, user.getProperty("beneficiary_percentage"));
    }

    public void submitForm() {
        click(submitButton);
    }

    public void validateInitialValues() {
        Assertions.assertTrue(isEmpty(name));
        Assertions.assertTrue(isEmpty(surname));
        Assertions.assertTrue(isEmpty(id));
        Assertions.assertEquals("Relación", getText(relationshipFirstOption));
        Assertions.assertTrue(isEmpty(birthDay));
        Assertions.assertTrue(isEmpty(birthMonth));
        Assertions.assertTrue(isEmpty(birthYear));
        Assertions.assertEquals("1", getValue(order));
        Assertions.assertTrue(isEmpty(percentage));
    }

}
