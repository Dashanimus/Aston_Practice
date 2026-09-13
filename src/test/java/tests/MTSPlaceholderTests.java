package tests;

import base.BaseTest;

import org.general.pages.MTSMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MTSPlaceholderTests extends BaseTest {
    private MTSMainPage mainPage;

    @BeforeEach
    public void initPage() {
        mainPage = new MTSMainPage(driver);
        mainPage.handleCookieBanner();
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Услуги связи'")
    public void communicationServicesTest() {
        WebElement communicationService = mainPage.waitForElementClickable(By.xpath("//ul[@class='select__list']//li[1]"));
        communicationService.click();

        WebElement phoneNumberField = mainPage.waitForVisibilityLocatedBy(By.id("connection-phone"));
        String actualPhoneText = phoneNumberField.getAttribute("placeholder");
        
        Assertions.assertEquals("Номер телефона", actualPhoneText, "Текст поля \"Номер телефона\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.id("connection-sum"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.id("connection-email"));
        String actualEmailText = emailField.getAttribute("placeholder");
        
        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Домашний интернет'")
    public void homeInternetTest() {
    WebElement homeInternet = mainPage.waitForElementClickable(By.xpath("//ul[@class='select__list']//li[2]"));
    homeInternet.click();

    WebElement subscriberNumberField = mainPage.waitForVisibilityLocatedBy(By.id("internet-phone"));
    String actualSubscriberText = subscriberNumberField.getAttribute("placeholder");

    Assertions.assertEquals("Номер абонента", actualSubscriberText, "Текст поля \"Номер абонента\" не совпадает");

    WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='internet-sum']"));
    String actualSumText = sumField.getAttribute("placeholder");

    Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

    WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='internet-email']"));
    String actualEmailText = emailField.getAttribute("placeholder");

    Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Рассрочка'")
    public void installmentTest() {
        WebElement installment = mainPage.waitForElementClickable(By.xpath("//p[text() = 'Рассрочка']"));
        installment.click();

        WebElement accountNumberField = mainPage.waitForVisibilityLocatedBy(By.id("score-instalment"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");
        
        Assertions.assertEquals("Номер счета на 44", actualAccountText, "Текст поля \"Номер счета на 44\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='instalment-sum']"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='instalment-email']"));
        String actualEmailText = emailField.getAttribute("placeholder");

        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Задолженность'")
    public void debtTest() {
        WebElement debt = mainPage.waitForElementClickable(By.xpath("//p[text() = 'Задолженность']"));
        debt.click();

        WebElement accountNumberField = mainPage.waitForVisibilityLocatedBy(By.id("score-arrears"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");

        Assertions.assertEquals("Номер счета на 2073", actualAccountText, "Текст поля \"Номер счета на 2073\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='arrears-sum']"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//input[@id='arrears-email']"));
        String actualEmailText = emailField.getAttribute("placeholder");

        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }
}