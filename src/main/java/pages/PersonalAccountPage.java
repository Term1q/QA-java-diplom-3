package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalAccountPage extends BasePage {
    @FindBy(linkText = "Профиль")
    private WebElement profileLink;

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    @FindBy(linkText = "Конструктор")
    private WebElement constructorLink;

    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private WebElement logo;

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выход из аккаунта")
    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Step("Переход в конструктор")
    public void clickConstructorLink() {
        constructorLink.click();
    }

    @Step("Нажатие на логотип")
    public void clickLogo() {
        logo.click();
    }

    public boolean isPageLoaded() {
        return profileLink.isDisplayed();
    }
}