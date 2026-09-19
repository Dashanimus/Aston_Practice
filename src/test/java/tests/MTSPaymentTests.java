package tests;

import base.BaseTest;
import org.general.pages.MTSMainPage;
import org.general.pages.PaymentFramePage;
import org.general.utils.ConfigReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MTSPaymentTests extends BaseTest {
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
        assertEquals(expectedTitle, mainPage.getPaymentBlockTitleText(), "Название блока не совпадает!");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemsIconsAreVisible() {
        assertTrue(mainPage.areAllPaymentLabelsDisplayed(), "Не все иконки платёжных систем отображаются!");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testDetailsLink() {
        mainPage.clickDetailsLink();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("help") || currentUrl.contains("pay"), "Неверный URL после клика на ссылку");
    }

    @Test
    @DisplayName("Заполнение полей формы 'Услуги связи' и отправка")
    public void testFillFormAndSubmit() {
        mainPage.selectConnectionServicesTab();
        mainPage.fillPaymentForm(ConfigReader.getProperty("phoneNumber"), ConfigReader.getProperty("sum"), ConfigReader.getProperty("email"));
        mainPage.clickContinueButton();
        
        assertNotEquals(ConfigReader.getProperty("url"), driver.getCurrentUrl(), "Переход на страницу оплаты не состоялся.");
    }

    @Test
    @DisplayName("Проверка заполненных данных в окне оплаты")
    public void testCommunicationServicesFullPaymentFlow() {
        String testPhone = "297777777";
        String testSum = "90";
        String testEmail = "test@example.com";

        mainPage.selectConnectionServicesTab();
        mainPage.fillPaymentForm(testPhone, testSum, testEmail);
        mainPage.clickContinueButton();

        PaymentFramePage framePage = new PaymentFramePage(driver);
        framePage.switchToPaymentFrame();

        assertTrue(framePage.getPaymentSumText().contains(testSum + ".00 BYN"), "Сумма в инфо-блоке не совпадает");
        assertTrue(framePage.getPayButtonText().contains("Оплатить " + testSum + ".00 BYN"), "Сумма на кнопке оплаты не совпадает");
        assertTrue(framePage.getPaymentPhoneText().contains("Номер:375" + testPhone), "Номер телефона отображается некорректно");
        assertTrue(framePage.getCardNumberLabelText().contains("Номер карты"), "Неверная надпись поля номера карты");
        assertTrue(framePage.getCardExpiryLabelText().contains("Срок действия"), "Неверная надпись поля срока действия");
        assertTrue(framePage.getCardCvcLabelText().contains("CVC"), "Неверная надпись поля CVC");
        assertTrue(framePage.arePaymentIconsPresent(), "Иконки платёжных систем отсутствуют");
    }
}