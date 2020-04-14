package com.yallagym;

import com.codename1.system.NativeInterface;

public interface nativeCodes extends NativeInterface {

    public void enableGPS(String username, String password);

    public void enableGPSAPI();

    public void turnGPSOn();

    public void turnGPSOff();
    
    public String getIosFcmToken();

}
