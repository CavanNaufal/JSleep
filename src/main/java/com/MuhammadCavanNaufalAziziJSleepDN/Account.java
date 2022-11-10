package com.MuhammadCavanNaufalAziziJSleepDN;

import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;

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
    
    public String toString()
    {
        return "***** Account *****\n" + "ID : " + id + "\nName Account : " + name + "\nEmail : " + email + "\nPassword : " + password + "\n";
    }
    
    public boolean validate()
    {
        return email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD);
    }
}
