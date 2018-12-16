package DoAnOop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DanhSachPhongBan implements DanhSach, File {

    private PhongBan[] dspb;

    public DanhSachPhongBan() {
        dspb = new PhongBan[0];
    }

    public DanhSachPhongBan(DanhSachPhongBan ds) {
        this.dspb = ds.dspb;
    }

    @Override
    public void docFile(String tenFile) throws FileNotFoundException, IOException {
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream(tenFile))) {
            dspb = new PhongBan[0];
            while (fileIn.available() > 0) {
                PhongBan pb = new PhongBan();
                pb.docFile(fileIn);
                them(pb);
            }
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

    @Override
    public void ghiFile(String tenFile, Boolean ghiThem) throws FileNotFoundException, IOException {
        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(tenFile, ghiThem))) {
            for (PhongBan pb : dspb) {
                pb.ghiFile(fileOut);
            }
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
        if (c < dspb.length - 1) {
            dspb = Arrays.copyOf(dspb, c);
        }
    }

    @Override
    public void suaTheoMa(String ma) {
        for (PhongBan pb : dspb) {
            if (pb.getMaPhongBan().toLowerCase().contains(ma.toLowerCase())) {
                pb.nhap();
            }
        }
    }

    @Override
    public void xuat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int soLuong() {
        return dspb.length;
    }
}
