package DoAnOop;

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
        Boolean valid;
        try {
            long sdt = Long.parseLong(phone);
            
            valid = (phone.length() == 10);
            if (!valid) {
                System.err.println("So dien thoai khong hop le!");
            }

        } catch (NumberFormatException e) {
            System.err.println("So dien thoai khong hop le!");
            return false;
        }
        return valid;
    }

    public static Boolean isSexValid(String gt) {
        Boolean valid = gt.equalsIgnoreCase("nam") || gt.equalsIgnoreCase("nu");
        if (!valid) {
            System.err.println("Gioi tinh khong hop le!");
        }
        return valid;
    }

    public static Boolean checkTrungMa_NhanVien(String ma) {
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docFile(Menu.FILE_DANHSACHNHANVIEN);

        return dsnv.timKiemTheoMa(ma) != null;
    }

    public static Boolean checkTrungMa_PhongBan(String ma) {
        DanhSachPhongBan dspb = new DanhSachPhongBan();
        dspb.docFile(Menu.FILE_DANHSACHPHONGBAN);

        return dspb.timKiemTheoMa(ma) != null;
    }
}
