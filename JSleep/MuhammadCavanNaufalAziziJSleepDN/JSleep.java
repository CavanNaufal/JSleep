package MuhammadCavanNaufalAziziJSleepDN;

public class JSleep
{
    public static void main(String[] args) {

        //JSleep hotel = new JSleep();
        
        //System.out.println("Nama Hotel : " + hotel.getHotelName());
        //System.out.println("ID Hotel : " + hotel.getHotelId());
        //System.out.println("is Discount : " + hotel.isDiscount());
        //System.out.println("Persentase Diskon : " + hotel.getDiscountPercentage(0, 0));
        //System.out.println("Harga Diskon : " + hotel.getDiscountedPrice(0, 0));
        //System.out.println("Harga Awal : " + hotel.getOriginalPrice(0, 0));
        //System.out.println("Persentase Biaya Admin : " + hotel.getAdminFeePercentage());
        //System.out.println("Biaya Admin : " + hotel.getAdminFee(0));
        //System.out.println("Harga Total : " + hotel.getTotalPrice(0, 0));
        
        Room hotel = JSleep.createRoom();
        System.out.println(hotel.name);
        System.out.println(hotel.size);
        System.out.println(hotel.price.price);
        System.out.println(hotel.facility);
    }


    public static int getHotelId()
    {
        return 0;
    }

    public static String getHotelName()
    {
        return "hotel";
    }

    public static boolean isDiscount()
    {
        return true;
    }

    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount)
    {
        float persendis;
        if(beforeDiscount < afterDiscount){
            persendis = 0.0f;
        }else if (beforeDiscount == 0){
            persendis = 0;
        }else{
            persendis = (float)((beforeDiscount - afterDiscount) / (float)beforeDiscount) * 100.0f;
        }
        return persendis;
    }

    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        int hargadiskon;
        if(discountPercentage > 100.0f){
            hargadiskon = 100;
        }else{
            hargadiskon = (price - (int)(price * (discountPercentage/100.0f)));
        }
        return hargadiskon;
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        int harga_awal;
        harga_awal = 100 * discountedPrice / (100-(int)discountPercentage);
        return harga_awal;
    }

    public static float getAdminFeePercentage()
    {
        return 0.05f;
    }

    public static int getAdminFee(int price)
    {
        int admin_fee;
        admin_fee = (int)((float)price * getAdminFeePercentage());
        return admin_fee;
    }

    public static int getTotalPrice(int price, int numberOfNight)
    {
        int result;
        result = price * numberOfNight + getAdminFee(price * numberOfNight);
        return result;
    }
    
    public static Room createRoom(){
        Price price = new Price (100000.0, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }

}

