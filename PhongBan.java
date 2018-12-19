package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PhongBan implements NhapXuat {
    
    Scanner scan = new Scanner(System.in);
    private String maPhongBan, tenPhongBan, sdtPhongBan, diaChi;
    
    public PhongBan() {
        maPhongBan = tenPhongBan = sdtPhongBan = diaChi = "";
    }
    
    public PhongBan(String ma, String ten, String sdt, String dc) {
        maPhongBan = ma;
        tenPhongBan = ten;
        sdtPhongBan = sdt;
        diaChi = dc;
    }
    
    public PhongBan(PhongBan p) {
        maPhongBan = p.maPhongBan;
        tenPhongBan = p.tenPhongBan;
        sdtPhongBan = p.sdtPhongBan;
        diaChi = p.diaChi;
    }
    
    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF(maPhongBan);
        fileOut.writeUTF(tenPhongBan);
        fileOut.writeUTF(sdtPhongBan);
        fileOut.writeUTF(diaChi);
    }
    
    public void docFile(DataInputStream fileIn) throws IOException {
        maPhongBan = fileIn.readUTF();
        tenPhongBan = fileIn.readUTF();
        sdtPhongBan = fileIn.readUTF();
        diaChi = fileIn.readUTF();
    }
    
    @Override
    public void nhap() {
        nhapMa();
        nhapThongTin();
    }
    
    public void nhapMa() {
        Boolean valid;
        do {
            System.out.print("Ma phong ban: ");
            maPhongBan = scan.nextLine();
            valid = !CheckValidation.checkTrungMa_PhongBan(maPhongBan);
            if(!valid) System.err.println("Trung ma! Vui long nhap lai.");
            
        } while (maPhongBan.trim().equals("") || !valid);
    }
    
    public void nhapThongTin() {
        do {
            System.out.print("Ten: ");
            tenPhongBan = MyString.toUpperCaseFirstLetter(scan.nextLine());
        } while (tenPhongBan.trim().equals(""));
        
        do {
            System.out.print("So dien thoai (10 chu so): ");
            sdtPhongBan = scan.nextLine();
        } while (sdtPhongBan.trim().equals("") || !CheckValidation.isPhoneValid(sdtPhongBan));
        
        do {
            System.out.print("Dia chi: ");
            diaChi = scan.nextLine();
        } while (diaChi.trim().equals(""));
    }
    
    @Override
    public void xuat() {
        System.out.println("Ma phong ban: " + maPhongBan);
        System.out.println("Ten phong ban: " + tenPhongBan);
        System.out.println("So dien thoai: " + sdtPhongBan);
        System.out.println("Dia chi: " + diaChi);
    }
    
    public NhanVien[] getDanhSachNhanVien() {
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docFile(Menu.FILE_DANHSACHNHANVIEN);
        
        return dsnv.timKiemTheoPhongBan(this.maPhongBan);
    }
    
    public String getMaPhongBan() {
        return maPhongBan;
    }
    
    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }
    
    public String getTenPhongBan() {
        return tenPhongBan;
    }
    
    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }
    
    public String getSdtPhongBan() {
        return sdtPhongBan;
    }
    
    public void setSdtPhongBan(String sdtPhongBan) {
        this.sdtPhongBan = sdtPhongBan;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
