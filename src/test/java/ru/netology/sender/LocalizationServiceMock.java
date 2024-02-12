package ru.netology.sender;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceMock implements LocalizationService {
    String value;
    @Override
    public String locale(Country country) { return value; }

    public void setValue(String value) {
        this.value = value;
    }
}
