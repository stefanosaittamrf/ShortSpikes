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
import jdk.nashorn.internal.runtime.Undefined;

public class JSObjectUtils {

    public static JSObject getMethod(JSObject jsObject, String methodName) {
        Object method = jsObject.getMember(methodName);

        if(method != null && !method.equals(Undefined.getUndefined())) {
            return (JSObject) method;
        }

        return null;
    }
}