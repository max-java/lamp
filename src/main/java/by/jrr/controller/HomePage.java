package by.jrr.controller;

import by.jrr.bean.Countries;
import by.jrr.service.RoomService;

public class HomePage {

    RoomService roomService;

    public HomePage(RoomService roomService) {
        this.roomService = roomService;
    }

    public void openMain() {
        roomService.findAll();
    }

    public void createRoom() {
        roomService.createRoom("name", Countries.BELARUS);
        roomService.findAll();
        //redirect to home;
    }
}
