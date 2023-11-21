package selenium.klimber.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KlimberTest {

    WebDriver driver;

    @Test
    public void sampleTest() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(true);
    }

    @Test
    public void sampleTestFail() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(false);
    }

    @BeforeEach
    public void setupEach() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void finishEach() {
        driver.quit();
    }

}
