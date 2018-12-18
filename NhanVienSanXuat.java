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

    public NhanVienSanXuat(String maNv, String maPB, String maHD,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam, int songaynghi) {
        super(maNv, maPB, maHD, ho, ten, gt, sdt, diachi, ngaysinh, ngayvaolam);
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
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("So ngay nghi: ");
        soNgayNghi = scan.nextInt();
    }
    
    @Override
    public void nhap() {
        super.nhapMa();
        nhapThongTin();
    }
        
    public void xuatThongTin() {
        super.xuatThongtin();
        System.out.print("So ngay nghi: " + soNgayNghi);
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
