package by.jrr.controller;

import by.jrr.bean.Lamp;
import by.jrr.service.LampService;

//turnOnLamp / turnOffLamp Rest endpoints
public class LampControllerApi {

    LampService lampService;

    public LampControllerApi(LampService lampService) {
        this.lampService = lampService;
    }

    public void changeLampState() {
        boolean newState = false;
        long roomId = 0;

        lampService.changeLampState(newState, roomId);
    }
}
