package MuhammadCavanNaufalAziziJSleepDN;

public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String name, email, password;
    
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString()
    {
        return "**** Account ****\n" + "ID : " + id + "\nName Account : " + name + "\nEmail : " + email + "\nPassword : " + password + "\n";
    }
    
    public Object write()
    {
        return null;
    }
    
    public boolean read(String content)
    {
        return false;
    }
}
