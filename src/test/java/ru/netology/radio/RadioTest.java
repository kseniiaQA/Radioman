package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void stationUnderLimit() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();

        service.setCurrentStation(-1);
        assertEquals(0, service.getCurrentStation());
        service.setCurrentStation(4);
        service.setCurrentStation(-1);
        assertEquals(4, service.getCurrentStation());
    }

    @Test
    void stationAboveLimit() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();

        service.setCurrentStation(10);
        assertEquals(0, service.getCurrentStation());
        service.setCurrentStation(4);
        service.setCurrentStation(10);
        assertEquals(4, service.getCurrentStation());
    }

    @Test
    void stationAboveLimitData() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio(0, 3, 20);

        service.setCurrentStation(-1);
        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(5);
        service.setCurrentStation(50);
        assertEquals(5, service.getCurrentStation());
    }

    @Test
    void stationPrevButton() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();

        assertEquals(0, service.getCurrentStation());

        service.prevButton();
        assertEquals(9, service.getCurrentStation());
        service.prevButton();
        assertEquals(8, service.getCurrentStation());
    }

    @Test
    void stationPrevButtonData() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio(0, 1, 25);

        assertEquals(0, service.getCurrentStation());

        service.prevButton();
        assertEquals(24, service.getCurrentStation());
        service.prevButton();
        assertEquals(23, service.getCurrentStation());
    }

    @Test
    void stationNextButton() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();

        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(8);
        service.nextButton();
        assertEquals(9, service.getCurrentStation());
        service.nextButton();
        assertEquals(0, service.getCurrentStation());
    }

    @Test
    void stationNextButtonData() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio(0, 1, 30);

        assertEquals(0, service.getCurrentStation());

        service.setCurrentStation(28);
        service.nextButton();
        assertEquals(29, service.getCurrentStation());
        service.nextButton();
        assertEquals(0, service.getCurrentStation());
    }


    @Test
    void volumeUp() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();

        assertEquals(0, service.getVolume());

        service.volumeUp();
        assertEquals(1, service.getVolume());
        service.volumeUp();
        assertEquals(2, service.getVolume());
    }

    @Test
    void volumeMoreThanMax() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio(0, 99, 10);


        service.volumeUp();
        assertEquals(100, service.getVolume());
        service.volumeUp();
        assertEquals(100, service.getVolume());
    }

    @Test
    void volumeDown() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();


        service.volumeUp();
        assertEquals(1, service.getVolume());
        service.volumeUp();
        assertEquals(2, service.getVolume());


        service.volumeDown();
        assertEquals(1, service.getVolume());
        service.volumeDown();
        assertEquals(0, service.getVolume());

    }

    @Test
    void volumeDownMin() {
        ru.netology.radio.Radio service = new ru.netology.radio.Radio();


        assertEquals(0, service.getVolume());


        service.volumeDown();
        assertEquals(0, service.getVolume());
    }
}

