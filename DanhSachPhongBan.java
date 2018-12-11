package DoAnOop;

import java.util.Arrays;

public class DanhSachPhongBan {
    private PhongBan[] dspb;

    public DanhSachPhongBan() {
        dspb = new PhongBan[0];
    }
    
    public DanhSachPhongBan(DanhSachPhongBan ds) {
        this.dspb = ds.dspb;
    }
    
    private PhongBan[] themPhongBan(PhongBan nv, PhongBan[] list) {
        PhongBan[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = new PhongBan(nv);
        return temp;
    }
    
    public void themPhongBan(PhongBan p) {
        dspb = themPhongBan(p, dspb);
    }
    
}
