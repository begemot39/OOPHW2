public class Radio {

    // Начальные установки для станций
    private int stationQuantity;
    private int minStationNumber;
    private int maxStationNumber;
    private int currentStation = minStationNumber;
    // Начальные установки для звука
    private int minSoundLevel;
    private int maxSoundLevel = 100;
    private int currentSoundLevel = minSoundLevel;

    // Конструкторы

    public Radio() {
        this.stationQuantity = 10;
        this.maxStationNumber = stationQuantity - 1;
    }

    public Radio( int userStationQuantity ) {
        if ( userStationQuantity > 0 ) {
            this.stationQuantity = userStationQuantity;
        } else {
            return;
        }

        this.maxStationNumber = stationQuantity - 1;
    }


    // Действия со станциями

    public int getStationQuantity() { // Получить количество станций.
        return stationQuantity;
    }

    public int getCurrentStation() { // Получить номер текущей станции.
        return currentStation;
    }

    public void setNextStation() { // Переключиться на следующую станцию.
        currentStation++;
        if (currentStation > maxStationNumber) {
            currentStation = minStationNumber;
        }
    }

    public void setPrevStation() { // Переключиться на предыдущую станцию.
        currentStation--;
        if (currentStation < minStationNumber) {
            currentStation = maxStationNumber;
        }
    }

    public void setStation(int userStationNumber) { // Установить произвольную станцию в пределах количества станций.
        if (userStationNumber > maxStationNumber || userStationNumber < minStationNumber) {
            return;
        } else {
            currentStation = userStationNumber;
        }
    }

    public int getMinStationNumber() {
        return minStationNumber;
    }

    public int getMaxStationNumber() {
        return maxStationNumber;
    }

    // Действия со звуком

    public int getCurrentSound() {
        return currentSoundLevel;
    }

    public void turnUpSound() {
        currentSoundLevel++;
        if (currentSoundLevel > maxSoundLevel) {
            currentSoundLevel = 100;
        }
    }

    public void turnDownSound() {
        currentSoundLevel--;
        if (currentSoundLevel < minSoundLevel) {
            currentSoundLevel = 0;
        }
    }

    public void setSoundLevel(int userSoundValue) {
        if (userSoundValue >= 0) {
            if (getCurrentSound() + userSoundValue > maxSoundLevel) {
                currentSoundLevel = maxSoundLevel;
            } else {
                currentSoundLevel += userSoundValue;
            }
        } else {
            currentSoundLevel = minSoundLevel;
        }
    }
}
