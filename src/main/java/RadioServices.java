public class RadioServices {

    private int currentStation = 0;
    private int currentSoundLevel = 0;

    // Действия со станциями

    public int getCurrentStation() {
        return currentStation;
    }

    public void setNextStation() {
        currentStation++;
        if (currentStation > 9) {
            currentStation = 0;
        }
    }

    public void setPrevStation() {
        currentStation--;
        if (currentStation < 0) {
            currentStation = 9;
        }
    }

    public void setStation(int stationNumber) {
        if (stationNumber > 9 || stationNumber < 0) {
            return;
        } else {
            currentStation = stationNumber;
        }
    }

    // Действия со звуком

    public int getCurrentSound() {
        return currentSoundLevel;
    }

    public void turnUpSound() {
        currentSoundLevel++;
        if (currentSoundLevel > 100) {
            currentSoundLevel = 100;
        }
    }

    public void turnDownSound() {
        currentSoundLevel--;
        if (currentSoundLevel < 0) {
            currentSoundLevel = 0;
        }
    }

    public void setSoundLevel(int userSoundValue) {
        if (userSoundValue >= 0) {
            if (getCurrentSound() + userSoundValue > 100) {
                currentSoundLevel = 100;
            } else {
                currentSoundLevel += userSoundValue;
            }
        } else {
            currentSoundLevel = 0;
        }
    }
}
