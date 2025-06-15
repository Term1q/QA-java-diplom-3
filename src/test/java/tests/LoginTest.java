package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import utils.BaseTest;
import utils.User;
import utils.UserClient;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        super.setUp();
        user = User.getRandomUser();
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @Test
    @DisplayName("Вход через кнопку на главной")
    public void loginViaMainPageButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через личный кабинет")
    public void loginViaPersonalAccountLink() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    public void loginViaRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через восстановление пароля")
    public void loginViaPasswordRecovery() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isPageLoaded());
    }

    @After
    public void tearDown() {
        userClient.deleteUser(user);
        super.tearDown();
    }
}