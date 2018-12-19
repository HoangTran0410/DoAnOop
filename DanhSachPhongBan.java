package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanhSachPhongBan implements DanhSach, File {

    private PhongBan[] dspb;

    public DanhSachPhongBan() {
        dspb = new PhongBan[0];
    }

    public DanhSachPhongBan(PhongBan[] dspb) {
        this.dspb = dspb;
    }

    public DanhSachPhongBan(DanhSachPhongBan ds) {
        this.dspb = ds.dspb;
    }

    @Override
    public void docFile(String tenFile) {
        try {
            try (DataInputStream fileIn = new DataInputStream(new FileInputStream(tenFile))) {
                dspb = new PhongBan[0];
                while (fileIn.available() > 0) {
                    PhongBan pb = new PhongBan();
                    pb.docFile(fileIn);
                    them(pb);
                }
            }
        } catch (IOException e) {
            System.err.println("Loi khi DOC FILE "+ tenFile +"! File moi se dươc tao tu dong.");
            ghiDe(tenFile);
        }

    }

    @Override
    public void ghiThem(String tenFile) {
        ghiFile(tenFile, true);
    }

    @Override
    public void ghiDe(String tenFile) {
        ghiFile(tenFile, false);
    }

    @Override
    public void ghiFile(String tenFile, Boolean ghiThem) {
        try {
            try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(tenFile, ghiThem))) {
                for (PhongBan pb : dspb) {
                    pb.ghiFile(fileOut);
                }
                System.out.println("GHI FILE THANH CONG.");
            }
        } catch (IOException e) {
            System.err.println("Loi khi GHI FILE "+ tenFile +"!");
        }

    }

    private PhongBan[] themPhongBan(PhongBan pb, PhongBan[] list) {
        PhongBan[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = pb;
        return temp;
    }

    public void them(PhongBan p) {
        dspb = themPhongBan(p, dspb);
    }

    @Override
    public void them() {
        PhongBan pb = new PhongBan();
        pb.nhap();
        them(pb);
    }

    @Override
    public void xoaTaiViTri(int index) {
        if (index < dspb.length) {
            for (int i = index + 1; i < dspb.length; i++) {
                dspb[i - 1] = dspb[i];
            }
            dspb = Arrays.copyOf(dspb, dspb.length - 1);
        }
    }

    @Override
    public void xoaTheoMa(String ma) {
        int c, i;
        for (c = i = 0; i < dspb.length; i++) {
            if (!dspb[i].getMaPhongBan().equals(ma)) {
                dspb[c] = dspb[i];
                c++;
            }
        }
        // neu tim thay va xoa duoc, thi phai thu nho chieu dai mang lai = c
        if (c < dspb.length) {
            dspb = Arrays.copyOf(dspb, c);
        }
    }

    @Override
    public void suaTheoMa(String ma) {
        for (PhongBan pb : dspb) {
            if (pb.getMaPhongBan().toLowerCase().contains(ma.toLowerCase())) {
                // xóa giá trị cũ
                pb.setMaPhongBan(pb.getMaPhongBan() + " sua chua xong!");

                // lưu vào file (do hàm check đọc từ file)
                ghiDe(Menu.FILE_DANHSACHPHONGBAN);

                // nhập giá trị mới
                pb.nhap();
            }
        }
    }

    public PhongBan timKiemTheoMa(String ma) {
        for (PhongBan pb : dspb) {
            if (pb.getMaPhongBan().equals(ma)) {
                return pb;
            }
        }
        return null;
    }

    public int timKiemViTriTheoMa(String ma) {
        for (int i = 0; i < dspb.length; i++) {
            if (dspb[i].getMaPhongBan().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public PhongBan[] timKiemTheoTen(String ten) {
        PhongBan[] result = new PhongBan[0];

        for (PhongBan pb : dspb) {
            if (pb.getTenPhongBan().toLowerCase().contains(ten.toLowerCase())) {
                result = themPhongBan(pb, result);
            }
        }
        return result;
    }

    @Override
    public void xuat() {
        if (dspb.length == 0) {
            System.err.println("Chua co phong ban nao!");
            return;
        }

        System.out.println("   MaPB     Ten Phong Ban     SDT Phong Ban          DiaChi");
        System.out.println("--------------------------------------------------------------------");
        for (PhongBan pb : dspb) {
            // MaNV | HoTen | GioiTinh | NgaySinh | SoDienThoai
            System.out.format("| %-6s| %-17s| %15s | %20s |\n",
                    pb.getMaPhongBan(),
                    pb.getTenPhongBan(),
                    pb.getSdtPhongBan(),
                    pb.getDiaChi());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public int getSoLuong() {
        return dspb.length;
    }

    public PhongBan[] getDanhSach() {
        return dspb;
    }
}
