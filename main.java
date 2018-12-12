package DoAnOop;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        DanhSachNhanVien ds = new DanhSachNhanVien();

//        for (int i = 0; i < 3; i++) {
//            NhanVienKinhDoanh nv = new NhanVienKinhDoanh();
//            nv.nhap();
//
//            ds.themNhanVien(nv);
//            System.out.println("==============================");
//        }
//        
//        ds.ghiFile("DanhSachNhanVien.txt");

        ds = new DanhSachNhanVien();
        ds.docFile("DanhSachNhanVien.txt");
        System.out.println(ds.toString());
    }

}
