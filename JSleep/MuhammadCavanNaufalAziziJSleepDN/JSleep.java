package MuhammadCavanNaufalAziziJSleepDN;

/**
 * Write a description of class JSleep here.
 *
 * @author (Muhammad Cavan Naufal Azizi)
 * @version (a version number or a date)
 */

public class JSleep
{
    public static void main(String[] args){
    Payment testRoom = new Payment (1, 1, 1, "", 1, "", "");
    Invoice testInvoice = new Invoice(2,2,2, "");
    System.out.println(testRoom.print());
    System.out.println(testInvoice.print());
    }
}

