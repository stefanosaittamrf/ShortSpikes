/*
    Created by: rguerrero
    Date: 25.02.2018
 */

package com.rgc.nashorn;

import com.rgc.nashorn.entity.Printer;
import com.rgc.nashorn.entity.impl.JavaPrinter;
import com.rgc.nashorn.entity.impl.NashornPrinter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");

        List<Printer> printers = Arrays.asList(new JavaPrinter(),
                                                new NashornPrinter("CompleteNashorn"),
                                                new NashornPrinter("PartialNashorn"));
        for(Printer printer : printers) {
            printer.print();
        }

        System.out.println("--------------------------------------");
    }
}
