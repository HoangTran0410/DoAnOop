package DoAnOop;

import java.io.IOException;

public class main {    
    public static void main(String[] args) throws IOException {
        
//        DanhSachNhanVien ds = new DanhSachNhanVien();
//        NhanVienKinhDoanh nvkd = new NhanVienKinhDoanh("001", "001", "001", "001", "tran van", "hoang", "nam", "1316824", "tp hcm", 12, 11, 1999, 999999999, 1000);
//        NhanVienQuanLy nvpl = new NhanVienQuanLy("002", "001", "001", "001", "nguyen", "sang", "nu", "242572", "tp da nang", 24, 5, 1989, "truongphong", 1.7);
//        NhanVienSanXuat nvsx = new NhanVienSanXuat("003", "001", "001", "001","phan", "huu", "nam", "257224", "ha noi", 2, 8, 2004, 2);
//
//        ds.them(nvkd);
//        ds.them(nvpl);
//        ds.them(nvsx);
//        System.out.println("==============================");
//        ds.ghiDe("DanhSachNhanVien.txt");
//        ds.docFile("DanhSachNhanVien.txt");
//        ds.xuat();
//
//        ds.timKiemNhanVienSanXuat()[0].xuat();

//        DanhSachPhongBan dspb = new DanhSachPhongBan();
//        dspb.them(new PhongBan("01", "Phong 1", "0123456", "Ha noi"));
//        dspb.them(new PhongBan("02", "Phong 2", "2484564", "HCM"));
//        dspb.them(new PhongBan("03", "Phong 3", "3789646", "Da Nang"));
//        dspb.them(new PhongBan("04", "Phong 4", "48974646", "Bac Ninh"));
//        
//        dspb.ghiDe("DanhSachPhongBan.txt");
//        dspb.docFile(FILE_DANHSACHPHONGBAN);
//        dspb.xuat();
        Menu menu = new Menu();
        
        menu.run();
    }
}
