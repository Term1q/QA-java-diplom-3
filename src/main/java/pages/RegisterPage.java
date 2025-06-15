package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(xpath = ".//label[text()='Имя']/following-sibling::input")
    private WebElement nameInput;
    @FindBy(xpath = ".//label[text()='Email']/following-sibling::input")
    private WebElement emailInput;
    @FindBy(xpath = ".//label[text()='Пароль']/following-sibling::input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(linkText = "Войти")
    private WebElement loginLink;

    @FindBy(className = "input__error")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        registerButton.click();
    }

    @Step("Переход к авторизации")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Получение ошибки")
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}