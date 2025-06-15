package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private final BrowserType browserType = BrowserType.valueOf(
            System.getProperty("browser", "CHROME").toUpperCase()
    );

    @Before
    public void setUp() {
        switch (browserType) {
            case CHROME:
                setupChrome();
                break;
            case YANDEX:
                setupYandex();
                break;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    private void setupChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void setupYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // используется yandexdriver-25.4.0.1973-win64
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\artem\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); // путь к исполняемому файлу yandex browser на локальной машине
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private enum BrowserType {
        CHROME, YANDEX
    }
}