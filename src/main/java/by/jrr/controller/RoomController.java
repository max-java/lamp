package by.jrr.controller;

import by.jrr.bean.Countries;
import by.jrr.bean.Room;
import by.jrr.service.AccessService;
import by.jrr.service.RoomService;
import by.jrr.temp.DummyRequest;

public class RoomController {


    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public void enterRoom() throws Exception {
        long roomId= 1;
        DummyRequest dummyRequest = new DummyRequest(null);

        Room room = roomService.findById(roomId);
        AccessService.validateRoomsCountry(room, dummyRequest);
        //redirect to view;
    }
}
