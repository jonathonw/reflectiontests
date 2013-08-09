package com.example.app2lib;

import android.view.View;

/**
 * 
 * @author Michael A. Walker
 * @date 2013-08-06
 * 
 * 
 *       Interface for the 'work' that App1 has to do, that each 'app' would
 *       have to do.
 *       <p>
 *       Each "app" would be a channel, plug-in, debug tool, etc.
 *       <p>
 *       These methods are mostly chosen at random for testing of different
 *       combinations of parameter and return values.
 * 
 */
public interface LibClassOne {

    public void voidMethod();

    public String getString(String value);

    public void voidMethodParam(int parameter);

    public String stringMethod(String value);

    public View getView();
    
    public int intMethod(Integer param);

}
