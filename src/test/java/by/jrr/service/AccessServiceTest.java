package by.jrr.service;

import by.jrr.bean.Countries;
import by.jrr.bean.Room;
import by.jrr.exceptions.RoomAccessDeniedException;
import by.jrr.temp.DummyRequest;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AccessServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getRoomCountry() {
        Room room = new Room(0, Countries.BELARUS, null);
        Countries actual = AccessService.getRoomCountry(room);

        assertEquals(Countries.BELARUS, actual);
    }

    @Test
    public void getUserCountry() throws IOException, GeoIp2Exception {
        DummyRequest request = new DummyRequest(Countries.BELARUS);
        
        Countries actual = AccessService.getUserCountry(request);

        assertEquals(Countries.BELARUS, actual);
    }

    @Test
    public void validateRoomsCountryPositive() throws Exception {
        Room room = new Room(0, Countries.BELARUS, null);
        DummyRequest request = new DummyRequest(Countries.BELARUS);

        boolean actual = AccessService.validateRoomsCountry(room, request);
        assertTrue(actual);
    }

    @Test(expected = RoomAccessDeniedException.class)
    public void validateRoomsCountryNegative() throws Exception {
        Room room = new Room(0, Countries.BELARUS, null);
        DummyRequest request = new DummyRequest(Countries.USA);

        AccessService.validateRoomsCountry(room, request);

    }
}
