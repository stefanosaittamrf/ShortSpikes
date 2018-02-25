package com.rgc.nashorn.entity.impl;

import com.rgc.nashorn.entity.Printer;

public abstract class NashornExtendsPrinter implements Printer {

    public void print() {
        System.out.println("---> PartialPrinting :");

        for (int i = 0; i < 10; i++) {
            partialPrinting(i);
        }
    }

    public abstract void partialPrinting(int i);
}
