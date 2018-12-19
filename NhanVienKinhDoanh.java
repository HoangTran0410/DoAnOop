package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NhanVienKinhDoanh extends NhanVien {

    private double doanhSoToiThieu, doanhSoThucTe;

    public NhanVienKinhDoanh() {
        super();
    }

    public NhanVienKinhDoanh(String maNv, String maPB,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam, double doanhSoToiThieu, double doanhSoThucTe) {
        super(maNv, maPB, ho, ten, gt, sdt, diachi, ngaysinh, ngayvaolam);
        this.doanhSoToiThieu = doanhSoToiThieu;
        this.doanhSoThucTe = doanhSoThucTe;
    }

    public NhanVienKinhDoanh(NhanVienKinhDoanh nv) {
        super(nv);
        this.doanhSoThucTe = nv.doanhSoThucTe;
        this.doanhSoToiThieu = nv.doanhSoToiThieu;
    }

    @Override
    public char xepLoai() {
        if (doanhSoThucTe >= doanhSoToiThieu * 2) {
            return 'A';
        }
        if (doanhSoThucTe < doanhSoToiThieu * .5) {
            return 'D';
        }
        if (doanhSoThucTe < doanhSoToiThieu) {
            return 'C';
        }
        return 'B';
    }

    public double hoaHong() {
        double hh = 0.15 * (doanhSoThucTe - doanhSoToiThieu);
        return (hh > 0 ? hh : 0);
    }

    @Override
    public double getLuong() {
        return super.getLuong() + hoaHong();
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("kinhdoanh"); // ghi loại nhân viên trước, để lúc đọc file sẽ biết đang đoc dữ liệu của nhân viên gì
        super.ghiFile(fileOut);
        fileOut.writeDouble(doanhSoToiThieu);
        fileOut.writeDouble(doanhSoThucTe);
    }

    @Override
    public void docFile(DataInputStream fileIn) throws IOException {
        super.docFile(fileIn);
        doanhSoToiThieu = fileIn.readDouble();
        doanhSoThucTe = fileIn.readDouble();
    }

    @Override
    public void nhapMa() {
        Boolean valid;
        
        String maNV;
        do {
            System.out.print("Ma nhan vien: kd");
            maNV = scan.nextLine();
            valid = !CheckValidation.checkTrungMa_NhanVien(maNV);
            if (!valid) {
                System.err.println("Ma nhan vien bi trung! Vui long nhap lai.");
            } else {
                setMaNhanVien("kd"+maNV);
            }
        } while (maNV.trim().equals("") || !valid);
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Doanh so toi thieu: ");
        doanhSoToiThieu = scan.nextDouble();
        System.out.print("Doanh so thuc te: ");
        doanhSoThucTe = scan.nextDouble();
    }

    @Override
    public void xuatThongtin() {
        super.xuatThongtin();
        System.out.println("Doanh so toi thieu: " + doanhSoToiThieu);
        System.out.println("Doanh so thuc te: " + doanhSoThucTe);
    }

    public double getDoanhSoToiThieu() {
        return doanhSoToiThieu;
    }

    public void setDoanhSoToiThieu(double doanhSoToiThieu) {
        this.doanhSoToiThieu = doanhSoToiThieu;
    }

    public double getDoanhSoThucTe() {
        return doanhSoThucTe;
    }

    public void setDoanhSoThucTe(double doanhSoThucTe) {
        this.doanhSoThucTe = doanhSoThucTe;
    }
}
