package com.example.app2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class app2class1 {

    private Method app1Method;
    private Object app1Object;

    public static String LOG = app2class1.class.getCanonicalName();

    public app2class1(Context context) {

        try {
            Log.i(LOG, "--app2class1() called.");
            Context mmsCtx = context.createPackageContext("com.example.app1",
                    Context.CONTEXT_INCLUDE_CODE
                            | Context.CONTEXT_IGNORE_SECURITY);

            Class<?> cl = Class.forName("com.example.app1.app1class1", true,
                    mmsCtx.getClassLoader());

            Log.i(LOG, "--getCanonicalName()= " + cl.getCanonicalName());
            // cl.getMethod("init", Context.class).invoke(null, mmsCtx);

            app1Method = cl.getMethod("getString", String.class);
            Log.i(LOG, "--getMethod got a method");

            app1Object = cl.getMethod("getInstance").invoke((Object[]) null);

            // Method app1Metho2 = cl.getm

            Log.i(LOG, "--getInstance passed");

            // app1Object = cl.getMethod("getInstance").invoke("s");
            // cl.getMethod("getString", String.class).invoke(cl,
            // " static method invocation worked ");
            //
            // app1Method = cl.getMethod("voidMethod", Void.class);
        } catch (NameNotFoundException ex) {
            Log.e(LOG,
                    "--constructor() created NameNotFoundException: "
                            + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            // TODO Auto-generated catch block
            Log.e(LOG,
                    "--constructor() created ClassNotFoundException: "
                            + ex.getMessage());
        } catch (NoSuchMethodException ex) {
            // TODO Auto-generated catch block
            Log.e(LOG,
                    "--constructor() created NoSuchMethodException: "
                            + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            // TODO Auto-generated catch block
            Log.e(LOG, "--constructor() created IllegalArgumentException: "
                    + ex.getMessage());
        } catch (IllegalAccessException ex) {
            // TODO Auto-generated catch block
            Log.e(LOG,
                    "--constructor() created IllegalAccessException: "
                            + ex.getMessage());
        } catch (InvocationTargetException ex) {
            // TODO Auto-generated catch block
            Log.e(LOG, "--constructor() created InvocationTargetException: "
                    + ex.getMessage());
        } catch (Exception ex) {
            Log.e(LOG, "--constructor() created Exception: " + ex.getMessage());
        }

    }

    public String testMethodCall(String value) {
        Log.i(LOG, "--testMethodCall() called.: ");
        try {

            String rValue = (String) app1Method.invoke(app1Object, value);
            Log.i(LOG, "--testMethodCall(), past method call.");
            return rValue;

        } catch (Exception ex) {
            Log.e(LOG, "--testMethodCall() called, Ex: " + ex.getMessage());
            return " fail :(";
        }
    }

}
