package DoAnOop;

import java.util.Arrays;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachNhanVien implements DanhSach, File {

    Scanner scan = new Scanner(System.in);

    private NhanVien[] dsnv;

    public DanhSachNhanVien() {
        dsnv = new NhanVien[0];
    }

    public DanhSachNhanVien(NhanVien[] dsnv) {
        this.dsnv = dsnv;
    }

    public DanhSachNhanVien(DanhSachNhanVien ds) {
        this.dsnv = ds.dsnv.clone();
    }

    @Override
    public void ghiFile(String tenFile, Boolean ghiThem) throws FileNotFoundException, IOException {
        DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(tenFile, ghiThem));
        try {
            for (NhanVien nv : dsnv) {
                nv.ghiFile(fileOut);
            }
        } finally {
            fileOut.close();
        }
    }

    @Override
    public void ghiThem(String tenFile) throws FileNotFoundException, IOException {
        ghiFile(tenFile, true);
    }

    @Override
    public void ghiDe(String tenFile) throws FileNotFoundException, IOException {
        ghiFile(tenFile, false);
    }

    // https://stackoverflow.com/questions/16945335/java-need-a-while-loop-to-reach-eof-i-e-while-eof-keep-parsing
    @Override
    public void docFile(String tenFile) throws FileNotFoundException, IOException {
        DataInputStream fileIn = new DataInputStream(new FileInputStream(tenFile));
        try {
            dsnv = new NhanVien[0];
            while (fileIn.available() > 0) {
                String loaiNhanVien = fileIn.readUTF();

                if (loaiNhanVien.equalsIgnoreCase("quanly")) {
                    NhanVienQuanLy nv = new NhanVienQuanLy();
                    nv.docFile(fileIn);
                    them(nv);

                } else if (loaiNhanVien.equalsIgnoreCase("kinhdoanh")) {
                    NhanVienKinhDoanh nv = new NhanVienKinhDoanh();
                    nv.docFile(fileIn);
                    them(nv);

                } else if (loaiNhanVien.equalsIgnoreCase("sanxuat")) {
                    NhanVienSanXuat nv = new NhanVienSanXuat();
                    nv.docFile(fileIn);
                    them(nv);
                }
            }
        } finally {
            fileIn.close();
        }
    }

    private NhanVien[] themNhanVien(NhanVien nv, NhanVien[] list) {
        NhanVien[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = nv;
        return temp;
    }

    public void them(NhanVien nv) {
        dsnv = themNhanVien(nv, dsnv);
    }

    public Boolean trungMa(String ma) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNhanVien().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void them() {
        System.out.print("Loai nhan vien muon them (1:quanly/ 2:kinhdoanh/ 3:sanxuat/ 0:quayve): ");
        int loai = scan.nextInt();
        Boolean trung;
        switch (loai) {
            case 0:
                break;
            case 1:
                NhanVienQuanLy nv1 = new NhanVienQuanLy();
                do {
                    System.out.println("Nhap thong tin nhan vien quan ly:");
                    nv1.nhapMa();
                    trung = trungMa(nv1.getMaNhanVien());
                    if (trung) {
                        System.err.println("Ma nhan vien bi trung!! Vui long nhap lai");
                    }
                } while (trung);

                nv1.nhapThongTin();
                them(nv1);
                break;

            case 2:
                NhanVienKinhDoanh nv2 = new NhanVienKinhDoanh();
                do {
                    System.out.println("Nhap thong tin nhan vien kinh doanh:");
                    nv2.nhapMa();
                    trung = trungMa(nv2.getMaNhanVien());
                    if (trung) {
                        System.err.println("Ma nhan vien bi trung!! Vui long nhap lai");
                    }
                } while (trung);

                nv2.nhapThongTin();
                them(nv2);
                break;

            case 3:
                NhanVienSanXuat nv3 = new NhanVienSanXuat();
                do {
                    System.out.println("Nhap thong tin nhan vien san xuat:");
                    nv3.nhapMa();
                    trung = trungMa(nv3.getMaNhanVien());
                    if (trung) {
                        System.err.println("Ma nhan vien bi trung!! Vui long nhap lai");
                    }
                } while (trung);
                nv3.nhapThongTin();
                them(nv3);

                break;
            default:
                System.out.println("Nhap sai lua chon!");
                break;
        }
    }

    @Override
    public void xoaTaiViTri(int index) {
        if (index < dsnv.length) {
            for (int i = index + 1; i < dsnv.length; i++) {
                dsnv[i - 1] = dsnv[i];
            }
            dsnv = Arrays.copyOf(dsnv, dsnv.length - 1);
        }
    }

    @Override
    public void xoaTheoMa(String ma) {
        int c, i;
        for (c = i = 0; i < dsnv.length; i++) {
            if (!dsnv[i].getMaNhanVien().equals(ma)) {
                dsnv[c] = dsnv[i];
                c++;
            }
        }
        // neu tim thay va xoa duoc, thi phai thu nho chieu dai mang lai = c
        if (c < dsnv.length) {
            dsnv = Arrays.copyOf(dsnv, c);
        }
    }

    @Override
    public void suaTheoMa(String ma) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNhanVien().toLowerCase().contains(ma.toLowerCase())) {
                nv.nhap();
            }
        }
    }

    @Override
    public void xuat() {
        // https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
        if (dsnv.length == 0) {
            System.err.println("Khong co nhan vien nao!");
            return;
        }

        System.out.println("   MaNV           Ho va Ten            GioiTinh     NgaySinh     SoDienThoai            Dia Chi");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (NhanVien nv : dsnv) {
            // MaNV | HoTen | GioiTinh | NgaySinh | SoDienThoai
            System.out.format("| %-6s | %-15s %-10s | %10s | %11s | %12s | %25s |\n",
                    nv.getMaNhanVien(),
                    nv.getHo(),
                    nv.getTen(),
                    nv.getGioiTinh(),
                    nv.getNgaySinh().getNgay() + "/" + nv.getNgaySinh().getThang() + "/" + nv.getNgaySinh().getNam(),
                    nv.getSoDienThoai(),
                    nv.getDiaChi());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

    public NhanVien timKiemTheoMa(String ma) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNhanVien().toLowerCase().contains(ma.toLowerCase())) {
                return nv;
            }
        }
        return null;
    }

    public NhanVien[] timKiemTheoTen(String ten) {
        NhanVien[] result = new NhanVien[0];

        for (NhanVien nv : dsnv) {
            if (nv.getTen().toLowerCase().contains(ten.toLowerCase())) {
                result = themNhanVien(nv, result);
            }
        }
        return result;
    }

    public NhanVien[] timKiemTheoPhongBan(String maPB) {
        NhanVien[] result = new NhanVien[0];

        for (NhanVien nv : dsnv) {
            if (nv.getMaPhongBan().toLowerCase().contains(maPB.toLowerCase())) {
                result = themNhanVien(nv, result);
            }
        }
        return result;
    }

    public NhanVien[] timKiemNhanVienSanXuat() {
        NhanVien[] result = new NhanVien[0];

        for (NhanVien nv : dsnv) {
            if (nv instanceof NhanVienSanXuat) {
                result = themNhanVien(nv, result);
            } else {
            }
        }
        return result;
    }

    public NhanVien[] timKiemNhanVienKinhDoanh() {
        NhanVien[] result = new NhanVien[0];

        for (NhanVien nv : dsnv) {
            if (nv instanceof NhanVienKinhDoanh) {
                result = themNhanVien(nv, result);
            }
        }
        return result;
    }

    public NhanVien[] timKiemNhanVienQuanLy() {
        NhanVien[] result = new NhanVien[0];

        for (NhanVien nv : dsnv) {
            if (nv instanceof NhanVienQuanLy) {
                result = themNhanVien(nv, result);
            }
        }
        return result;
    }

    public int getSoLuong(String loaiNhanVien) {
        NhanVien[] result;
        if (loaiNhanVien.equalsIgnoreCase("tatca")) {
            return dsnv.length;
        }
        if (loaiNhanVien.equalsIgnoreCase("sanxuat")) {
            result = timKiemNhanVienSanXuat();
            return result.length;
        }
        if (loaiNhanVien.equalsIgnoreCase("kinhdoanh")) {
            result = timKiemNhanVienKinhDoanh();
            return result.length;
        }
        if (loaiNhanVien.equalsIgnoreCase("quanly")) {
            result = timKiemNhanVienQuanLy();
            return result.length;
        }
        return 0;
    }
}
