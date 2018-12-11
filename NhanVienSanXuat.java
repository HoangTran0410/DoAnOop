package DoAnOop;

import java.time.LocalDate;

public class NhanVienSanXuat extends NhanVien{
    private final double phuCapNangNhoc = 0.1;

    public NhanVienSanXuat() {
        super();
    }

    public NhanVienSanXuat(String maNv, String maPB, String maL, String maHD, String ho, String ten, String sdt, String diachi, String gt, LocalDate ngaysinh) {
        super(maNv, maPB, maL, maHD, ho, ten, sdt, diachi, gt, ngaysinh);
    }

    public NhanVienSanXuat(NhanVien nv) {
        super(nv);
    }

    public double getPhuCapNangNhoc() {
        return phuCapNangNhoc;
    }
    
    
}
