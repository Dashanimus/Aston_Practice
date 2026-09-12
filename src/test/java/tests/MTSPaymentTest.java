package tests;

import base.BaseTest;
import org.general.pages.MTSMainPage;
import org.general.utils.ConfigReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MTSPaymentTest extends BaseTest {
        private MTSMainPage mainPage;
    @BeforeEach
    public void initPage() {
        mainPage = new MTSMainPage(driver);
        mainPage.handleCookieBanner();
    }

    @Test
    @DisplayName("Проверка названия блока онлайн пополнения")
    public void testPaymentBlockTitle() {
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\n" + "БЕЗ КОМИССИИ";
        String actualTitle = mainPage.getPaymentBlockTitleText();
        
        assertEquals(expectedTitle, actualTitle, "Название блока не совпадает!");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemsIconsAreVisible() {
        assertTrue(mainPage.areAllPaymentLabelsDisplayed(), 
        "Не все иконки платежных систем (VISA, MasterCard, Белкарт) отображаются на главной странице!");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testDetailsLink() {
        mainPage.clickDetailsLink();
        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("help") || currentUrl.contains("pay"), 
                "Ссылка 'Подробнее о сервисе' ведет на неверный URL: " + currentUrl);
    }

    @Test
    @DisplayName("Заполнение полей формы 'Услуги связи' и отправка")
    public void testFillFormAndSubmit() {
        String phone = ConfigReader.getProperty("phoneNumber");
        String sum = ConfigReader.getProperty("sum");
        String email = ConfigReader.getProperty("email");

        mainPage.selectConnectionServicesTab();
        mainPage.fillPaymentForm(phone, sum, email);
        mainPage.clickContinueButton();
        
        assertNotEquals(ConfigReader.getProperty("url"), driver.getCurrentUrl(), 
                "Переход на страницу оплаты не состоялся.");
    }
}