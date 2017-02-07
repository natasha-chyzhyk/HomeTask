package com.natasha.sourceit.communal_payment.model;

/**
 * Created by Stas on 27.01.2017.
 */
public interface User {
    String getLogin();
    boolean checkPassword(String password);
}
