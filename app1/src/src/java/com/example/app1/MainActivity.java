package com.example.app1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    // for Log.d(LOG, "...") use
    public static String LOG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notifyApp2 notifier = new notifyApp2();

        notifier.sendDataToTwo(getApplicationContext());
        // for logging
        Log.d(LOG, "Sent Needed Data To App2 (Core)");

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
