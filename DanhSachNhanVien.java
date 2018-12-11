package DoAnOop ;
import java.util.Arrays;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    public void luuDanhSach(String fileName) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream(fileName, Boolean.TRUE);
        DataOutputStream outStream = new DataOutputStream(file);

        for (NhanVien nv : dsnv) {
            outStream.writeUTF(nv.getHo() + nv.getTen());
            outStream.writeUTF(nv.getMaNhanVien());
        }
    }

    private NhanVien[] themNhanVien(NhanVien nv, NhanVien[] list) {
        NhanVien[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = new NhanVien(nv);
        return temp;
    }
    
    public void themNhanVien() {
        NhanVien temp = new NhanVien();
        temp.nhapThongTin();
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
        if(c < dsnv.length - 1) {
            dsnv = Arrays.copyOf(dsnv, c);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (NhanVien nv : dsnv) {
            result += nv.toString() + "\n";
        }
        return result;
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
        if(loaiNhanVien.equalsIgnoreCase("san xuat")) {
            result = timKiemNhanVienSanXuat();
            return result.length;
        }
        if(loaiNhanVien.equalsIgnoreCase("kinh doanh")) {
            result = timKiemNhanVienKinhDoanh();
            return result.length;
        }
        if(loaiNhanVien.equalsIgnoreCase("quan ly")) {
            result = timKiemNhanVienQuanLy();
            return result.length;
        }
        return 0;
    }
}
