package DoAnOop;

import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckValidation {

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static String formatDate_NumToString(int ngay, int thang, int nam) {
        return ngay + "-" + thang + "-" + nam;
    }
    
    public static Boolean isPhoneValid(String phone) {
        try {
            int sdt = parseInt(phone);
        }catch(NumberFormatException e){
            System.err.println("So dien thoai khong hop le!");
            return false;
        }
        return phone.length() == 10;
    }
}
