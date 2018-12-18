package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NhanVien implements NhapXuat {

    Scanner scan = new Scanner(System.in);
    private String maNhanVien, maPhongBan, maLuong;
    private String ho, ten, soDienThoai, diaChi;
    private Boolean gioiTinh;
    private MyDate ngaySinh, ngayVaoLam;

    public NhanVien() {
        maNhanVien = maPhongBan = maLuong = "";
        ho = ten = soDienThoai = diaChi = "";
        gioiTinh = true;
        ngaySinh = new MyDate();
        ngayVaoLam = new MyDate();
    }

    public int tinhThamNien() {
        MyDate ngayHienTai = new MyDate(new Date());
        return ngayVaoLam.khoangCach(ngayHienTai);
    }

    public NhanVien(String maNhanVien, String maPB, String maL, String maHD,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam) {
        this.maNhanVien = maNhanVien;
        this.maPhongBan = maPB;
        this.maLuong = maL;
        this.ho = MyString.toUpperCaseFirstLetter_AllWord(ho);
        this.ten = MyString.toUpperCaseFirstLetter(ten);
        this.soDienThoai = sdt;
        this.diaChi = diachi;
        this.gioiTinh = gt.equalsIgnoreCase("nam");
        this.ngaySinh = ngaysinh;
        this.ngayVaoLam = ngayvaolam;
    }

    public NhanVien(NhanVien nv) {
        this.maNhanVien = nv.maNhanVien;
        this.maPhongBan = nv.maPhongBan;
        this.maLuong = nv.maLuong;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.soDienThoai = nv.soDienThoai;
        this.diaChi = nv.diaChi;
        this.gioiTinh = nv.gioiTinh;
        this.ngaySinh = nv.ngaySinh;
        this.ngayVaoLam = nv.ngayVaoLam;
    }

    public void ghiFile(DataOutputStream fileOut) throws IOException {
        fileOut.writeUTF(maNhanVien);
        fileOut.writeUTF(maPhongBan);
        fileOut.writeUTF(maLuong);
        fileOut.writeUTF(ho);
        fileOut.writeUTF(ten);
        fileOut.writeUTF(soDienThoai);
        fileOut.writeUTF(diaChi);
        fileOut.writeBoolean(gioiTinh);
        fileOut.writeInt(ngaySinh.getNgay());
        fileOut.writeInt(ngaySinh.getThang());
        fileOut.writeInt(ngaySinh.getNam());
        fileOut.writeInt(ngayVaoLam.getNgay());
        fileOut.writeInt(ngayVaoLam.getThang());
        fileOut.writeInt(ngayVaoLam.getNam());
    }

    public void docFile(DataInputStream fileIn) throws IOException {
        maNhanVien = fileIn.readUTF();
        maPhongBan = fileIn.readUTF();
        maLuong = fileIn.readUTF();
        ho = fileIn.readUTF();
        ten = fileIn.readUTF();
        soDienThoai = fileIn.readUTF();
        diaChi = fileIn.readUTF();
        gioiTinh = fileIn.readBoolean();

        int ngay = fileIn.readInt();
        int thang = fileIn.readInt();
        int nam = fileIn.readInt();
        ngaySinh = new MyDate(ngay, thang, nam);

        ngay = fileIn.readInt();
        thang = fileIn.readInt();
        nam = fileIn.readInt();
        ngayVaoLam = new MyDate(ngay, thang, nam);
    }

    @Override
    public void nhap() {
        this.nhapMa();
        this.nhapThongTin();
    }

    public void nhapMa() {
        Boolean valid;
        do {
            System.out.print("Ma nhan vien: ");
            maNhanVien = scan.nextLine();
            valid = !CheckValidation.checkTrungMa_NhanVien(maNhanVien);
            if(!valid) System.err.println("Ma nhan vien bi trung! Vui long nhap lai.");
        } while (maNhanVien.trim().equals("") || !valid);

        do {
            System.out.print("Ma phong ban: ");
            maPhongBan = scan.nextLine();
            valid = CheckValidation.checkTrungMa_PhongBan(maPhongBan);
            if(!valid) System.err.println("Khong ton tai phong ban co ma nay! Vui long nhap lai.");
        } while (maPhongBan.trim().equals("") || !valid);

        do {
            System.out.print("Ma luong: ");
            maLuong = scan.nextLine();
        } while (maLuong.trim().equals(""));
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

        String gtNhap;
        do {
            System.out.print("Gioi tinh (nam/nu): ");
            gtNhap = scan.nextLine();
            gioiTinh = gtNhap.equalsIgnoreCase("nam");

        } while (!CheckValidation.isSexValid(gtNhap));

        nhapNgaySinh();
        scan.nextLine();

        nhapNgayVaoLam();
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
            try {
                System.out.print("Ngay-Thang-Nam sinh:\n ");
                System.out.print("\tNgay sinh: ");
                int ngay = scan.nextInt();
                System.out.print("\tThang sinh: ");
                int thang = scan.nextInt();
                System.out.print("\tNam sinh: ");
                int nam = scan.nextInt();

                validation = CheckValidation.isDateValid(CheckValidation.formatDate_NumToString(ngay, thang, nam));
                if (validation) {
                    MyDate now = new MyDate();
                    if(now.isBefore(new MyDate(ngay, thang, nam))) {
                        validation = false;
                        System.err.println("Ngay nhap vao lon hon ngay hien tai!");
                        
                    } else if(new MyDate(ngay, thang, nam).khoangCach(now) <= 18) {
                        validation = false;
                        System.err.println("Nhan vien duoi 18 tuoi!!");
                        
                    } else ngaySinh = new MyDate(ngay, thang, nam);
                } else {
                    System.err.println("Ngay-thang-nam khong hop le! Vui long nhap lai.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Gia tri phai la so!");
                scan.nextLine();
                validation = false;
            }

        } while (!validation);
    }

    public void nhapNgayVaoLam() {
        Boolean validation;
        do {
            try {
                System.out.print("Ngay-Thang-Nam vao lam:\n ");
                System.out.print("\tNgay: ");
                int ngay = scan.nextInt();
                System.out.print("\tThang: ");
                int thang = scan.nextInt();
                System.out.print("\tNam: ");
                int nam = scan.nextInt();

                validation = CheckValidation.isDateValid(CheckValidation.formatDate_NumToString(ngay, thang, nam));
                if (validation) {
                    MyDate now = new MyDate();
                    if(now.isBefore(new MyDate(ngay, thang, nam))) {
                        validation = false;
                        System.err.println("Ngay nhap vao lon hon ngay hien tai!");
                        
                    } else ngayVaoLam = new MyDate(ngay, thang, nam);
                    
                } else {
                    System.err.println("Ngay-thang-nam khong hop le! Vui long nhap lai.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Gia tri phai la so!");
                scan.nextLine();
                validation = false;
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
    }

    public void xuatThongtin() {
        System.out.println("Ho va ten: " + ho + " " + ten);
        System.out.println("Gioi tinh: " + (gioiTinh ? "Nam" : "Nu"));
        System.out.println("Ngay sinh: " + ngaySinh.getNgay() + "/" + ngaySinh.getThang() + "/" + ngaySinh.getNam());
        System.out.println("So dien thoai: " + soDienThoai);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Ngay vao lam: " + ngayVaoLam.getNgay() + "/" + ngayVaoLam.getThang() + "/" + ngayVaoLam.getNam());
    }

    public String loaiNhanVien() {
        if (this instanceof NhanVienSanXuat) {
            return "Nhan Vien San Xuat";
        }
        if (this instanceof NhanVienQuanLy) {
            return "Nhan Vien Quan Ly";
        }
        if (this instanceof NhanVienKinhDoanh) {
            return "Nhan Vien Kinh Doanh";
        }
        return "";
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

    public MyDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(MyDate t) {
        this.ngaySinh = t;
    }

    public void setNgaySinh(int ngay, int thang, int nam) {
        this.ngaySinh = new MyDate(ngay, thang, nam);
    }

    public MyDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(int ngay, int thang, int nam) {
        this.ngayVaoLam = new MyDate(ngay, thang, nam);
    }

    public void setNgayVaoLam(MyDate t) {
        this.ngayVaoLam = t;
    }
}
