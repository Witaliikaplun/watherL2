package com.example.weather;

public final class Singleton {
    private static Singleton instance = null;
    private boolean switchPress;
    private boolean switchHumil;
    private boolean switchSpeed;
    private static final Object obj = new Object();

    private Singleton(){
        switchPress = false;

    }

    public boolean getSwitchPress() {
        return switchPress;
    }

    public void setSwitchPress(boolean switchPress) {
        this.switchPress = switchPress;
    }

    public boolean getSwitchHumil() {
        return switchHumil;
    }

    public void setSwitchHumil(boolean switchHumil) {
        this.switchHumil = switchHumil;
    }

    public boolean getSwitchSpeed() {
        return switchSpeed;
    }

    public void setSwitchSpeed(boolean switchPress) {
        this.switchSpeed = switchPress;
    }

    public static Singleton getSingleton(){
            if(instance == null){
                instance = new Singleton();
        }
        return instance;
    }
}
