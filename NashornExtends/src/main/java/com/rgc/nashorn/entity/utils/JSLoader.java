/*
 * Copyright (c) 2017 by Marfeel Solutions (http://www.marfeel.com)
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Marfeel Solutions S.L and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Marfeel Solutions S.L and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Marfeel Solutions SL.
 */

package com.rgc.nashorn.entity.utils;

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.script.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JSLoader {

    public static JSObject load(String file) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        try {
            ScriptContext currentContext = updateEngine(engine, file);

            if (currentContext != null) {
                JSObject objectPrototype = (JSObject) currentContext.getBindings(ScriptContext.ENGINE_SCOPE).get(file);
                JSObject objectInstance = (JSObject) objectPrototype.newObject();

                if (objectInstance != null) {
                    return objectInstance;
                }
            }

        } catch (ScriptException | ECMAException | IOException e) {
            System.out.println("---- ERROR ----");
            System.out.println(e.getMessage());
            System.out.println("---- /ERROR ----");
        }

        return null;
    }

    private static ScriptContext updateEngine(ScriptEngine engine, String name) throws IOException, ScriptException {
        ScriptContext currentContext;
        File file = new File("NashornExtends/src/main/resources/" + name + ".js");

        if (file != null) {
            Reader reader = new FileReader(file);

            currentContext = new SimpleScriptContext();
            Bindings currentBindings = engine.createBindings();
            currentContext.setBindings(currentBindings, ScriptContext.ENGINE_SCOPE);
            engine.eval(reader, currentContext);
            return currentContext;
        }

        return null;
    }
}