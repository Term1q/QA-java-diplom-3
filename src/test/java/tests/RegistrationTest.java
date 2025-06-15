package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.BaseTest;
import utils.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistration() {
        User user = User.getRandomUser();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        assertTrue(new LoginPage(driver).isPageLoaded());
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    public void registrationWithShortPassword() {
        User user = User.getRandomUser();
        user.setPassword("12345");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        assertEquals("Некорректный пароль", registerPage.getErrorMessage());
    }
}