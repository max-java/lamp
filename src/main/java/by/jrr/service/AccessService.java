package by.jrr.service;

import by.jrr.bean.Countries;
import by.jrr.bean.Room;
import by.jrr.exceptions.RoomAccessDeniedException;
import by.jrr.temp.DummyRequest;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AccessService {
    private  AccessService() {

    };

    public static Countries getRoomCountry(Room room) {
        return room.getCountry();
    }

    public static Countries getUserCountry(HttpServletRequest request) throws IOException, GeoIp2Exception {
        String requstHeaderIp = request.getHeader("X-FORWARDED-FOR");
        InetAddress ipAddress = InetAddress.getByName(requstHeaderIp);

        File database = new File("");
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

        CityResponse response = dbReader.city(ipAddress);
        String countryName = response.getCountry().getName();
        Countries country = Countries.valueOf(countryName);
        return country;
    }

    public static boolean validateRoomsCountry(Room room, DummyRequest request) throws Exception {
        if(getRoomCountry(room).equals(getUserCountry(request))) {
            return true;
        }
        throw new RoomAccessDeniedException();
    }

}
