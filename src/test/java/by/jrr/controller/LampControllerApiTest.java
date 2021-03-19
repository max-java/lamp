package by.jrr.controller;

import by.jrr.moks.LampServiceMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LampControllerApiTest {

    LampControllerApi lampControllerApi;

    @Before
    public void setUp() {
        lampControllerApi = new LampControllerApi(new LampServiceMock());
    }

    @Test
    public void changeLampState() {
        lampControllerApi.changeLampState();
    }
}
