package DoAnOop;

public class Luong {
    private String bacLuong;
    private double heSoLuong;
    private double heSoPhuCap;
    static double[] hesoLuongList = {0, 2.34, 2.67, 3.0, 3.33, 3.66, 3.99, 4.32, 4.65};
    private final int LUONG_CO_BAN = 1400000;

    public Luong() {
        heSoLuong = hesoLuongList[0];
    }
    
    public Luong(String bl) {
        bacLuong = bl;
        heSoLuong = 2.34;
    }
    
    public Luong(String bl, double hsl, double hspc) {
        bacLuong = bl;
        heSoLuong = hsl;
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
