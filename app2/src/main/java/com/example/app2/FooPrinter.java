package com.example.app2;

import com.example.app2lib.IInterface;

/**
 * Created with IntelliJ IDEA.
 * User: jwilliams
 * Date: 8/12/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class FooPrinter implements IInterface {
    @Override
    public String printSomething() {
        return "Foo";
    }
}
