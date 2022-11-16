package com.braintree.capacitor.plugin;

import android.util.Log;

public class BraintreeDropIn {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
