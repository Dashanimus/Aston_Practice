package tests;

import base.BaseTest;
import org.general.pages.MTSMainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        mainPage.selectConnectionServicesTab();

        assertEquals("Номер телефона", mainPage.getPhonePlaceholder(), "Неверный placeholder телефона");
        assertEquals("Сумма", mainPage.getSumPlaceholder(), "Неверный placeholder суммы");
        assertEquals("E-mail для отправки чека", mainPage.getEmailPlaceholder(), "Неверный placeholder Email");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Домашний интернет'")
    public void homeInternetTest() {
        mainPage.selectHomeInternetTab();

        assertEquals("Номер абонента", mainPage.getInternetPhonePlaceholder(), "Неверный placeholder номера абонента");
        assertEquals("Сумма", mainPage.getInternetSumPlaceholder(), "Неверный placeholder суммы");
        assertEquals("E-mail для отправки чека", mainPage.getInternetEmailPlaceholder(), "Неверный placeholder Email");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Рассрочка'")
    public void installmentTest() {
        mainPage.selectInstallmentTab();

        assertEquals("Номер счета на 44", mainPage.getInstallmentScorePlaceholder(), "Неверный placeholder счета");
        assertEquals("Сумма", mainPage.getInstallmentSumPlaceholder(), "Неверный placeholder суммы");
        assertEquals("E-mail для отправки чека", mainPage.getInstallmentEmailPlaceholder(), "Неверный placeholder Email");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров 'Задолженность'")
    public void debtTest() {
        mainPage.selectDebtTab();

        assertEquals("Номер счета на 2073", mainPage.getArrearsScorePlaceholder(), "Неверный placeholder счета задолженности");
        assertEquals("Сумма", mainPage.getArrearsSumPlaceholder(), "Неверный placeholder суммы");
        assertEquals("E-mail для отправки чека", mainPage.getArrearsEmailPlaceholder(), "Неверный placeholder Email");
    }
}