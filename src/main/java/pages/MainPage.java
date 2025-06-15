package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    @FindBy(xpath = ".//button[contains(@class,'button_button__33qZ0')]")
    private WebElement loginButton;

    @FindBy(xpath = ".//p[contains(@class,'AppHeader_header__linkText')and text()='Личный Кабинет']")
    private WebElement personalAccountLink;

    @FindBy(xpath = "//span[text()='Булки']/parent::div")
    private WebElement bunsTab;

    @FindBy(xpath = "//span[text()='Соусы']/parent::div")
    private WebElement saucesTab;

    @FindBy(xpath = "//span[text()='Начинки']/parent::div")
    private WebElement fillingsTab;

    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private WebElement activeTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие кнопки входа")
    public void clickLoginButton() {
        loginButton.click();
    }


    @Step("Переход в личный кабинет")
    public void clickPersonalAccountLink() {
                personalAccountLink.click();
    }

    @Step("Выбор раздела 'Булки'")
    public void selectBunsTab() {
        saucesTab.click(); // изначально кнопка булки не кликабельна
        bunsTab.click();
    }

    @Step("Выбор раздела 'Соусы'")
    public void selectSaucesTab() {
        saucesTab.click();
    }

    @Step("Выбор раздела 'Начинки'")
    public void selectFillingsTab() {
        fillingsTab.click();
    }

    @Step("Получение активного раздела")
    public String getActiveTabText() {
        return activeTab.getText();
    }

    public boolean isPageLoaded() {
        return loginButton.isDisplayed();
    }
}