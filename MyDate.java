package DoAnOop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {

    private int ngay, thang, nam;

    public MyDate() {
//        Date now = new Date();
//        ngay = now.getDate();
//        thang = now.getMonth() + 1;
//        nam = now.getYear() + 1900;
        ngay = 19;
        thang = 12;
        nam = 2018;
    }

    public MyDate(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public MyDate(MyDate other) {
        this.ngay = other.ngay;
        this.thang = other.thang;
        this.nam = other.nam;
    }

    public MyDate(Date d) {
        ngay = d.getDate();
        thang = d.getMonth() + 1;
        nam = d.getYear() + 1900;
    }

    public int khoangCach(MyDate other) {
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

            String startDate = CheckValidation.formatDate_NumToString(ngay, thang, nam);
            String endDate = CheckValidation.formatDate_NumToString(other.getNgay(), other.getThang(), other.getNam());

            Date date1 = simpleDateFormat.parse(startDate);
            Date date2 = simpleDateFormat.parse(endDate);

            long getDiff = date2.getTime() - date1.getTime();

            long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
            long year = getDaysDiff / 365;
            return (int) year;

        } catch (ParseException ex) {
            System.err.println("Chuyen doi ngay thang khong thanh cong!");
        }

        return -1;
    }

    public Boolean nhoHon(MyDate other) {
        if (this.nam < other.nam) {
            return true;
        } else if (this.nam > other.nam) {
            return false;
        }

        if (this.thang < other.thang) {
            return true;
        } else if (this.thang > other.thang) {
            return false;
        }

        return this.ngay < other.ngay;
    }

    public Boolean lonHon(MyDate other) {
        if (this.nam > other.nam) {
            return true;
        } else if (this.nam < other.nam) {
            return false;
        }

        if (this.thang > other.thang) {
            return true;
        } else if (this.thang < other.thang) {
            return false;
        }

        return this.ngay > other.ngay;
    }

    public Boolean equal(MyDate other) {
        return this.nam == other.nam && this.thang == other.thang && this.ngay == other.ngay;
    }

    public void xuat() {
        System.out.println(CheckValidation.formatDate_NumToString(ngay, thang, nam));
    }

    @Override
    public String toString() {
        return CheckValidation.formatDate_NumToString(ngay, thang, nam);
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

}
