package com.MuhammadCavanNaufalAziziJSleepDN;

import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;

/**
 * The `Account` class represents a user account. It contains information
 * such as the user's name, email, password, and balance. The `Account`
 * class also provides methods for validating the email and password, and
 * for generating a string representation of the account.
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String name, email, password;
    public Renter renter;
    public double balance;

    public static final String REGEX_EMAIL = "^\\w+@\\w+([.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](?=\\S+$).{8,}$";
    
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Returns a string representation of the `Account` object.
     *
     * @return a string representation of the `Account` object
     */
    public String toString()
    {
        return "***** Account *****\n" + "ID : " + id + "\nName Account : " + name + "\nEmail : " + email + "\nPassword : " + password + "\n";
    }

    /**
     * Validates the email and password for the `Account` object.
     *
     * @return `true` if the email and password are valid, `false` otherwise
     */
    
    public boolean validate()
    {
        return email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD);
    }
}
