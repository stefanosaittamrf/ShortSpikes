package com.rgc.nashorn.entity.impl;

import com.rgc.nashorn.entity.Printer;
import com.rgc.nashorn.entity.utils.JSObjectUtils;
import jdk.nashorn.api.scripting.JSObject;

import static com.rgc.nashorn.entity.utils.JSLoader.load;

public class NashornPrinter implements Printer {
    String name;

    public NashornPrinter(String name) {
        this.name = name;
    }

    public void print() {
        JSObject jsObject = load(name);
        JSObject method = JSObjectUtils.getMethod(jsObject, "print");
        method.call(jsObject);
    }
}
