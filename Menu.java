package DoAnOop;

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
                System.out.println("4: Danh Sach Hop Dong.");
                System.out.println("0: THOAT.");
                System.out.println("=====================================");
                System.out.print("Lua chon: ");
                int luachon = scan.nextInt();

                switch (luachon) {
                    case 1:
                        menuDanhSachNhanVien();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Nhap khong dung!");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void menuDanhSachNhanVien() throws IOException {
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        try {
            Boolean exit = false;
            dsnv.docFile(FILE_DANHSACHNHANVIEN);

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
                System.out.println("0: QUAY VE.");
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
                        
                        for(int i = 0; i < soluongNhanvienThem; i++) {
                            System.out.print("\n+ Nhap nhan vien thu "+(i+1)+" (1:oke/ 0:dunglai):");
                            int dungnhap = scan.nextInt();
                            if(dungnhap == 0) break;
                            dsnv.them();
                        }
                        break;
                    case 7:
                        System.out.println("----------------- Xoa Nhan Vien -----------------");
                        System.out.print("Xoa theo (1: ten/ 2: ma nhan vien): ");
                        int loaixoa = scan.nextInt();
                        scan.nextLine();
                        switch(loaixoa) {
                            case 1: 
                                System.out.print("Nhap ten nhan vien muon xoa: ");
                                String ten = scan.nextLine();
                                
                                DanhSachNhanVien dsnv_ten = new DanhSachNhanVien(dsnv.timKiemTheoTen(ten));
                                dsnv_ten.xuat();
                                
                            case 2: 
                                if(loaixoa != 1) dsnv.xuat();
                                System.out.print("Nhap ma nhan vien muon xoa: ");
                                String ma_muonxoa = scan.nextLine();
                                
                                dsnv.xoaTheoMa(ma_muonxoa);
                                break;
                        }
                        break;
                    case 8:
                        System.out.println("----------------- Sua Nhan Vien -----------------");
                        System.out.print("Sua theo (1:ten/ 2:ma nhan vien): ");
                        int loaisua = scan.nextInt();
                        scan.nextLine();
                        switch(loaisua) {
                            case 1: 
                                System.out.print("Nhap ten nhan vien muon sua: ");
                                String ten = scan.nextLine();
                                
                                DanhSachNhanVien dsnv_ten = new DanhSachNhanVien(dsnv.timKiemTheoTen(ten));
                                dsnv_ten.xuat();
                                
                            case 2: 
                                if(loaisua != 1) dsnv.xuat();
                                System.out.print("Nhap ma nhan vien muon sua: ");
                                String ma_muonsua = scan.nextLine();
                                
                                dsnv.suaTheoMa(ma_muonsua);
                                break;
                        }
                        break;
                    case 9:
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Nhap khong dung!");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
        }
    }
}
