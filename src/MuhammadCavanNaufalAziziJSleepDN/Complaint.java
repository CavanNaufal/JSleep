package MuhammadCavanNaufalAziziJSleepDN;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
    // instance variables - replace the example below with your own
    public String desc, date;

    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(String date, String desc)
    {
        super();
        this.date = date;
        this.desc = desc;
    }
    
    public String toString()
    {
        // put your code here
        return "**** Complaint ****\n" + "ID : " + id + "\nDate : " + date + "\nDesc : " + desc + "\n";
    }
}
