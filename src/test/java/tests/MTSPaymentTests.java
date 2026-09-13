package tests;

import base.BaseTest;
import org.general.pages.MTSMainPage;
import org.general.utils.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

    @Test
    @DisplayName("Проверка заполненных данных")
    public void testCommunicationServicesFullPaymentFlow() {

        WebElement phoneNumberField = mainPage.waitForVisibilityLocatedBy(By.id("connection-phone"));
        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.id("connection-sum"));
        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.id("connection-email"));

        String testPhone = "297777777";
        String testSum = "90.00";
        String testEmail = "lesson10@example.com";

        phoneNumberField.sendKeys(testPhone);
        sumField.sendKeys(testSum);
        emailField.sendKeys(testEmail);

        WebElement continueButton = mainPage.waitForElementClickable(By.xpath("//form[@id='pay-connection']//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        WebElement paymentInfoSum = mainPage.waitForVisibilityLocatedBy(By.xpath("//div[contains(@class, 'payment-info__sum') or contains(text(), 'BYN')]"));
        Assertions.assertTrue(paymentInfoSum.getText().contains(testSum), "Сумма в инфо-блоке платежного окна отображается некорректно");

        WebElement payButton = mainPage.waitForVisibilityLocatedBy(By.xpath("//button[contains(@class, 'pay-btn') or @type='submit']"));
        Assertions.assertTrue(payButton.getText().contains(testSum), "Сумма на кнопке оплаты не совпадает с введенной");


        WebElement paymentInfoPhone = mainPage.waitForVisibilityLocatedBy(By.xpath("//div[contains(@class, 'payment-info__phone') or contains(text(), '297777777')]"));
        Assertions.assertTrue(paymentInfoPhone.getText().contains(testPhone), "Номер телефона в инфо-блоке отображается некорректно");

        WebElement cardNumberField = mainPage.waitForVisibilityLocatedBy(By.id("card-number"));
        Assertions.assertEquals("Номер карты", cardNumberField.getAttribute("placeholder"), "Неверная надпись в поле номера карты");

        WebElement cardExpiryField = mainPage.waitForVisibilityLocatedBy(By.id("card-expiry"));
        Assertions.assertEquals("Срок действия", cardExpiryField.getAttribute("placeholder"), "Неверная надпись в поле срока действия");

        WebElement cardCvcField = mainPage.waitForVisibilityLocatedBy(By.id("card-cvc"));
        Assertions.assertEquals("CVC", cardCvcField.getAttribute("placeholder"), "Неверная надпись в поле CVC");
        
        List<WebElement> paymentIcons = driver.findElements(By.xpath("//div[contains(@class, 'payment-systems')]//img"));
        Assertions.assertFalse(paymentIcons.isEmpty(), "Иконки платёжных систем (Visa/Mastercard/Белкарт) отсутствуют в окне оплаты");
    }
}