package com.barapps.triggers.utilities;

import android.util.Log;

public class Logger {

    private static final String TAG = "TRIGGERS";

    public static void info(String message, Throwable throwable) {
        Log.i(TAG, message, throwable);
    }

    public static void info(String message) {
        Log.i(TAG, message);
    }

    public static void warn(String message, Throwable throwable) {
        Log.w(TAG, message, throwable);
    }

    public static void warn(String message) {
        Log.w(TAG, message);
    }
}
