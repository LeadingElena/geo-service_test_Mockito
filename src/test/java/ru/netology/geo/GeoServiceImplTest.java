package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Location;

class GeoServiceImplTest {
    @ParameterizedTest
    @CsvSource(value = {
            "172.0.24.41, RUSSIA, true",
            "96.44.183.149, USA, true",
            "172.0.24.41, USA,  false",
            "96.44.183.149, RUSSIA, false"
    })
    public void test_Location_byIp(String ipAddress, String comparedValue, boolean expectedValue) {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ipAddress);
        String country = String.valueOf(location.getCountry());
        boolean result = comparedValue.equals(country);
        Assertions.assertEquals(expectedValue, result);
    }
}