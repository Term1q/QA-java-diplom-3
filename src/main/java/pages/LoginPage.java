package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='name']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class, 'button_button')]")
    private WebElement loginButton;

    @FindBy(linkText = "Зарегистрироваться")
    private WebElement registerLink;

    @FindBy(linkText = "Восстановить пароль")
    private WebElement forgotPasswordLink;

    @FindBy(className = "input__error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вход с email: {email}")
    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Переход к регистрации")
    public void clickRegisterLink() {
        registerLink.click();
    }

    @Step("Переход к восстановлению пароля")
    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public boolean isPageLoaded() {
        return loginButton.isDisplayed();
    }
}