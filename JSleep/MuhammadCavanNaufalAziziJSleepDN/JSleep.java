package MuhammadCavanNaufalAziziJSleepDN;

public class JSleep
{
    public JSleep(){

    }

    
    public static void main(String[] args) {

        JSleep hotel = new JSleep();
        System.out.println("Nama Hotel : " + hotel.getHotelName());
        System.out.println("ID Hotel : " + hotel.getHotelId());
        System.out.println("Persentase Diskon : " + hotel.getDiscountPercentage(1000, 900));
        System.out.println("Harga Diskon : " + hotel.getDiscountedPrice(1000, 10.0f));
        System.out.println("Harga Awal : " + hotel.getOriginalPrice(900, 10.0f));
        System.out.println("Biaya Admin : " + hotel.getAdminFee(1000));
        System.out.println("Harga Total : " + hotel.getTotalPrice(5000, 1));
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
        harga_awal = (discountedPrice /  (int)(1 - discountPercentage/100));
        return harga_awal;
    }
    
    public static float getAdminFeePercentage()
    {
        float persen_admin_fee;
        return persen_admin_fee = 0.05f;
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


}

