package MuhammadCavanNaufalAziziJSleepDN;

public class JSleep
{
    
    public static float persendis, hargadiskon, harga_awal, persen_admin_fee, admin_fee, result;
    public static void main(String[] args) {

        JSleep hotel = new JSleep();
        System.out.println("Nama Hotel : " + hotel.getHotelName());
        System.out.println("ID Hotel : " + hotel.getHotelId());
        System.out.println("Persentase Diskon : " + hotel.getDiscountPercentage(100000, 90000));
        System.out.println("Harga Diskon : " + hotel.getDiscountedPrice(100000, 0.1f));
        System.out.println("Harga Awal : " + hotel.getOriginalPrice(90000, 0.1f));
        System.out.println("Biaya Admin : " + hotel.getAdminFee(100000));
        System.out.println("Harga Total : " + hotel.getTotalPrice(100000, 2));
    }
    

    public int getHotelId()
    {
        return 0;        
    }
    
    public String getHotelName()
    {
        return "hotel";        
    }
    
    public boolean isDiscount()
    {
        return true;
    }
    
    public float getDiscountPercentage(int beforeDiscount, int afterDiscount) 
    {   
        if(beforeDiscount > afterDiscount){
            persendis = 100;
        }else{
            persendis = (float) ((beforeDiscount - afterDiscount) / beforeDiscount);
        }
        return persendis;
    }

    public float getDiscountedPrice(int price, float discountPercentage)
    {
        if(discountPercentage > 100.0f){
            hargadiskon = 100.0f;
        }else{
            hargadiskon = (float) (price - (price * (discountPercentage/100.0f)));
        }
        return hargadiskon;
    }
    
    public float getOriginalPrice(int discountedPrice, float discountPercentage)
    {   
        harga_awal = (float) (discountedPrice /  (100.0f - discountPercentage));
        return harga_awal;
    }
    
    public float getAdminFeePercentage()
    {
        return persen_admin_fee = 0.05f;
    }
    
    public float getAdminFee(int price)
    {
        admin_fee = price * (getAdminFeePercentage());
        return admin_fee;
    }
    
    public float getTotalPrice(int price, int numberOfNight)
    {
        result = ((float) price * numberOfNight) + getAdminFee(price * numberOfNight);
        return result;
    }
}

