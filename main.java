package DoAnOop;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        DanhSachNhanVien ds = new DanhSachNhanVien();

//        NhanVienKinhDoanh nvkd = new NhanVienKinhDoanh("001", "001", "001", "001",
//                "tran van", "hoang", "nam", "1316824", "tp hcm", 12, 11, 1999, 999999999, 1000);
//
//        NhanVienQuanLy nvpl = new NhanVienQuanLy("002", "001", "001", "001",
//                "nguyen", "sang", "nu", "242572", "tp da nang", 24, 5, 1989, "truongphong", 1.7);
//
//        NhanVienSanXuat nvsx = new NhanVienSanXuat("003", "001", "001", "001",
//                "phan", "huu", "nam", "257224", "ha noi", 2, 8, 2004, 2);
//
//        ds.themNhanVien(nvkd);
//        ds.themNhanVien(nvpl);
//        ds.themNhanVien(nvsx);
//        System.out.println("==============================");
//
//        ds.ghiDe("DanhSachNhanVien.txt");
        ds.docFile("DanhSachNhanVien.txt");
        ds.xuat();

        ds.timKiemNhanVienSanXuat()[0].xuat();

//        for(NhanVien x : ds.timKiemNhanVienKinhDoanh() )
//            x.xuat();
    }
}
