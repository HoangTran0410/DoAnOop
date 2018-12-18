package DoAnOop;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {    
    public static void main(String[] args) throws IOException, ParseException {
//        Menu menu = new Menu();
//        menu.run();
//        MyDate now = new MyDate();
//        now.xuat();
//        
//        MyDate ngaylam = new MyDate(15, 04, 2016);
//        ngaylam.xuat();
//        System.out.println(ngaylam.khoangCach(now));
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;

        String startDate = "18-12-2016";
        String endDate = "18-12-2018";//simpleDateFormat.format(currentDate);
        System.out.println(endDate);

        date1 = simpleDateFormat.parse(startDate);
        date2 = simpleDateFormat.parse(endDate);

        long getDiff = date2.getTime() - date1.getTime();

        long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
        long Years = getDaysDiff / 365;
        System.out.println(Years);
        
    }
}
