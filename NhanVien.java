package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class NhanVien implements NhapXuat {

    Scanner scan = new Scanner(System.in);
    private String maNhanVien, maPhongBan, maLuong, maHopDong;
    private String ho, ten, soDienThoai, diaChi;
    private Boolean gioiTinh;
    private int ngaySinh, thangSinh, namSinh;

    public NhanVien() {
        maNhanVien = maPhongBan = maLuong = maHopDong = "";
        ho = ten = soDienThoai = diaChi = "";
        gioiTinh = true;
        ngaySinh = thangSinh = 1;
        namSinh = 1999;
    }

    public NhanVien(String maNhanVien, String maPB, String maL, String maHD,
            String ho, String ten, String gt, String sdt, String diachi,
            int ngaysinh, int thangsinh, int namsinh) {
        this.maNhanVien = maNhanVien;
        this.maPhongBan = maPB;
        this.maLuong = maL;
        this.maHopDong = maHD;
        this.ho = MyString.toUpperCaseFirstLetter_AllWord(ho);
        this.ten = MyString.toUpperCaseFirstLetter(ten);
        this.soDienThoai = sdt;
        this.diaChi = diachi;
        this.gioiTinh = gt.equalsIgnoreCase("nam");
        this.ngaySinh = ngaysinh;
        this.thangSinh = thangsinh;
        this.namSinh = namsinh;
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
        this.thangSinh = nv.thangSinh;
        this.namSinh = nv.namSinh;
    }

    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF(maNhanVien);
        fileOut.writeUTF(maPhongBan);
        fileOut.writeUTF(maLuong);
        fileOut.writeUTF(maHopDong);
        fileOut.writeUTF(ho);
        fileOut.writeUTF(ten);
        fileOut.writeUTF(soDienThoai);
        fileOut.writeUTF(diaChi);
        fileOut.writeBoolean(gioiTinh);
        fileOut.writeInt(ngaySinh);
        fileOut.writeInt(thangSinh);
        fileOut.writeInt(namSinh);
    }

    public void docFile(DataInputStream fileIn) throws IOException {
        maNhanVien = fileIn.readUTF();
        maPhongBan = fileIn.readUTF();
        maLuong = fileIn.readUTF();
        maHopDong = fileIn.readUTF();
        ho = fileIn.readUTF();
        ten = fileIn.readUTF();
        soDienThoai = fileIn.readUTF();
        diaChi = fileIn.readUTF();
        gioiTinh = fileIn.readBoolean();
        ngaySinh = fileIn.readInt();
        thangSinh = fileIn.readInt();
        namSinh = fileIn.readInt();
    }

    @Override
    public void nhap() {
        this.nhapMa();
        this.nhapThongTin();
    }

    public void nhapMa() {
        System.out.print("Ma nhan vien: ");
        maNhanVien = scan.nextLine();
        System.out.print("Ma phong ban: ");
        maPhongBan = scan.nextLine();
        System.out.print("Ma luong : ");
        maLuong = scan.nextLine();
        System.out.print("Ma hop dong: ");
        maHopDong = scan.nextLine();
    }

    public void nhapThongTin() {
        do {
            System.out.print("Ho: ");
            ho = MyString.toUpperCaseFirstLetter_AllWord(scan.nextLine());
        } while (ho.trim().equals(""));
        do {
            System.out.print("Ten: ");
            ten = MyString.toUpperCaseFirstLetter(scan.nextLine());
        } while (ten.trim().equals(""));

        System.out.print("Gioi tinh (nam/nu): ");
        gioiTinh = scan.nextLine().equalsIgnoreCase("nam");

        nhapNgaySinh();
        scan.nextLine();
        
        do {
            System.out.print("So dien thoai (10 chu so): ");
            soDienThoai = scan.nextLine();

        } while (soDienThoai.trim().equals("") || !CheckValidation.isPhoneValid(soDienThoai));

        do {
            System.out.print("Dia chi: ");
            diaChi = scan.nextLine();
        } while (diaChi.trim().equals(""));

    }

    public void nhapNgaySinh() {
        Boolean validation;
        do {
            System.out.print("Ngay-Thang-Nam sinh:\n ");
            System.out.print("\tNgay sinh: ");
            ngaySinh = scan.nextInt();
            System.out.print("\tThang sinh: ");
            thangSinh = scan.nextInt();
            System.out.print("\tNam sinh: ");
            namSinh = scan.nextInt();

            validation = CheckValidation.isDateValid(CheckValidation.formatDate_NumToString(ngaySinh, thangSinh, namSinh));
            if (!validation) {
                System.err.println("Ngay-thang-nam khong hop le! Vui long nhap lai.");
            }

        } while (!validation);
    }

    @Override
    public void xuat() {
        this.xuatMa();
        this.xuatThongtin();
    }

    public void xuatMa() {
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ma phong ban: " + maPhongBan);
        System.out.println("Ma luong: " + maLuong);
        System.out.println("Ma hop dong: " + maHopDong);
    }

    public void xuatThongtin() {
        System.out.println("Ho va ten: " + ho + " " + ten);
        System.out.println("Gioi tinh: " + (gioiTinh ? "Nam" : "Nu"));
        System.out.println("Ngay sinh: " + ngaySinh + "/" + thangSinh + "/" + namSinh);
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
        return gioiTinh ? "Nam" : "Nu";
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh.equalsIgnoreCase("nam");
    }

    public int getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(int ngaysinh) {
        this.ngaySinh = ngaysinh;
    }

    public int getThangSinh() {
        return thangSinh;
    }

    public void setThangSinh(int thangSinh) {
        this.thangSinh = thangSinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
