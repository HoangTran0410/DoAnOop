package DoAnOop;

public class Luong {
    private int bacLuong;
    private double heSoPhuCap;
    static double[] hesoLuongList = {0, 2.34, 2.67, 3.0, 3.33, 3.66, 3.99, 4.32, 4.65};
    private final int LUONG_CO_BAN = 1400000;

    public Luong() {
        bacLuong = 0;
    }
    
    public Luong(int bl) {
        bacLuong = bl;
    }
    
    public Luong(int bl, double hspc) {
        bacLuong = bl;
        heSoPhuCap = hspc;
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
