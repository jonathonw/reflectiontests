package com.example.app1;

/**
 * @author Michael A. Walker
 * @date 2013-08-06
 * 
 *       This class uses the two required methods, and the needed call to
 *       'sendDataToTwo(Context)'to notify App2 (which would be AmmoCore) of the
 *       information required for App2 to be able to load the class & method(s)
 *       from App1
 *       <p>
 *       (which could be:a Channel, a 'plug-in', an AMMO debug only APK, etc...)
 * 
 */

public class notifyApp2 extends com.example.app2lib.LibClassTwo {

    @Override
    public String returnChannelPackage() {
        return "com.example.app1";
    }

    @Override
    public String returnChannelClass() {
        return "com.example.app1.app1class1";
    }

}
