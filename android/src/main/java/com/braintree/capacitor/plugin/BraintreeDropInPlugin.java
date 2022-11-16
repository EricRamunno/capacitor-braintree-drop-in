package com.braintree.capacitor.plugin;

import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResult;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BraintreeDropIn")
public class BraintreeDropInPlugin extends Plugin {

  // private BraintreeDropIn implementation = new BraintreeDropIn();
  private final static String TAG = "BraintreeDropInPlugin";

  @Override
  public void load() {
    super.load();

  }

  @PluginMethod
  public void showDropIn(PluginCall call) throws InterruptedException {

    // TODO change this
    String paymentToken = call.getString("paymentToken");
    Intent intent = new Intent(getContext(), BaseActivity.class);
    ClientToken clientToken = new ClientToken(call.getString("givenName"), call.getString("surname"), call.getString("account-id"), String.valueOf(0.01), call.getString("email"), paymentToken);
    intent.putExtra("clientToken", clientToken);
    startActivityForResult(call, intent, "braintreeCallback");


  }


  @ActivityCallback
  private void braintreeCallback(PluginCall call, ActivityResult result) {
    if (call == null) {
      return;
    }
    Intent results = result.getData();

    JSObject ret = new JSObject();
    ret.put("nonce", results.getStringExtra("nonce"));
    ret.put("lastFour", results.getStringExtra("lastFour"));
    call.resolve(ret);
  }


}

