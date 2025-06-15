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

public class PersonalAccountTest extends BaseTest {
    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        super.setUp();
        user = User.getRandomUser();
        userClient = new UserClient();
        userClient.createUser(user);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void navigateToPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        assertTrue(personalAccountPage.isPageLoaded());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logoutFromAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogoutButton();

        assertTrue(new LoginPage(driver).isPageLoaded());
    }

    @Test
    @DisplayName("Переход в конструктор через ссылку")
    public void navigateToConstructorViaLink() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorLink();

        assertTrue(mainPage.isPageLoaded());
    }

    @Test
    @DisplayName("Переход в конструктор через логотип")
    public void navigateToConstructorViaLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountLink();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();

        assertTrue(mainPage.isPageLoaded());
    }

    @After
    public void tearDown() {
        userClient.deleteUser(user);
        super.tearDown();
    }
}