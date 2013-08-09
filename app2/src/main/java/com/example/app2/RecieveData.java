package com.example.app2;

import android.util.Log;

public class RecieveData {

    public static void recieveChannelData(String packageName, String channelName) {
        Log.i("RecieveData_from_APP_TWO", "---packageName: " + packageName
                + " channelName: " + channelName);
    }

}
