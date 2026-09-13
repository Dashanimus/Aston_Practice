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

        WebElement phoneNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-phone\"]"));
        String actualPhoneText = phoneNumberField.getAttribute("placeholder");
        
        Assertions.assertEquals("Номер телефона", actualPhoneText, "Текст поля \"Номер телефона\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-sum\"]"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"connection-email\"]"));
        String actualEmailText = emailField.getAttribute("placeholder");
        
        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Домашний интернет'")
    public void homeInternetTest() {

    WebElement selector = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
    selector.click();
    WebElement homeInternet = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
    homeInternet.click();

    WebElement subscriberNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"internet-phone\"]"));
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
        WebElement selector = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        selector.click();
        WebElement installment = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"));
        installment.click();

        WebElement accountNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"score-instalment\"]"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");
        
        Assertions.assertEquals("Номер счета на 44", actualAccountText, "Текст поля \"Номер счета на 44\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"instalment-sum\"]"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"instalment-email\"]"));
        String actualEmailText = emailField.getAttribute("placeholder");

        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Задолженность'")
    public void debtTest() {
        WebElement selector = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        selector.click();
        WebElement debt = mainPage.waitForElementClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
        debt.click();

        WebElement accountNumberField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"score-arrears\"]"));
        String actualAccountText = accountNumberField.getAttribute("placeholder");

        Assertions.assertEquals("Номер счета на 2073", actualAccountText, "Текст поля \"Номер счета на 2073\" не совпадает");

        WebElement sumField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"arrears-sum\"]"));
        String actualSumText = sumField.getAttribute("placeholder");

        Assertions.assertEquals("Сумма", actualSumText, "Текст поля \"Сумма\" не совпадает");

        WebElement emailField = mainPage.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"arrears-email\"]"));
        String actualEmailText = emailField.getAttribute("placeholder");

        Assertions.assertEquals("E-mail для отправки чека", actualEmailText, "Текст поля \"Email\" не совпадает");
    }
}