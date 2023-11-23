package selenium.klimber.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.klimber.pages.IndexPage;
import selenium.klimber.pages.StepFourPage;
import selenium.klimber.pages.StepThreePage;
import selenium.klimber.pages.StepTwoPage;

import java.util.logging.Logger;

public class KlimberTest {

    WebDriver driver;
    IndexPage indexPage;
    StepTwoPage stepTwoPage;
    StepThreePage stepThreePage;
    StepFourPage stepFourPage;

    Logger logger = Logger.getLogger("KlimberTest");

    @Test
    public void completeInsuranceForm() {
        logger.info("Index: Insurance form");
        indexPage.navigateToIndexPage();
        indexPage.validateInitialValues();
        indexPage.fillInInsuranceForm();
        indexPage.validatePrices();
        indexPage.submitForm();
        logger.info("Step 2: Health form");
        stepTwoPage.validateInitialValues();
        stepTwoPage.fillInHealthForm();
        stepTwoPage.submitForm();
        logger.info("Step 3: Register form");
        stepThreePage.validateInitialValues();
        stepThreePage.fillInRegisterForm();
        stepThreePage.submitForm();
        logger.info("Step 4: Additional info");
        stepFourPage.validateInitialValues();
        stepFourPage.fillInAdditionalInfoForm();
        stepFourPage.submitForm();
    }

    @BeforeEach
    public void setupEach() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        stepTwoPage = new StepTwoPage(driver);
        stepThreePage = new StepThreePage(driver);
        stepFourPage = new StepFourPage(driver);
    }

    @AfterEach
    public void finishEach() {
        driver.quit();
    }

}
