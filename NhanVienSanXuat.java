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

    public NhanVienSanXuat(String maNv, String maPB, String maL, String maHD,
            String ho, String ten, String gt , String sdt, String diachi,
            int ngaysinh, int thangsinh, int namsinh, int songaynghi) {
        super(maNv, maPB, maL, maHD, ho, ten, gt, sdt, diachi, ngaysinh, thangsinh, namsinh);
        this.soNgayNghi = songaynghi;
    }

    public NhanVienSanXuat(NhanVien nv) {
        super(nv);
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("sanxuat");
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
