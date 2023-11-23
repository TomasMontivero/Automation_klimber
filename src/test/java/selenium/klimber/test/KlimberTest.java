package selenium.klimber.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.klimber.pages.*;

import java.util.logging.Logger;

public class KlimberTest {

    WebDriver driver;
    IndexPage indexPage;
    HealthPage healthPage;
    RegistrationPage registrationPage;
    AdditionalInfoPage additionalInfoPage;
    PaymentPage paymentPage;
    BeneficiaryPage beneficiaryPage;
    SummaryPage summaryPage;

    Logger logger = Logger.getLogger("KlimberTest");

    @Test
    @Tag("smoke")
    public void completeInsuranceForm() {
        logger.info("Index: Insurance form");
        indexPage.navigateToIndexPage();
        indexPage.validateInitialValues();
        indexPage.fillInInsuranceForm();
        indexPage.validatePrices();
        indexPage.submitForm();
        logger.info("Step 2: Health form");
        healthPage.validateInitialValues();
        healthPage.fillInHealthForm();
        healthPage.submitForm();
        logger.info("Step 3: Register form");
        registrationPage.validateInitialValues();
        registrationPage.fillInRegisterForm();
        registrationPage.submitForm();
        logger.info("Step 4: Additional info");
        additionalInfoPage.validateInitialValues();
        additionalInfoPage.fillInAdditionalInfoForm();
        additionalInfoPage.submitForm();
        logger.info("Step 5: Payment");
        paymentPage.validateInitialValues();
        paymentPage.fillInPaymentForm();
        paymentPage.submitForm();
        logger.info("Step 6: Beneficiary");
        beneficiaryPage.addBeneficiary();
        beneficiaryPage.validateInitialValues();
        beneficiaryPage.fillInBeneficiaryForm();
        beneficiaryPage.submitForm();
        logger.info("Summary");
        summaryPage.validateInitialValues();
        summaryPage.submitForm();
        logger.info("Index: Final message");
        indexPage.validateFinalMessage();
    }

    @BeforeEach
    public void setupEach() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        healthPage = new HealthPage(driver);
        registrationPage = new RegistrationPage(driver);
        additionalInfoPage = new AdditionalInfoPage(driver);
        paymentPage = new PaymentPage(driver);
        beneficiaryPage = new BeneficiaryPage(driver);
        summaryPage = new SummaryPage(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void finishEach() {
        driver.quit();
    }

}
