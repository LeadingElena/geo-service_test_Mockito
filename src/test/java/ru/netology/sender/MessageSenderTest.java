package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

class MessageSenderImplTest {
    private LocalizationService localizationService;
    @Test
    void test_send_russian_message() {

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location(null, Country.RUSSIA, null, 0));
        Location location = geoService.byIp("172.0.32.11");
        String preference = localizationService.locale(location.getCountry());
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, preference);

    }
    @Test
    void test_send_english_message() {

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location(null, Country.USA, null, 0));
        Location location = geoService.byIp("96.44.183.149");
        String preference = localizationService.locale(location.getCountry());
        String expected = "Welcome";
        Assertions.assertEquals(expected, preference);

    }


}