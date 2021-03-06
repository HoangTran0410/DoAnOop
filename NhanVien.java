package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NhanVien implements NhapXuat {

    Scanner scan = new Scanner(System.in);
    private String maNhanVien, maPhongBan;
    private String ho, ten, soDienThoai, diaChi;
    private Boolean gioiTinh;
    private MyDate ngaySinh, ngayVaoLam;

    static final double[] HE_SO_LUONG_LIST = {0, 2.34, 2.67, 3.0, 3.33, 3.66, 3.99, 4.32, 4.65};
    private final double LUONG_CO_BAN = 1.4;

    public NhanVien() {
        maNhanVien = maPhongBan = "";
        ho = ten = soDienThoai = diaChi = "";
        gioiTinh = true;
        ngaySinh = new MyDate();
        ngayVaoLam = new MyDate();
    }

    //    Luong
    public int thamNienLamViec() {
        MyDate ngayHienTai = new MyDate(new Date());
        return ngayVaoLam.khoangCach(ngayHienTai);
    }

    public int getBacLuong() {
        int thamnien = thamNienLamViec();
        int bac = 1;
        for (int i = 2; i < thamnien; i += 2) {
            if (bac < 7) {
                bac++;
            } else {
                break;
            }
        }

        return bac;
    }

    public double phuCapThamNien() {
        int thamnien = thamNienLamViec();
        if (thamnien <= 3) {
            return 1;
        }
        if (thamnien <= 6) {
            return 2;
        }
        if (thamnien <= 10) {
            return 4;
        }
        return (5 + (thamnien - 11) * .5);
    }

    public char xepLoai() {
        return 'A';
    }

    public double giaTriXepLoai(char xl) {
        switch (xl) {
            case 'A':
                return 1;
            case 'B':
                return .75;
            case 'C':
                return .5;
            case 'D':
                return 0;
            default:
                return 0;
        }
    }

    public double getLuong() {
        return LUONG_CO_BAN * HE_SO_LUONG_LIST[getBacLuong()];
    }
    //    End luong
    
    
    public NhanVien(String maNhanVien, String maPB,
            String ho, String ten, String gt, String sdt, String diachi,
            MyDate ngaysinh, MyDate ngayvaolam) {
        this.maNhanVien = maNhanVien;
        this.maPhongBan = maPB;
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
            if (!valid) {
                System.err.println("Ma nhan vien bi trung! Vui long nhap lai.");
            }
        } while (maNhanVien.trim().equals("") || !valid);
    }

    public void nhapThongTin() {
        Boolean valid;
        do {
            System.out.print("Ma phong ban: ");
            maPhongBan = scan.nextLine();
            valid = CheckValidation.checkTrungMa_PhongBan(maPhongBan);
            if (!valid) {
                System.err.println("Khong ton tai phong ban co ma nay! Vui long nhap lai.");
            }
        } while (maPhongBan.trim().equals("") || !valid);

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
                    MyDate nhapVao = new MyDate(ngay, thang, nam);
                    int soTuoi = nhapVao.khoangCach(now);

                    if (nhapVao.lonHon(now)) {
                        validation = false;
                        System.err.print("Ngay nhap vao lon hon ngay hien tai! " + nhapVao.toString() + " > " + now.toString());

                    } else if (soTuoi <= 18) {
                        validation = false;
                        System.err.println("Nhan vien duoi 18 tuoi!! (" + soTuoi + ")");

                    } else {
                        ngaySinh = new MyDate(ngay, thang, nam);
                    }
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
                    MyDate nhapVao = new MyDate(ngay, thang, nam);

                    if (nhapVao.lonHon(now)) {
                        validation = false;
                        System.err.println("Ngay nhap vao lon hon ngay hien tai!");

                    } else if (nhapVao.nhoHon(ngaySinh)) {
                        validation = false;
                        System.err.println("Ngay vao lam khong phu hop (< ngaysinh)");

                    } else if (ngaySinh.khoangCach(nhapVao) < 18) {
                        validation = false;
                        System.err.println("KHONG HOP LE! Nhan vien khong the vao lam khi chua du 18 tuoi!");

                    } else {
                        ngayVaoLam = new MyDate(ngay, thang, nam);
                    }

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

    public void xuatInline() {
        System.out.format("| %-6s | %-15s %-10s | %10s | %11s | %12s | %25s | %10.3f |\n",
                maNhanVien,
                ho,
                ten,
                getGioiTinh(),
                ngaySinh.getNgay() + "/" + ngaySinh.getThang() + "/" + ngaySinh.getNam(),
                soDienThoai,
                diaChi,
                getLuong());
    }

    @Override
    public void xuat() {
        this.xuatMa();
        this.xuatThongtin();
    }

    public void xuatMa() {
        System.out.format("%-22s: %-50s\n", "Ma nhan vien", maNhanVien);
        System.out.format("%-22s: %-50s\n", "Ma phong ban", maPhongBan);
    }

    public void xuatThongtin() {
        System.out.format("%-22s: %-50s\n", "Ho va ten", ho + " " + ten + ".");
        System.out.format("%-22s: %-50s\n", "Gioi tinh", (gioiTinh ? "Nam" : "Nu") + ".");
        System.out.format("%-22s: %-50s\n", "Ngay sinh", ngaySinh.getNgay() + "/" + ngaySinh.getThang() + "/" + ngaySinh.getNam() + ".");
        System.out.format("%-22s: %-50s\n", "Ngay vao lam", ngayVaoLam.getNgay() + "/" + ngayVaoLam.getThang() + "/" + ngayVaoLam.getNam() + ".");
        System.out.format("%-22s: %-50s\n", "Tham nien lam viec", thamNienLamViec() + " nam.");
        System.out.format("%-22s: %-50s\n", "So dien thoai", soDienThoai + ".");
        System.out.format("%-22s: %-50s\n", "Dia chi", diaChi + ".");
        System.out.format("%-22s: %-50s\n", "Bac luong hien tai", getBacLuong() + ".");
        System.out.format("%-22s: %-50s\n", "Xep loai thang nay", xepLoai() + ".");
        System.out.format("%-22s: %-50.3f\n", "Luong thang hien tai", getLuong());
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
