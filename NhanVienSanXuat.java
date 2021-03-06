package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NhanVienSanXuat extends NhanVien {

    private static final double PHUCAPNANGNHOC = 0.1;
    private int soNgayNghi;

    public NhanVienSanXuat() {
        super();
        soNgayNghi = 0;
    }

    public NhanVienSanXuat(String maNv, String maPB,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam, int songaynghi) {
        super(maNv, maPB, ho, ten, gt, sdt, diachi, ngaysinh, ngayvaolam);
        this.soNgayNghi = songaynghi;
    }

    public NhanVienSanXuat(NhanVienSanXuat nv) {
        super(nv);
        this.soNgayNghi = nv.soNgayNghi;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }
    
    @Override
    public char xepLoai() {
        if(soNgayNghi <= 1) return 'A';
        if(soNgayNghi <= 3) return 'B';
        if(soNgayNghi <= 5) return 'C';
        return 'D';
    }
    
    @Override
    public double getLuong() {
        return super.getLuong()*(1+PHUCAPNANGNHOC)*giaTriXepLoai(xepLoai()) + phuCapThamNien();
    }
    
    @Override
    public void nhapMa() {
        Boolean valid;
        
        String maNV;
        do {
            System.out.print("Ma nhan vien: sx");
            maNV = scan.nextLine();
            valid = !CheckValidation.checkTrungMa_NhanVien(maNV);
            if (!valid) {
                System.err.println("Ma nhan vien bi trung! Vui long nhap lai.");
            } else {
                setMaNhanVien("sx"+maNV);
            }
        } while (maNV.trim().equals("") || !valid);
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("So ngay nghi thang nay: ");
        
        Boolean valid;
        do {
            soNgayNghi = scan.nextInt();
            valid = soNgayNghi > 0 && soNgayNghi < 30;
            if(!valid) {
                System.err.println("So ngay nghi khong phu hop!");
            }
        } while (!valid);
    }
        
    @Override
    public void xuat() {
        super.xuat();
        System.out.format("%-22s: %-50d\n", "So ngay nghi", soNgayNghi);
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("sanxuat"); // ghi loại nhân viên trước, để lúc đọc file sẽ biết đang đoc dữ liệu của nhân viên gì
        super.ghiFile(fileOut);
        fileOut.writeInt(soNgayNghi);
    }

    @Override
    public void docFile(DataInputStream fileIn) throws IOException {
        super.docFile(fileIn);
        soNgayNghi = fileIn.readInt();
    }

    public double getPhuCapNangNhoc() {
        return PHUCAPNANGNHOC;
    }
}
