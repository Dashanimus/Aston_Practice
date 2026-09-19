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

    // Cookie баннер
    private final By cookieDeclineBtn = By.xpath("//button[text()='Отклонить'] | //button[contains(@class, 'cookie__btn_secondary')]");

    // Блок "Онлайн пополнение без комиссии"
    private final By paymentBlockTitle = By.xpath("//div[contains(@class, 'pay__wrapper')]//h2");
    private final By labelVISA = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private final By labelVerifVISA = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    private final By labelMasterCard = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private final By labelMasterCardSecure = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    private final By labelBelkart = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img]");
   
    private final By detailsLink = By.xpath("//a[text()='Подробнее о сервисе']");

    // Селектор (выпадающий список) выбора услуг
    private final By servicesDropdownTrigger = By.xpath("//div[contains(@class, 'select__header')] | //button[contains(@class, 'select__header')]");
    
    // Элементы выпадающего списка
    private final By optionConnectionServices = By.xpath("//p[text()='Услуги связи']/..");
    private final By optionHomeInternet = By.xpath("//p[text()='Домашний интернет']/..");
    private final By optionInstallment = By.xpath("//p[text()='Рассрочка']/..");
    private final By optionDebt = By.xpath("//p[text()='Задолженность']/..");

    // Поля формы "Услуги связи"
    private final By phoneInputField = By.id("connection-phone");
    private final By sumInputField = By.id("connection-sum");
    private final By emailInputField = By.id("connection-email");
    private final By submitButton = By.xpath("//*[@id=\"pay-connection\"]/button");

    // Поля формы "Домашний интернет"
    private final By internetPhoneField = By.id("internet-phone");
    private final By internetSumField = By.id("internet-sum");
    private final By internetEmailField = By.id("internet-email");

    // Поля формы "Рассрочка"
    private final By installmentScoreField = By.id("score-instalment");
    private final By installmentSumField = By.id("instalment-sum");
    private final By installmentEmailField = By.id("instalment-email");

    // Поля формы "Задолженность"
    private final By arrearsScoreField = By.id("score-arrears");
    private final By arrearsSumField = By.id("arrears-sum");
    private final By arrearsEmailField = By.id("arrears-email");

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

    private void selectDropdownOption(By optionLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(servicesDropdownTrigger)).click();
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public void selectConnectionServicesTab() { selectDropdownOption(optionConnectionServices); }
    public void selectHomeInternetTab() { selectDropdownOption(optionHomeInternet); }
    public void selectInstallmentTab() { selectDropdownOption(optionInstallment); }
    public void selectDebtTab() { selectDropdownOption(optionDebt); }

    public void fillPaymentForm(String phone, String sum, String email) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInputField));
        phoneInput.clear(); phoneInput.sendKeys(phone);
        WebElement sumInput = driver.findElement(sumInputField);
        sumInput.clear(); sumInput.sendKeys(sum);
        WebElement emailInput = driver.findElement(emailInputField);
        emailInput.clear(); emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getPaymentBlockTitleText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentBlockTitle)).getText().trim(); }
    public void clickDetailsLink() { wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click(); }
    
    public boolean areAllPaymentLabelsDisplayed() {
        List<By> labels = List.of(labelVISA);
        try { return labels.stream().allMatch(label -> driver.findElement(label).isDisplayed()); } catch (Exception e) { return false; }
    }

    public String getPhonePlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInputField)).getAttribute("placeholder"); }
    public String getSumPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(sumInputField)).getAttribute("placeholder"); }
    public String getEmailPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField)).getAttribute("placeholder"); }

    public String getInternetPhonePlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(internetPhoneField)).getAttribute("placeholder"); }
    public String getInternetSumPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(internetSumField)).getAttribute("placeholder"); }
    public String getInternetEmailPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(internetEmailField)).getAttribute("placeholder"); }

    public String getInstallmentScorePlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentScoreField)).getAttribute("placeholder"); }
    public String getInstallmentSumPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentSumField)).getAttribute("placeholder"); }
    public String getInstallmentEmailPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentEmailField)).getAttribute("placeholder"); }

    public String getArrearsScorePlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsScoreField)).getAttribute("placeholder"); }
    public String getArrearsSumPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsSumField)).getAttribute("placeholder"); }
    public String getArrearsEmailPlaceholder() { return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsEmailField)).getAttribute("placeholder"); }
}