package com.example.app1;

import com.example.app2lib.IInterface;

/**
 * Created with IntelliJ IDEA.
 * User: jwilliams
 * Date: 8/12/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class SomethingPrinter implements IInterface {
    public SomethingPrinter() {
        //do nothing
    }

    @Override
    public String printSomething() {
        return "Something Else";
    }
}
