import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRadioServices {

    // Тесты станций

    @Test // Получить текущую станцию без дополнительных настроек.
    public void testGetCurrentStation() {
        RadioServices radio = new RadioServices();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test// Уменьшить станцию на 1, при начальном значении станции 0.
    public void testSetPrevStationBelowZero() {
        RadioServices radio = new RadioServices();

        radio.setPrevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test// Установить станцию, не выходя за максимальные или минимальные значения.
    public void testSetStation() {
        RadioServices radio = new RadioServices();

        radio.setStation(2);
        int expected = 2;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Увеличить номер станции на 1, при начальном максимальном значении станции в 9.
    public void testSetStationOverMax() {
        RadioServices radio = new RadioServices();

        radio.setStation(9);
        radio.setNextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test// Установить отрицательное значение номера станции.
    public void testSetStationBelowMin() {
        RadioServices radio = new RadioServices();

        radio.setStation(-10);
        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test// Уменьшить станцию на 1, не выходя за пределы нуля или 9.
    public void testSetPrevStation() {
        RadioServices radio = new RadioServices();

        radio.setStation(3);
        radio.setPrevStation();
        int expected = 2;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Увеличить станцию на 1, не выходя за пределы максимального значения в 9.
    public void testSetNextStation() {
        RadioServices radio = new RadioServices();

        radio.setStation(5);
        radio.setNextStation();
        int expected = 6;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    // Тесты звука

    @Test // Получить текущий уровень звука.
    public void testCurrentSound() {
        RadioServices radio = new RadioServices();

        int expected = 0;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Уменьшить звук на 1, не ниже минимума( 0 ).
    public void testDownSoundNotBelowMin() {
        RadioServices radio = new RadioServices();

        radio.setSoundLevel(1);
        radio.turnDownSound();
        int expected = 0;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Уменьшить звук на 1, ниже минимума.
    public void testDownSoundBelowMin() {
        RadioServices radio = new RadioServices();

        radio.turnDownSound();
        int expected = 0;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Увеличить звук на 1, при начальном значении звука ноль.
    public void testUpSoundNotHigherMaxStartZero() {
        RadioServices radio = new RadioServices();

        radio.turnUpSound();
        int expected = 1;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Увеличить звук на 1, при начальном значении звука сто.
    public void testUpSoundHigherMaxStart100() {
        RadioServices radio = new RadioServices();

        radio.setSoundLevel(100);
        radio.turnUpSound();
        int expected = 100;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Установить произвольный уровень звука не выше максимума( 100 )
    public void testSetSoundNotOverMax() {
        RadioServices radio = new RadioServices();

        radio.setSoundLevel(100);
        int expected = 100;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Установить произвольный уровень звука выше максимума( 100 )
    public void testSetSoundOverMax() {
        RadioServices radio = new RadioServices();

        radio.setSoundLevel(101);
        int expected = 100;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Установить произвольный уровень звука ниже минимума( 0 )
    public void testSetSoundSubZero() {
        RadioServices radio = new RadioServices();

        radio.setSoundLevel(-100);
        int expected = 0;
        int actual = radio.getCurrentSound();

        Assertions.assertEquals(expected, actual);
    }

}
