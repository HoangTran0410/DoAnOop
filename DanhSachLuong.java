
package DoAnOop;

public class DanhSachLuong {
    private Luong[] danhSachLuong;

    public DanhSachLuong() {
        danhSachLuong = new Luong[0];
    }
    
    public DanhSachLuong(Luong[] mangLuong) {
        danhSachLuong = mangLuong;
    }
    
    public DanhSachLuong(DanhSachLuong ds) {
        this.danhSachLuong = ds.danhSachLuong;
    }
    
    public Luong timKiemTheoMa(String maLuong) {
//        for(Luong l : danhSachLuong) {
//            if(l.getMaLuong().equals(maLuong))
//                return l;
//        }
        return null;
    }
}
