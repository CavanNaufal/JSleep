package MuhammadCavanNaufalAziziJSleepDN;

public class JSleep
{
    public static void main(String[] args){
        Room hotel = JSleep.createRoom();
        
        System.out.println(hotel.name);
        System.out.println(hotel.size);
        System.out.println(hotel.price.price);
        System.out.println(hotel.facility);
    }
    
    public static Room createRoom(){
        Price price = new Price (100000.0, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }
}

