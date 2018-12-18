package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NhanVienKinhDoanh extends NhanVien {

    private int doanhSoToiThieu, doanhSoThucTe;

    public NhanVienKinhDoanh() {
        super();
    }

    public NhanVienKinhDoanh(String maNv, String maPB, String maL, String maHD,
            String ho, String ten, String gt, String sdt, String diachi,
            int ngaysinh, int thangsinh, int namsinh, int doanhSoToiThieu, int doanhSoThucTe) {
        super(maNv, maPB, maL, maHD, ho, ten, gt, sdt, diachi, ngaysinh, thangsinh, namsinh);
        this.doanhSoToiThieu = doanhSoToiThieu;
        this.doanhSoThucTe = doanhSoThucTe;
    }

    public NhanVienKinhDoanh(NhanVienKinhDoanh nv) {
        super(nv);
        this.doanhSoThucTe = nv.doanhSoThucTe;
        this.doanhSoToiThieu = nv.doanhSoToiThieu;
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("kinhdoanh"); // ghi loại nhân viên trước, để lúc đọc file sẽ biết đang đoc dữ liệu của nhân viên gì
        super.ghiFile(fileOut);
        fileOut.writeInt(doanhSoToiThieu);
        fileOut.writeInt(doanhSoThucTe);
    }

    @Override
    public void docFile(DataInputStream fileIn) throws IOException {
        super.docFile(fileIn);
        doanhSoToiThieu = fileIn.readInt();
        doanhSoThucTe = fileIn.readInt();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Doanh so toi thieu: ");
        doanhSoToiThieu = scan.nextInt();
        System.out.print("Doanh so thuc te: ");
        doanhSoThucTe = scan.nextInt();
    }
    
    @Override
    public void nhap() {
        super.nhapMa();
        nhapThongTin();
    }

    @Override
    public void xuat() {
        super.xuat();
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
