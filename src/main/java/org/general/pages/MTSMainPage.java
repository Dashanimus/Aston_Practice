package org.general.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MTSMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Cookie баннер - кнопка "Отклонить"
    private final By cookieDeclineBtn = By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]"); 

    // Блок "Онлайн пополнение без комиссии"
    private final By paymentBlockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By labelVISA = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private final By labelVerifVISA = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    private final By labelMasterCard = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private final By labelMasterCardSecure = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    private final By labelBelkart = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private final By detailsLink = By.xpath("//a[text()='Подробнее о сервисе']");

    // Форма "Услуги связи"
    private final By connectionServicesTab = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By phoneInputField = By.xpath("//*[@id=\"connection-phone\"]");
    private final By sumInputField = By.xpath("//*[@id=\"connection-sum\"]");
    private final By emailInputField = By.xpath("//*[@id=\"connection-email\"]");
    private final By submitButton = By.xpath("//*[@id=\"pay-connection\"]/button");

    public MTSMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public MTSMainPage handleCookieBanner() {
        try {
            WebElement declineBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieDeclineBtn));
            declineBtn.click();
        } catch (Exception e) {
            System.out.println("Баннер Cookie не появился или уже был закрыт.");
        }
        return this;
    }

    public String getPaymentBlockTitleText() {
        return driver.findElement(paymentBlockTitle).getText().trim();
    }

    public boolean areAllPaymentLabelsDisplayed() {
        List<By> labels = List.of(labelVISA, labelVerifVISA, labelMasterCard, labelMasterCardSecure, labelBelkart);
        
        try {
            return labels.stream().allMatch(label -> driver.findElement(label).isDisplayed());
        } catch (Exception e) {
            return false; 
        }
    }

    public void clickDetailsLink() {
        driver.findElement(detailsLink).click();
    }

    public void selectConnectionServicesTab() {
        driver.findElement(connectionServicesTab).click();
    }

    public void fillPaymentForm(String phone, String sum, String email) {
        WebElement phoneInput = driver.findElement(phoneInputField);
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement sumInput = driver.findElement(sumInputField);
        sumInput.clear();
        sumInput.sendKeys(sum);

        WebElement emailInput = driver.findElement(emailInputField);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        driver.findElement(submitButton).click();
    }
}