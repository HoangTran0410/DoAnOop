package DoAnOop;

import java.time.LocalDate;

public class NhanVienQuanLy extends NhanVien {

    private String maChucVu;
    private double heSoPhuCapChucVu;

    public NhanVienQuanLy() {
        super();
    }

    public NhanVienQuanLy(String maNv, String maPB, String maL, String maHD,
            String ho, String ten, String sdt, String diachi,
            String gt, LocalDate ngaysinh, String maCv, double hsChucVu) {
        super(maNv, maPB, maL, maHD, ho, ten, sdt, diachi, gt, ngaysinh);
        maChucVu = maCv;
        heSoPhuCapChucVu = hsChucVu;
    }

    public NhanVienQuanLy(NhanVienQuanLy nv) {
        super(nv);
        this.maChucVu = nv.maChucVu;
        this.heSoPhuCapChucVu = nv.heSoPhuCapChucVu;
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Nhap ma chuc vu: ");
        maChucVu = scan.nextLine();
        System.out.print("He so phu cap chuc vu: ");
        heSoPhuCapChucVu = scan.nextDouble();
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Ma chuc vu: " + maChucVu);
        System.out.println("He so phu cap chuc vu: " + heSoPhuCapChucVu);
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public double getHeSoPhuCapChucVu() {
        return heSoPhuCapChucVu;
    }

    public void setHeSoPhuCapChucVu(double heSoPhuCapChucVu) {
        this.heSoPhuCapChucVu = heSoPhuCapChucVu;
    }
}
