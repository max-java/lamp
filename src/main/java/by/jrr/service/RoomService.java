package by.jrr.service;

import by.jrr.bean.Countries;
import by.jrr.bean.Room;

import java.util.List;

public class RoomService {

    public List<Room> findAll() {
        return List.of(new Room(1,Countries.BELARUS, "name"));
    }

    public Room findById(long id) {
        return new Room(1,Countries.BELARUS, "name");
    }

    public Room createRoom(String name, Countries country) {
        return new Room(1, Countries.BELARUS, "name");
    }
}
