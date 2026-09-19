package org.general.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentFramePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы для элементов внутри iframe
    private final By paymentInfoSum = By.xpath("//div[contains(@class, 'payment-page__title')]//span[contains(text(), 'BYN')] | //span[contains(text(), 'BYN')]");
    private final By payButton = By.xpath("//html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button/span");
    private final By paymentInfoPhone = By.xpath("//span[contains(text(), 'Оплата:') or contains(text(), 'Номер:')]");
    private final By cardNumberLabel = By.xpath("//span[text()='Номер карты'] | //label[text()='Номер карты']");
    private final By cardExpiryLabel = By.xpath("//span[text()='Срок действия'] | //label[text()='Срок действия']");
    private final By cardCvcLabel = By.xpath("//span[text()='CVC'] | //label[text()='CVC']");
    private final By paymentIcons = By.xpath("//app-card-input//img | //div[contains(@class, 'card-images')]//img");

    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
    }

    public String getPaymentSumText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoSum)).getText().trim(); }
    public String getPayButtonText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim(); }
    public String getPaymentPhoneText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoPhone)).getText().trim(); }
    public String getCardNumberLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)).getText().trim(); }
    public String getCardExpiryLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabel)).getText().trim(); }
    public String getCardCvcLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcLabel)).getText().trim(); }
    
    public boolean arePaymentIconsPresent() {
        try { return !wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentIcons)).isEmpty(); } 
        catch (Exception e) { return false; }
    }
}