package DoAnOop;

import java.util.Arrays;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DanhSachNhanVien {

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

    public void ghiThem(String tenFile) throws FileNotFoundException, IOException {
        ghiFile(tenFile, true);
    }

    public void ghiDe(String tenFile) throws FileNotFoundException, IOException {
        ghiFile(tenFile, false);
    }

    public void ghiFile(String tenFile, Boolean ghiThem) throws FileNotFoundException, IOException {
        DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(tenFile, ghiThem));

        for (NhanVien nv : dsnv) {
            nv.ghiFile(fileOut);
        }

        fileOut.close();
    }

    // https://stackoverflow.com/questions/16945335/java-need-a-while-loop-to-reach-eof-i-e-while-eof-keep-parsing
    public void docFile(String tenFile) throws FileNotFoundException, IOException {

        try (DataInputStream fileIn = new DataInputStream(new FileInputStream(tenFile))) {
            dsnv = new NhanVien[0];
            while (fileIn.available() > 0) {
                String loaiNhanVien = fileIn.readUTF();

                if (loaiNhanVien.equalsIgnoreCase("quanly")) {
                    NhanVienQuanLy nv = new NhanVienQuanLy();
                    nv.docFile(fileIn);
                    themNhanVien(nv);

                } else if (loaiNhanVien.equalsIgnoreCase("kinhdoanh")) {
                    NhanVienKinhDoanh nv = new NhanVienKinhDoanh();
                    nv.docFile(fileIn);
                    themNhanVien(nv);

                } else if (loaiNhanVien.equalsIgnoreCase("sanxuat")) {
                    NhanVienSanXuat nv = new NhanVienSanXuat();
                    nv.docFile(fileIn);
                    themNhanVien(nv);
                }
            }
        }
    }

    private NhanVien[] themNhanVien(NhanVien nv, NhanVien[] list) {
        NhanVien[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = nv;
        return temp;
    }

    public void themNhanVien() {
        NhanVien temp = new NhanVien();
        temp.nhap();
        themNhanVien(temp);
    }

    public void themNhanVien(NhanVien nv) {
        dsnv = themNhanVien(nv, dsnv);
    }

    public void xoaNhanVienTaiViTri(int index) {
        for (int i = index + 1; i < dsnv.length; i++) {
            dsnv[i - 1] = dsnv[i];
        }
    }

    public void xoaNhanVienTheoMa(String ma) {
        int c, i;
        for (c = i = 0; i < dsnv.length; i++) {
            if (!dsnv[i].getMaNhanVien().equals(ma)) {
                dsnv[c] = dsnv[i];
                c++;
            }
        }
        // neu tim thay va xoa duoc, thi phai thu nho chieu dai mang lai = c
        if (c < dsnv.length - 1) {
            dsnv = Arrays.copyOf(dsnv, c);
        }
    }

    public void xuat() {
        // https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
        
        System.out.println("   MaNV           Ho va Ten            GioiTinh     NgaySinh     SoDienThoai  ");
        System.out.println("----------------------------------------------------------------------------");
        for (NhanVien nv : dsnv) {
            // MaNV | HoTen | GioiTinh | NgaySinh | SoDienThoai
            System.out.format("| %-6s| %-15s %-10s| %10s| %11s| %12s |\n",
                    nv.getMaNhanVien(),
                    nv.getHo(), 
                    nv.getTen(),
                    nv.getGioiTinh(),
                    nv.getNgaySinh() + "/" + nv.getThangSinh() + "/" + nv.getNamSinh(),
                    nv.getSoDienThoai());
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    public NhanVien timKiemTheoMa(String maNv) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNhanVien().toLowerCase().contains(maNv.toLowerCase())) {
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

    public int soLuong(String loaiNhanVien) {
        NhanVien[] result;
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
