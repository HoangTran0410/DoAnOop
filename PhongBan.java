
package DoAnOop;

import java.util.Scanner;

public class PhongBan {
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
    
    public void nhapThongTin() {
        System.out.print("Ma phong ban: ");
        maPhongBan = scan.nextLine();
        System.out.print("Ten phong ban: ");
        tenPhongBan = scan.nextLine();
        System.out.println("So dien thoai: ");
        sdtPhongBan = scan.nextLine();
        System.out.println("Dia chi: ");
        diaChi = scan.nextLine();
    }
    
    public void xuatThongTin() {
        System.out.println("Ma phong ban: " + maPhongBan);
        System.out.println("Ten phong ban: " + tenPhongBan);
        System.out.println("So dien thoai: " + sdtPhongBan);
        System.out.println("Dia chi: " + diaChi);
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
