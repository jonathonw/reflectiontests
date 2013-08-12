package com.example.app1;

import android.util.Log;
import android.view.View;

import com.example.app2lib.LibClassOne;

public class app1class1 implements LibClassOne {

    public static String LOG = app1class1.class.getCanonicalName();

    public app1class1() {

    }

    public String getString(String value) {

        Log.d(LOG, "--staticVoid() called w/ " + value);
        return value + "passed through app1class1";
    }

    public void voidMethod() {
        Log.d(LOG, "--voidMethod() called.");
    }

    public void voidMethodParam(int parameter) {
        Log.d(LOG, "--voidMethodParam(int) called with : " + parameter);
    }

    public String stringMethod(String value) {
        Log.d(LOG, "--stringMethod() called w/ " + value);
        return value;
    }

    public View getView() {
        // TODO Auto-generated method stub
        return null;
    }

    public int intMethod(Integer param) {
        return (param + 1);
    }
}
