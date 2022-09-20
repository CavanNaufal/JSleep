package MuhammadCavanNaufalAziziJSleepDN;

public class JSleep
{
    public JSleep(){

    }


    public static void main(String[] args) {

        JSleep hotel = new JSleep();
        System.out.println("Nama Hotel : " + hotel.getHotelName());
        System.out.println("ID Hotel : " + hotel.getHotelId());
        System.out.println("is Discount : " + hotel.isDiscount());
        System.out.println("Persentase Diskon : " + hotel.getDiscountPercentage(0, 0));
        System.out.println("Harga Diskon : " + hotel.getDiscountedPrice(0, 0));
        System.out.println("Harga Awal : " + hotel.getOriginalPrice(0, 0));
        System.out.println("Persentase Biaya Admin : " + hotel.getAdminFeePercentage());
        System.out.println("Biaya Admin : " + hotel.getAdminFee(0));
        System.out.println("Harga Total : " + hotel.getTotalPrice(0, 0));
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


}

