package com.braintree.capacitor.plugin;

import static com.braintreepayments.api.ThreeDSecureRequest.VERSION_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.braintreepayments.api.DropInClient;
import com.braintreepayments.api.DropInListener;
import com.braintreepayments.api.DropInRequest;
import com.braintreepayments.api.DropInResult;
import com.braintreepayments.api.ThreeDSecureAdditionalInformation;
import com.braintreepayments.api.ThreeDSecurePostalAddress;
import com.braintreepayments.api.ThreeDSecureRequest;

public class BaseActivity extends AppCompatActivity implements DropInListener {

  private DropInClient dropInClient;
  private DropInListener dropInListener;
  private DropInRequest dropInRequest;
  // private Object Activity;
  private Intent intentToken;
  private Button clickButton;

  public BaseActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
    clickButton = (Button) findViewById(R.id.braintree);

    // get data from intent
    ThreeDSecurePostalAddress address = new ThreeDSecurePostalAddress();
    intentToken = getIntent();
    ClientToken tokenFromIntent = (ClientToken) intentToken.getSerializableExtra("clientToken");

    address.setGivenName(tokenFromIntent.getGivenName());
    address.setSurname(tokenFromIntent.getSurname());

    ThreeDSecureAdditionalInformation additionalInformation = new ThreeDSecureAdditionalInformation();
    additionalInformation.setShippingAddress(address);
    additionalInformation.setAccountId(tokenFromIntent.getAccountId());

    ThreeDSecureRequest threeDSecureRequest = new ThreeDSecureRequest();
    threeDSecureRequest.setAmount(tokenFromIntent.getAmount());
    threeDSecureRequest.setEmail(tokenFromIntent.getEmail());
    threeDSecureRequest.setBillingAddress(address);
    threeDSecureRequest.setVersionRequested(VERSION_2);
    threeDSecureRequest.setAdditionalInformation(additionalInformation);

    dropInClient = new DropInClient(this, tokenFromIntent.getAuthToken());


    dropInRequest = new DropInRequest();
    dropInRequest.setThreeDSecureRequest(threeDSecureRequest);
    dropInClient.setListener(this);
    Log.d("BaseActivity", this.dropInClient.toString());

    clickButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        dropInClient.launchDropIn(dropInRequest);
      }
    });


  }

  @Override
  public void onStart() {
    super.onStart();
    clickButton.performClick();
  }

  @Override
  public void onDropInSuccess(@NonNull DropInResult dropInResult) {
    Intent intent = new Intent();
    intent.putExtra("nonce", dropInResult.getPaymentMethodNonce().getString());
    intent.putExtra("lastFour", dropInResult.getPaymentDescription());
    setResult(AppCompatActivity.RESULT_OK, intent);
    finish();
  }

  @Override
  public void onDropInFailure(@NonNull Exception error) {
    Log.d("Base Activity", error.toString()); // da qui leggi l'errore
    Intent intent = new Intent();
    intent.putExtra("Result", "null");
    setResult(AppCompatActivity.RESULT_CANCELED, intent);
    finish();
  }
}
