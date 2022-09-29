package MuhammadCavanNaufalAziziJSleepDN;

public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String name, email, password;
    
    public Account (int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString()
    {
        return "**** Account ****\n" + "ID : " + id + "\nName Account : " + name + "\nEmail : " + email + "\nPassword : " + password + "\n";
    }
}
