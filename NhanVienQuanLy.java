package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NhanVienQuanLy extends NhanVien {

    private String chucVu;
    private double heSoPhuCapChucVu;

    public NhanVienQuanLy() {
        super();
    }

    public NhanVienQuanLy(String maNv, String maPB,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam, String maCv, double hsChucVu) {
        super(maNv, maPB, ho, ten, gt, sdt, diachi, ngaysinh, ngayvaolam);
        chucVu = maCv;
        heSoPhuCapChucVu = hsChucVu;
    }

    public NhanVienQuanLy(NhanVienQuanLy nv) {
        super(nv);
        this.chucVu = nv.chucVu;
        this.heSoPhuCapChucVu = nv.heSoPhuCapChucVu;
    }

    @Override
    public double getLuong() {
        return super.getLuong() + (heSoPhuCapChucVu * 2) + phuCapThamNien();
    }

    @Override
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF("quanly"); // ghi loại nhân viên trước, để lúc đọc file sẽ biết đang đoc dữ liệu của nhân viên gì
        super.ghiFile(fileOut);
        fileOut.writeUTF(chucVu);
        fileOut.writeDouble(heSoPhuCapChucVu);
    }

    @Override
    public void docFile(DataInputStream fileIn) throws IOException {
        super.docFile(fileIn);
        chucVu = fileIn.readUTF();
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
        
        Boolean valid;
        do {
            System.out.print("Nhap ten chuc vu: ");
            chucVu = scan.nextLine();
            valid = checkChucVu(chucVu);
            if(!valid) {
                System.err.println("Ten chuc vu khong hop le!");
                System.out.println("(Giam doc, Pho giam doc, Truong phong, Pho phong)");
            }
        } while(!valid);
        
        System.out.print("He so phu cap chuc vu: ");
        heSoPhuCapChucVu = scan.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuc vu: " + chucVu);
        System.out.println("He so phu cap chuc vu: " + heSoPhuCapChucVu);
    }
    
    public static Boolean checkChucVu(String cv) {
        String[] chucvu = {"Giam doc", "Pho giam doc", "Truong phong", "Pho phong"};
        
        for(String c : chucvu) {
            if(cv.equalsIgnoreCase(c)) return true;
        }
        
        return false;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getHeSoPhuCapChucVu() {
        return heSoPhuCapChucVu;
    }

    public void setHeSoPhuCapChucVu(double heSoPhuCapChucVu) {
        this.heSoPhuCapChucVu = heSoPhuCapChucVu;
    }
}
