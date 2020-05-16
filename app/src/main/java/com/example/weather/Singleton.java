package com.example.weather;

public final class Singleton {
    private static Singleton instance = null;
    private boolean switchPress;
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

    public static Singleton getSingleton(){
            if(instance == null){
                instance = new Singleton();
        }
        return instance;
    }
}
