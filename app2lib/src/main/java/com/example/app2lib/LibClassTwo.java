package com.example.app2lib;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public abstract class LibClassTwo {

    public abstract String returnChannelPackage();

    public abstract String returnChannelClass();

    public static String LOG = LibClassTwo.class.getCanonicalName();

    public void sendDataToTwo(Context context) {
        Method app1Method = null;
        Object app1Object = null;
        try {
            Log.i(LOG, "--app2class1() called.");
            Context mmsCtx = context.createPackageContext("com.example.app2",
                    Context.CONTEXT_INCLUDE_CODE
                            | Context.CONTEXT_IGNORE_SECURITY);

            Class<?> cl = (Class<?>) Class.forName(
                    "com.example.app2.RecieveData", true,
                    mmsCtx.getClassLoader());

            app1Method = cl.getMethod("recieveChannelData", String.class,
                    String.class);

            app1Object = cl.newInstance();

        } catch (NameNotFoundException ex) {
            // called when package, aka... the APK isn't installed
            // or method name is wrong
            Log.e(LOG,
                    "--constructor() created NameNotFoundException: "
                            + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Log.e(LOG,
                    "--constructor() created ClassNotFoundException: "
                            + ex.getMessage());
        } catch (NoSuchMethodException ex) {
            Log.e(LOG,
                    "--constructor() created NoSuchMethodException: "
                            + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Log.e(LOG, "--constructor() created IllegalArgumentException: "
                    + ex.getMessage());
        } catch (IllegalAccessException ex) {
            Log.e(LOG,
                    "--constructor() created IllegalAccessException: "
                            + ex.getMessage());
        } catch (Exception ex) {
            Log.e(LOG,
                    "90--constructor() created Exception: " + ex.getMessage());
        }

        try {

            String[] values = { returnChannelPackage(), returnChannelClass() };
            app1Method.invoke(app1Object, (Object[]) values);
            Log.i(LOG, "--testMethodCall(), past method call.");

        } catch (Exception ex) {
            Log.i(LOG, "--testMethodCall() called, Ex: " + ex.getMessage());

        }
    }
}
