package by.jrr.service;

import by.jrr.bean.Lamp;

public class LampService {

    public static void turnOn(Lamp lamp) {
        lamp.setGorit(true);
    }
    public static void turnOff(Lamp lamp) {
        lamp.setGorit(false);
    }

    public Lamp findLampByRoomId(long roomId) {
        return new Lamp(1, false);
    }

    public void saveLamp(Lamp lamp) {

    }

    public void changeLampState(boolean newState, long roomId){
        Lamp lamp = this.findLampByRoomId(roomId);
        if(lamp.isGorit()) {
            LampService.turnOff(lamp);
        } else {
            LampService.turnOn(lamp);
        }
        this.saveLamp(lamp);
    }
}
