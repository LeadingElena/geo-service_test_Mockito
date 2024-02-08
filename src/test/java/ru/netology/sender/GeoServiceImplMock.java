package ru.netology.sender;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceImplMock implements GeoService {
    Location value;
    @Override
    public Location byIp(String ip) {
        return value;
    }



    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
