/**
 * <pre>
 * Copyright 2015 Soulwolf Ching
 * Copyright 2015 The Android Open Source Project for MaterialRadioGroup
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.materialradio.utils;

import android.os.Build;
import android.util.Log;
import android.view.View;

import com.toaker.common.tlog.TLog;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: Soulwolf Created on 2015/7/15 22:15.
 * email : Ching.Soulwolf@gmail.com
 */
public class Utils {

    private static final String LOG_TAG = "Utils:";

    private static final boolean DEBUG = false;

    private static Class R_attr = null;

    private static Class R_styleable = null;

    static {
        try {
            R_styleable = Class.forName("com.android.internal.R$styleable");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            R_attr = Class.forName("com.android.internal.R$attr");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * An int value that may be updated atomically.
     */
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }

    public static int attr(String field) {
        if (R_attr == null) {
            if(DEBUG){
                TLog.e(LOG_TAG, "getRes(null," + field + ")");
            }
            return 0;
        }
        try {
            Field idField = R_attr.getField(field);
            return idField.getInt(field);
        } catch (Exception e) {
            if(DEBUG){
                Log.e(LOG_TAG, "getRes(" + R_attr.getName() + ", " + field + ")");
                Log.e(LOG_TAG, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
            }
        }
        return 0;
    }

    public static int[] styleables(String field) {
        try {
            if ((R_styleable != null) && (R_styleable.getDeclaredField(field).get(R_styleable) != null)
                    && (R_styleable.getDeclaredField(field).get(R_styleable).getClass().isArray()))
                return (int[]) R_styleable.getDeclaredField(field).get(R_styleable);
        } catch (Exception e) {
            e.printStackTrace();
            if(DEBUG){
                TLog.e(LOG_TAG,"styleables",e);
            }
        }
        return new int[0];
    }
}
