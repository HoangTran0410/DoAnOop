package DoAnOop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    
    public static final String FILE_DANHSACHPHONGBAN = "DanhSachPhongBan.txt";
    public static final String FILE_DANHSACHNHANVIEN = "DanhSachNhanVien.txt";
    
    Scanner scan = new Scanner(System.in);
    
    public Menu() {
        
    }
    
    public void run() {
        try {
            Boolean exit = false;
            while (!exit) {
                System.out.println("\n\n");
                System.out.println("========= QUAN LY NHAN SU ===========");
                System.out.println("1: Danh Sach Nhan Vien.");
                System.out.println("2: Danh Sach Phong Ban.");
                System.out.println("3: Danh Sach Luong.");
                System.out.println("0: THOAT.");
                System.out.println("=====================================");
                System.out.print("Lua chon: ");
                int luachon = scan.nextInt();
                
                switch (luachon) {
                    case 1:
                        menuDanhSachNhanVien();
                        break;
                    case 2:
                        menuDanhSachPhongBan();
                        break;
                    case 3:
                        System.err.println("Not available!");
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.err.println("Nhap khong dung!");
                        break;
                }
            }
            
        } catch (IOException e) {
            System.err.println("Loi IOException!");
        } finally {
            System.out.println("================================== DA THOAT CHUONG TRINH ==================================");
        }
    }
    
    public void menuDanhSachNhanVien() throws IOException {
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        try {
            Boolean exit = false;
            try {
                dsnv.docFile(FILE_DANHSACHNHANVIEN);
            } catch (FileNotFoundException e) {
                System.err.println("Khong tim thay file! File se duoc tao tu dong.");
            }
            
            while (!exit) {
                System.out.println("\n\n");
                System.out.println("========= DANH SACH NHAN VIEN ===========");
                System.out.println("1: Xem Danh Sach Tat Ca Nhan Vien.");
                System.out.println("2: Xem Danh Sach Nhan Vien Quan Ly.");
                System.out.println("3: Xem Danh Sach Nhan Vien Kinh Doanh.");
                System.out.println("4: Xem Danh Sach Nhan Vien San Xuat.");
                System.out.println("5: Them Nhan Vien.");
                System.out.println("6: Them Nhieu Nhan Vien.");
                System.out.println("7: Xoa Nhan Vien.");
                System.out.println("8: Sua Nhan Vien.");
                System.out.println("9: Tim Kiem.");
                System.out.println("0: LUU va QUAY VE.");
                System.out.println("=====================================");
                System.out.print("Lua chon: ");
                int luachon = scan.nextInt();
                
                switch (luachon) {
                    case 1:
                        System.out.println("----------------- Tat Ca Nhan Vien -----------------");
                        dsnv.xuat();
                        break;
                    case 2:
                        System.out.println("----------------- Nhan Vien Quan Ly -----------------");
                        DanhSachNhanVien dsnv_ql = new DanhSachNhanVien(dsnv.timKiemNhanVienQuanLy());
                        dsnv_ql.xuat();
                        break;
                    case 3:
                        System.out.println("----------------- Nhan Vien Kinh Doanh -----------------");
                        DanhSachNhanVien dsnv_kd = new DanhSachNhanVien(dsnv.timKiemNhanVienKinhDoanh());
                        dsnv_kd.xuat();
                        break;
                    case 4:
                        System.out.println("----------------- Nhan Vien San Xuat -----------------");
                        DanhSachNhanVien dsnv_sx = new DanhSachNhanVien(dsnv.timKiemNhanVienSanXuat());
                        dsnv_sx.xuat();
                        break;
                    case 5:
                        System.out.println("----------------- Them Nhan Vien -----------------");
                        dsnv.them();
                        break;
                    
                    case 6:
                        System.out.println("----------------- Them Nhieu Nhan Vien -----------------");
                        System.out.print("So luong nhan vien muon them: ");
                        int soluongNhanvienThem = scan.nextInt();
                        int soLuongCu = dsnv.getSoLuong("tatca");
                        
                        for (int i = 0; i < soluongNhanvienThem; i++) {
                            System.out.print("\n+ Nhap nhan vien thu " + (dsnv.getSoLuong("tatca") - soLuongCu + 1) + " (1:oke/ 0:dunglai):");
                            int dungnhap = scan.nextInt();
                            if (dungnhap == 0) {
                                break;
                            }
                            dsnv.them();
                        }
                        break;
                    case 7:
                        System.out.println("----------------- Xoa Nhan Vien -----------------");
                        if (dsnv.getSoLuong("tatca") == 0) {
                            System.err.println("Khong co nhan vien nao de xoa!");
                            break;
                        }
                        
                        System.out.print("Xoa theo (1: ten/ 2: ma nhan vien): ");
                        int loaixoa = scan.nextInt();
                        scan.nextLine();
                        
                        DanhSachNhanVien dsnv_ten_xoa = new DanhSachNhanVien(dsnv); // khởi tạo danh sách mới = danh sách cũ
                        switch (loaixoa) {
                            case 1:
                                System.out.print("Nhap ten nhan vien muon xoa: ");
                                String ten = scan.nextLine();

                                // tìm theo tên
                                dsnv_ten_xoa = new DanhSachNhanVien(dsnv.timKiemTheoTen(ten));

                            // case 1 không break, do sau khi tìm theo tên sẽ ra 1 mảng (nếu có người trùng tên)
                            // nên vẫn cần người dùng nhập mã (trong case 2) để xóa chính xác
                            case 2:
                                dsnv_ten_xoa.xuat(); // xuất mảng tìm thấy, nếu loaixoa == 2 thì chỗ xuất này xuất ra tất cả nv

                                if (dsnv_ten_xoa.getSoLuong("tatca") > 0) {
                                    System.out.print("Nhap ma nhan vien muon xoa: ");
                                    String ma_muonxoa = scan.nextLine();
                                    
                                    if (dsnv_ten_xoa.timKiemTheoMa(ma_muonxoa) == null) {
                                        System.err.println("Ma vua nhap khong trung khop!");
                                    } else {
                                        dsnv.xoaTheoMa(ma_muonxoa);
                                    }
                                }
                                
                                break;
                            default:
                                System.err.println("Lua chon khong dung!");
                        }
                        break;
                    case 8:
                        System.out.println("----------------- Sua Nhan Vien -----------------");
                        if (dsnv.getSoLuong("tatca") == 0) {
                            System.err.println("Khong co nhan vien nao de sua!");
                            break;
                        }
                        System.out.print("Sua theo (1:ten/ 2:ma nhan vien): ");
                        int loaisua = scan.nextInt();
                        scan.nextLine();
                        
                        DanhSachNhanVien dsnv_ten_sua = new DanhSachNhanVien(dsnv); // khởi tạo danh sách mới = danh sách cũ
                        switch (loaisua) {
                            case 1:
                                System.out.print("Nhap ten nhan vien muon sua: ");
                                String ten = scan.nextLine();

                                // tìm theo tên
                                dsnv_ten_sua = new DanhSachNhanVien(dsnv.timKiemTheoTen(ten));

                            // case 1 không break, do sau khi tìm theo tên sẽ ra 1 mảng (nếu có người trùng tên)
                            // nên vẫn cần người dùng nhập mã (trong case 2) để sửa chính xác
                            case 2:
                                dsnv_ten_sua.xuat(); // xuất mảng tìm thấy, nếu loaisua == 2 thì chỗ xuất này xuất ra tất cả nv
                                if (dsnv_ten_sua.getSoLuong("tatca") > 0) {
                                    System.out.print("Nhap ma nhan vien muon sua: ");
                                    String ma_muonsua = scan.nextLine();
                                    
                                    if (dsnv_ten_sua.timKiemTheoMa(ma_muonsua) == null) {
                                        System.err.println("Ma vua nhap khong trung khop!");
                                    } else {
                                        menuSuaNhanVien(dsnv, ma_muonsua);
                                    }
                                }
                                
                                break;
                            default:
                                System.err.println("Lua chon khong dung!");
                        }
                        break;
                    case 9:
                        System.out.print("Tim theo (1: ten/ 2: ma nhan vien): ");
                        int loaitim = scan.nextInt();
                        scan.nextLine();
                        
                        DanhSachNhanVien dsnv_ten_tim = new DanhSachNhanVien(dsnv);
                        switch (loaitim) {
                            case 1:
                                System.out.print("Nhap ten (hoac ho ten) nhan vien muon tim: ");
                                String ten = scan.nextLine();

                                // tìm theo tên
                                dsnv_ten_tim = new DanhSachNhanVien(dsnv.timKiemTheoTen(ten));

                            // case 1 không break, do sau khi tìm theo tên sẽ ra 1 mảng (nếu có người trùng tên)
                            // nên vẫn cần người dùng nhập mã (trong case 2) để tìm chính xác
                            case 2:
                                dsnv_ten_tim.xuat(); // xuất mảng tìm thấy, nếu loaisua == 2 thì chỗ xuất này xuất ra tất cả nv
                                if (dsnv_ten_tim.getSoLuong("tatca") > 0) {
                                    System.out.print("Nhap ma nhan vien muon xem thong tin: ");
                                    String ma_muontim = scan.nextLine();
                                    
                                    NhanVien timThay = dsnv_ten_tim.timKiemTheoMa(ma_muontim);
                                    if (timThay == null) {
                                        System.err.println("Ma vua nhap khong trung khop!");
                                    } else {
                                        System.out.println("\n--------------- " + timThay.loaiNhanVien() + "--------------- ");
                                        timThay.xuat();
                                        System.out.println("------------------------------------------------------------- ");
                                    }
                                }
                                break;
                            default:
                                System.err.println("Lua chon khong dung!");
                        }
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.err.println("Nhap khong dung!");
                        break;
                }
            }
            
        } catch (IOException e) {
            System.err.println("Loi IOException!");
        } finally {
            try {
                dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
                System.out.println("Luu thanh cong");
            } catch (IOException e) {
                System.err.println("Luu khong thanh cong!!");
            } finally {
                System.out.print("\n====================================================\n\n");
            }
        }
    }
    
    public void menuSuaNhanVien(DanhSachNhanVien ds, String ma) {
        Boolean exit = false;
        NhanVien nv = ds.timKiemTheoMa(ma);
        while (!exit) {
            System.out.println("\n\n");
            System.out.println("========= SUA NHAN VIEN '" + nv.getHo() + " " + nv.getTen() + "' ===========");
            System.out.println("------------ Thong tin hien tai ----------");
            nv.xuat();
            System.out.println("------------------------------------------");
            
            System.out.print("Dong y muon sua? (1:oke / 0:huy): ");
            int luachon = scan.nextInt();
            if (luachon == 0) {
                break;
            }
            
            ds.suaTheoMa(ma);
        }
    }
    
    public void menuDanhSachPhongBan() {
        
    }
}
