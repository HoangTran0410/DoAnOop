package DoAnOop;

import java.time.LocalDate;

public class NhanVienSanXuat extends NhanVien{
    private final double phuCapNangNhoc = 0.1;

    public NhanVienSanXuat() {
        super();
    }

    public NhanVienSanXuat(String maNv, String maPB, String maL, String maHD, 
            String ho, String ten, String sdt, String diachi, String gt, 
            int ngaysinh, int thangsinh, int namsinh) {
        super(maNv, maPB, maL, maHD, ho, ten, sdt, diachi, gt, ngaysinh, thangsinh, namsinh);
    }

    public NhanVienSanXuat(NhanVien nv) {
        super(nv);
    }

    public double getPhuCapNangNhoc() {
        return phuCapNangNhoc;
    }
    
    
}
