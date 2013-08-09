package com.example.app2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class LibInterfaceOneTest {
    private Method app1Method;
    private Method app1Method2;
    private Object app1Object;

    public static String LOG = LibInterfaceOneTest.class.getCanonicalName();

    public LibInterfaceOneTest(Context context) {
        try {
            Log.i(LOG, "--app2class1() called.");
            Context mmsCtx = context.createPackageContext("com.example.app1",
                    Context.CONTEXT_INCLUDE_CODE
                            | Context.CONTEXT_IGNORE_SECURITY);

            Class<?> cl = (Class<?>) Class.forName(
                    "com.example.app1.app1class1", true,
                    mmsCtx.getClassLoader());

            app1Method = cl.getMethod("getString", String.class);
            app1Method2 = cl.getMethod("intMethod", Integer.class);

            app1Object = cl.newInstance();

        } catch (NameNotFoundException ex) {
            // called when package, aka... the APK isn't installed
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
    }

    public String testMethodCall(String value) {
        Log.i(LOG, "--testMethodCall() called. : " + value);
        try {

            String rValue = (String) app1Method.invoke(app1Object, value);
            Log.i(LOG, "--testMethodCall(), past method call.");
            return rValue;

        } catch (Exception ex) {
            Log.i(LOG, "--testMethodCall() called, Ex: " + ex.getMessage());
            return " fail :(";
        }
    }

    public int testMethodCall2(int value) {
        // Log.i(LOG, "--testMethodCall() called. : " + value);
        try {

            int rValue = (Integer) app1Method2.invoke(app1Object, value);
            // Log.i(LOG, "--testMethodCall(), past method call.");
            return rValue;

        } catch (Exception ex) {
             Log.i(LOG, "--testMethodCall() called, Ex: " + ex.getMessage());
            return -1;
        }
    }

    public int testMethodCall3(int value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // Log.i(LOG, "--testMethodCall() called. : " + value);

        int rValue = (Integer) app1Method2.invoke(app1Object, value);
        // Log.i(LOG, "--testMethodCall(), past method call.");
        return rValue;

    }
}
