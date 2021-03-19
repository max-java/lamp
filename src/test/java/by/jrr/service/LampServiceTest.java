package by.jrr.service;

import by.jrr.bean.Lamp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LampServiceTest {


    @Test
    public void turnOn() {
        Lamp lamp = new Lamp();
        LampService.turnOn(lamp);

        assertEquals(makeLamp(true), lamp);
    }

    @Test
    public void turnOff() {
        Lamp lamp = new Lamp();
        LampService.turnOff(lamp);

        assertEquals(makeLamp(false), lamp);

    }

    private Lamp makeLamp(boolean gorit) {
        Lamp lamp = new Lamp();
        lamp.setGorit(gorit);
        return lamp;
    }
}
