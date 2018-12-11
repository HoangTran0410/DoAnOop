package DoAnOop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NhanVien {

    Scanner scan = new Scanner(System.in);
    private String maNhanVien, maPhongBan, maLuong, maHopDong;
    private String ho, ten, soDienThoai, diaChi;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;

    public NhanVien() {
        maNhanVien = maPhongBan = maLuong = maHopDong = "";
        ho = ten = soDienThoai = diaChi = "";
        gioiTinh = true;
        ngaySinh = LocalDate.now();
    }
    public NhanVien(String maNhanVien, String maPB, String maL, String maHD,
            String ho, String ten, String sdt, String diachi,
            String gt, LocalDate ngaysinh) {
        this.maNhanVien = maNhanVien;
        this.maPhongBan = maPB;
        this.maLuong = maL;
        this.maHopDong = maHD;
        this.ho = ho;
        this.ten = ten;
        this.soDienThoai = sdt;
        this.diaChi = diachi;
        this.gioiTinh = gt.equalsIgnoreCase("nam");
        this.ngaySinh = ngaysinh;
    }
    public NhanVien(NhanVien nv) {
        this.maNhanVien = nv.maNhanVien;
        this.maPhongBan = nv.maPhongBan;
        this.maLuong = nv.maLuong;
        this.maHopDong = nv.maHopDong;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.soDienThoai = nv.soDienThoai;
        this.diaChi = nv.diaChi;
        this.gioiTinh = nv.gioiTinh;
        this.ngaySinh = nv.ngaySinh;
    }

    public void nhapThongTin() {
        System.out.print("Ma nhan vien: ");
        maNhanVien = scan.nextLine();
        System.out.print("Ma phong ban: ");
        maPhongBan = scan.nextLine();
        System.out.print("Ma luong : ");
        maLuong = scan.nextLine();
        System.out.print("Ma hop dong: ");
        maHopDong = scan.nextLine();
        System.out.print("Ho: ");
        ho = scan.nextLine();
        System.out.print("Ten: ");
        ten = scan.nextLine();
        System.out.print("Gioi tinh (nam/nu): ");
        gioiTinh = scan.nextLine().equalsIgnoreCase("nam");
        
        nhapNgaySinh();
        scan.nextLine();

        System.out.print("So dien thoai: ");
        soDienThoai = scan.nextLine();
        System.out.print("Dia chi: ");
        diaChi = scan.nextLine();
    }
    public void xuatThongTin() {
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ma phong ban: " + maPhongBan);
        System.out.println("Ma luong: " + maLuong);
        System.out.println("Ma hop dong: " + maHopDong);
        System.out.println("Ho va ten: " + ho + " " + ten);
        System.out.println("Gioi tinh: " + (gioiTinh ? "nam" : "nu"));
        System.out.println("Ngay sinh: " + ngaySinh.format(DateTimeFormatter.ofPattern("dd MM YY")));
        System.out.println("So dien thoai: " + soDienThoai);
        System.out.println("Dia chi: " + diaChi);
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }
    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getMaLuong() {
        return maLuong;
    }
    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaHopDong() {
        return maHopDong;
    }
    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getHo() {
        return ho;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh ? "nam" : "nu";
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh.equalsIgnoreCase("nam");
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setNgaySinh() {
        nhapNgaySinh();
    }
    
    public void nhapNgaySinh() {
        System.out.print("Ngay Thang Nam sinh:\n ");
        System.out.print("  Ngay sinh: ");
        int n = scan.nextInt();
        System.out.print("  Thang sinh: ");
        int t = scan.nextInt();
        System.out.print("  Nam sinh: ");
        int nam = scan.nextInt();
        ngaySinh = LocalDate.of(nam, t, n);
    }
}
