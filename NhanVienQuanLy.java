package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NhanVienQuanLy extends NhanVien {

    private String maChucVu;
    private double heSoPhuCapChucVu;

    public NhanVienQuanLy() {
        super();
    }

    public NhanVienQuanLy(String maNv, String maPB, String maHD,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam, String maCv, double hsChucVu) {
        super(maNv, maPB, maHD, ho, ten, gt, sdt, diachi, ngaysinh, ngayvaolam);
        maChucVu = maCv;
        heSoPhuCapChucVu = hsChucVu;
    }

    public NhanVienQuanLy(NhanVienQuanLy nv) {
        super(nv);
        this.maChucVu = nv.maChucVu;
        this.heSoPhuCapChucVu = nv.heSoPhuCapChucVu;
    }
    
    @Override
    public double getLuong() {
        return super.getLuong()+(heSoPhuCapChucVu*2)+phuCapThamNien();
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("quanly"); // ghi loại nhân viên trước, để lúc đọc file sẽ biết đang đoc dữ liệu của nhân viên gì
        super.ghiFile(fileOut);
        fileOut.writeUTF(maChucVu);
        fileOut.writeDouble(heSoPhuCapChucVu);
    }

    @Override
    public void docFile(DataInputStream fileIn) throws IOException {
        super.docFile(fileIn);
        maChucVu = fileIn.readUTF();
        heSoPhuCapChucVu = fileIn.readDouble();
    }

    @Override
    public void nhap() {
        super.nhapMa();
        nhapThongTin();
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
    public void xuat() {
        super.xuat();
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
