
package DoAnOop;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DanhSachLuong implements DanhSach, File {
    private Luong[] dsl;

    public DanhSachLuong() {
        dsl = new Luong[0];
    }
    
    public DanhSachLuong(Luong[] mangLuong) {
        dsl = mangLuong;
    }
    
    public DanhSachLuong(DanhSachLuong ds) {
        this.dsl = ds.dsl;
    }
    
    public Luong timKiemTheoMa(String maLuong) {
//        for(Luong l : danhSachLuong) {
//            if(l.getMaLuong().equals(maLuong))
//                return l;
//        }
        return null;
    }

    @Override
    public void them() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoaTaiViTri(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoaTheoMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suaTheoMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xuat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void docFile(String tenFile) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ghiThem(String tenFile) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ghiDe(String tenFile) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ghiFile(String tenFile, Boolean ghiDe) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
