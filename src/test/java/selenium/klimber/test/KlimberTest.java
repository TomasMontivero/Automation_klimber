package selenium.klimber.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.klimber.pages.IndexPage;

import java.util.logging.Logger;

public class KlimberTest {

    WebDriver driver;
    IndexPage indexPage;

    Logger logger = Logger.getLogger("KlimberTest");

    @Test
    public void calculateLifeInsurance() {
        logger.info("Index: Fill insurance form");
        indexPage.navigateToIndexPage();
        indexPage.fillInInsuranceForm();
        indexPage.validatePrices();
    }

    @BeforeEach
    public void setupEach() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
    }

    @AfterEach
    public void finishEach() {
        driver.quit();
    }

}
