package doan_oop;

import java.time.LocalDate;

public class NhanVienKinhDoanh extends NhanVien {

    private int doanhSoToiThieu, doanhSoThucTe;

    public NhanVienKinhDoanh() {
        super();
    }

    public NhanVienKinhDoanh(String maNv, String maPB, String maL, String maHD,
            String ho, String ten, String sdt, String diachi,
            String gt, LocalDate ngaysinh, int doanhSoToiThieu, int doanhSoThucTe) {
        super(maNv, maPB, maL, maHD, ho, ten, sdt, diachi, gt, ngaysinh);
        this.doanhSoToiThieu = doanhSoToiThieu;
        this.doanhSoThucTe = doanhSoThucTe;
    }

    public NhanVienKinhDoanh(NhanVienKinhDoanh nv) {
        super(nv);
        this.doanhSoThucTe = nv.doanhSoThucTe;
        this.doanhSoToiThieu = nv.doanhSoToiThieu;
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Doanh so toi thieu: ");
        doanhSoToiThieu = scan.nextInt();
        System.out.println("Doanh so thuc te: ");
        doanhSoThucTe = scan.nextInt();
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Doanh so toi thieu: " + doanhSoToiThieu);
        System.out.println("Doanh so thuc te: " + doanhSoThucTe);
    }

    public int getDoanhSoToiThieu() {
        return doanhSoToiThieu;
    }

    public void setDoanhSoToiThieu(int doanhSoToiThieu) {
        this.doanhSoToiThieu = doanhSoToiThieu;
    }

    public int getDoanhSoThucTe() {
        return doanhSoThucTe;
    }

    public void setDoanhSoThucTe(int doanhSoThucTe) {
        this.doanhSoThucTe = doanhSoThucTe;
    }
}
