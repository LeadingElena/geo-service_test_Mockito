package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
class LocalizationServiceImplTest {
    @ParameterizedTest
    @CsvSource(value = {
            "RUSSIA, Добро пожаловать, true",
            "USA, Welcome, true",
            "USA,  Добро пожаловать, false",
            "RUSSIA, Welcome, false"
    })
    public void test_Location_byIp (Country country, String expectedMessage, boolean expectedValue) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String comparedValue = localizationService.locale(country);
        boolean result = expectedMessage.equals(comparedValue);
        Assertions.assertEquals(expectedValue, result);
    }

}