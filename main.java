
package DoAnOop;

public class main {

    public static void main(String[] args) {
        NhanVien nv = new NhanVienQuanLy();
        nv.nhapThongTin();
        
        nv.xuatThongTin();
        
        DanhSachNhanVien ds = new DanhSachNhanVien();
        
        DanhSachLuong dsl = new DanhSachLuong();
    }
    
}
