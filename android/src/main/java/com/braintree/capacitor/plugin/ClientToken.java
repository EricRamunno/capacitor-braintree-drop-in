package com.braintree.capacitor.plugin;


import java.io.Serializable;

public class ClientToken implements Serializable {
    private String givenName;
    private String surname;
    private String accountId;
    private String amount;
    private String email;
    private String authToken;


    public ClientToken(String givenName, String surname, String accountId, String amount, String email, String authToken) {
        this.givenName = givenName;
        this.surname = surname;
        this.accountId = accountId;
        this.amount = amount;
        this.email = email;
        this.authToken = authToken;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


}
