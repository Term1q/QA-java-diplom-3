package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void navigateToBunsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectBunsTab();
        assertEquals("Булки", mainPage.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void navigateToSaucesSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectSaucesTab();
        assertEquals("Соусы", mainPage.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void navigateToFillingsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFillingsTab();
        assertEquals("Начинки", mainPage.getActiveTabText());
    }
}