package by.jrr.service;

import by.jrr.bean.Countries;
import by.jrr.bean.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoomServiceTest {

    RoomService roomService;

    @Before
    public void setUp() {
        roomService = new RoomService();
    }

    @Test
    public void findAll() {
        List<Room> expected = makeListOfRooms();
        List<Room> actual = roomService.findAll();
        assertEquals(expected, actual);

    }

    @Test
    public void findById() {
        Room expected = makeRoomWithId();
        Room actual = roomService.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void createRoom() {
        Room expected = makeRoomWithId();
        Room actual = roomService.createRoom("name", Countries.BELARUS);
        assertEquals(expected, actual);
    }


    private List<Room> makeListOfRooms() {
        return List.of(new Room(1, Countries.BELARUS, "name"));
    }

    private Room makeRoomWithId() {
        return new Room(1, Countries.BELARUS, "name");
    }


}
