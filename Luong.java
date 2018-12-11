package DoAnOop;

public class Luong {
    
    private String maLuong;
    private double heSoLuong;
    private final int LUONG_CO_BAN = 1400000;

    public Luong() {
        heSoLuong = 2.34;
    }
    
    public Luong(String ml) {
        maLuong = ml;
        heSoLuong = 2.34;
    }
    
    public Luong(String ml, double hs) {
        maLuong = ml;
        heSoLuong = hs;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int thamNienLamViec() {
        return 0;
    }

    public int phuCapThamNien() {
        return 0;
    }

    public double giaTriXepLoai(char xl) {
        switch(xl) {
            case 'A' : return 1;
            case 'B' : return .75;
            case 'C' : return .5;
            default : return 0;
        }
    }

    public char xepLoai() {
        return 'A';
    }

    public int luongDuKien() {
        return 0;
    }

    public int luongThucTe() {
        return 0;
    }
}
