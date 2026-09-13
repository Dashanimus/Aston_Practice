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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.time.Duration;

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

        WebElement phoneNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-phone\"]"));
        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-sum\"]"));
        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-email\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String testPhone = "297777777";
        String testSum = "90";
        String testEmail = "test@example.com";

        phoneNumberField.sendKeys(testPhone);
        sumField.sendKeys(testSum);
        emailField.sendKeys(testEmail);

        WebElement continueButton = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        WebElement paymentInfoSum = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span"));
        Assertions.assertTrue(paymentInfoSum.getText().contains(testSum + ".00 BYN"), "Сумма в инфо-блоке платежного окна отображается некорректно");

        WebElement payButton = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        Assertions.assertTrue(payButton.getText().contains("Оплатить " + testSum + ".00 BYN"), "Сумма на кнопке оплаты не совпадает с введенной");


        WebElement paymentInfoPhone = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        Assertions.assertTrue(paymentInfoPhone.getText().contains("Оплата: Услуги связи Номер:375" + testPhone), "Номер телефона в инфо-блоке отображается некорректно");
       
        WebElement cardNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div"));
        Assertions.assertTrue(cardNumberField.getText().contains("Номер карты"), "Неверная надпись в поле номера карты");

        WebElement cardExpiryField = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]"));
        Assertions.assertTrue(cardExpiryField.getText().contains("Срок действия"), "Неверная надпись в поле срока действия");

        WebElement cardCvcField = mainPage.waitForVisibilityLocatedBy(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]"));
        Assertions.assertTrue(cardCvcField.getText().contains("CVC"), "Неверная надпись в поле CVC");
        
        List<WebElement> paymentIcons = driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]"));
        Assertions.assertFalse(paymentIcons.isEmpty(), "Иконки платёжных систем (Visa/Mastercard/Белкарт) отсутствуют в окне оплаты");
    }
}