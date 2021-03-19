package by.jrr.moks;

import by.jrr.service.LampService;

public class LampServiceMock extends LampService {

    @Override
    public void changeLampState(boolean newState, long roomId) {
        System.out.println("method called");
    }
}
