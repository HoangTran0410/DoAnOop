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
                System.out.println("3: Thong Ke.");
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
                        menuThongKe();
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
        dsnv.docFile(FILE_DANHSACHNHANVIEN);
        Boolean exit = false;

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
                    // lưu lại vào file
                    dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
                    break;

                case 6:
                    System.out.println("----------------- Them Nhieu Nhan Vien -----------------");
                    System.out.print("So luong nhan vien muon them: ");
                    int soluongNhanvienThem = scan.nextInt();
                    int soLuongCu = dsnv.getSoLuong("tatca");

                    for (int i = 0; i < soluongNhanvienThem; i++) {
                        System.out.print("\n+ Nhap nhan vien thu " + (dsnv.getSoLuong("tatca") - soLuongCu + 1) + " (1:oke / 0:dunglai):");
                        int dungnhap = scan.nextInt();
                        if (dungnhap == 0) {
                            break;
                        }
                        dsnv.them();
                    }
                    // lưu lại vào file
                    dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
                    break;

                case 7:
                    if (dsnv.getSoLuong("tatca") == 0) {
                        System.err.println("Khong co nhan vien nao de xoa!");
                        break;
                    }
                    System.out.println("----------------- Xoa Nhan Vien -----------------");
                    System.out.print("Xoa theo (1: ten / 2: ma nhan vien): ");
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

                                    // lưu lại vào file
                                    dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
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
                        System.err.println("Chua co nhan vien nao de sua!");
                        break;
                    }
                    System.out.print("Sua theo (1:ten / 2:ma nhan vien): ");
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
                                    NhanVien nv = dsnv.timKiemTheoMa(ma_muonsua);
                                    System.out.println("\n\n");
                                    System.out.println("========= SUA NHAN VIEN '" + nv.getHo() + " " + nv.getTen() + "' ===========");
                                    System.out.println("------------ Thong tin hien tai ----------");
                                    nv.xuat();
                                    System.out.println("------------------------------------------");

                                    System.out.print("Dong y muon sua? (1:oke / 0:huy): ");
                                    int luachon_muonsua = scan.nextInt();
                                    if (luachon_muonsua == 0) {
                                        break;
                                    }
                                    dsnv.suaTheoMa(ma_muonsua);

                                    // lưu lại vào file
                                    dsnv.ghiDe(FILE_DANHSACHNHANVIEN);
                                }
                            }
                            break;
                        default:
                            System.err.println("Lua chon khong dung!");
                    }
                    break;

                case 9:
                    if (dsnv.getSoLuong("tatca") == 0) {
                        System.err.println("Chua co nhan vien nao de tim!");
                        break;
                    }
                    System.out.println("----------------- Tim Nhan Vien -----------------");
                    System.out.print("Tim theo (1: ten / 2: ma nhan vien): ");
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
                    System.err.println("Lua chon khong dung!");
                    break;
            }
        }
    }

    public void menuDanhSachPhongBan() {
        DanhSachPhongBan dspb = new DanhSachPhongBan();
        dspb.docFile(FILE_DANHSACHPHONGBAN);
        Boolean exit = false;

        while (!exit) {
            System.out.println("\n\n");
            System.out.println("========= DANH SACH PHONG BAN ===========");
            System.out.println("1: Xem Danh Sach Phong Ban.");
            System.out.println("2: Xem Danh Sach Nhan Vien Phong Ban.");
            System.out.println("3: Them Phong Ban.");
            System.out.println("4: Sua Phong Ban.");
            System.out.println("5: Xoa Phong Ban.");
            System.out.println("6: Tim Kiem.");
            System.out.println("0: QUAY VE.");
            System.out.println("=====================================");
            System.out.print("Lua chon: ");
            int luachon = scan.nextInt();

            switch (luachon) {
                case 1:
                    System.out.println("----------------- Tat Ca Phong Ban -----------------");
                    dspb.xuat();
                    break;

                case 2:
                    if(dspb.getSoLuong() == 0) {
                        System.err.println("Chua co phong ban nao!");
                        break;
                    }
                    System.out.println("-------- Danh Sach Nhan Vien Cua Phong Ban ----------");
                    System.out.print("Nhap ma phong ban muon xem: ");
                    scan.nextLine();
                    String ma_muonxem = scan.nextLine();
                    PhongBan timThay = dspb.timKiemTheoMa(ma_muonxem);
                    if (timThay != null) {
                        DanhSachNhanVien dsnv_trongpb = new DanhSachNhanVien(timThay.getDanhSachNhanVien());
                        dsnv_trongpb.xuat();
                    } else {
                        System.err.println("\nKhong tim thay phong ban duoc chi dinh!");
                    }
                    break;

                case 3:
                    System.out.println("----------------- Them Phong Ban -----------------");
                    dspb.them();
                    // luu vao file
                    dspb.ghiDe(FILE_DANHSACHPHONGBAN);
                    break;

                case 4:
                    if(dspb.getSoLuong() == 0) {
                        System.err.println("Chua co phong ban nao de sua!");
                        break;
                    }
                    System.out.println("----------------- Sua Phong Ban -----------------");
                    if (dspb.getSoLuong() == 0) {
                        System.err.println("Chua co phong ban nao de sua!");
                        break;
                    }
                    System.out.print("Sua theo (1:ten / 2:ma phong ban): ");
                    int loaisua = scan.nextInt();
                    scan.nextLine();

                    DanhSachPhongBan dspb_ten_sua = new DanhSachPhongBan(dspb); // khởi tạo danh sách mới = danh sách cũ
                    switch (loaisua) {
                        case 1:
                            System.out.print("Nhap ten phong ban muon sua: ");
                            String ten = scan.nextLine();

                            // tìm theo tên
                            dspb_ten_sua = new DanhSachPhongBan(dspb.timKiemTheoTen(ten));

                        // case 1 không break, do sau khi tìm theo tên sẽ ra 1 mảng (nếu có người trùng tên)
                        // nên vẫn cần người dùng nhập mã (trong case 2) để sửa chính xác
                        case 2:
                            dspb_ten_sua.xuat(); // xuất mảng tìm thấy, nếu loaisua == 2 thì chỗ xuất này xuất ra tất cả nv
                            if (dspb_ten_sua.getSoLuong() > 0) {
                                System.out.print("Nhap ma phong ban muon sua: ");
                                String ma_muonsua = scan.nextLine();

                                if (dspb_ten_sua.timKiemTheoMa(ma_muonsua) == null) {
                                    System.err.println("Ma vua nhap khong trung khop!");

                                } else {
                                    PhongBan pb = dspb.timKiemTheoMa(ma_muonsua);
                                    System.out.println("\n\n");
                                    System.out.println("========= SUA PHONG BAN '" + pb.getTenPhongBan() + "' ===========");
                                    System.out.println("------------ Thong tin hien tai ----------");
                                    pb.xuat();
                                    System.out.println("------------------------------------------");

                                    System.out.print("Dong y muon sua? (1:oke / 0:huy): ");
                                    int luachon_muonsua = scan.nextInt();
                                    if (luachon_muonsua == 0) {
                                        break;
                                    }
                                    dspb.suaTheoMa(ma_muonsua);

                                    // lưu lại vào file
                                    dspb.ghiDe(FILE_DANHSACHNHANVIEN);
                                }
                            }
                            break;

                        default:
                            System.err.println("Lua chon khong dung!");
                    }

                case 5:
                    if(dspb.getSoLuong() == 0) {
                        System.err.println("Chua co phong ban nao de xoa!");
                        break;
                    }
                    System.out.println("----------------- Xoa Phong Ban -----------------");
                    dspb.xuat();
                    System.out.print("\nNhap ma phong ban mon xoa: ");
                    scan.nextLine();
                    String mapb = scan.nextLine();
                    if (dspb.timKiemTheoMa(mapb) != null) {
                        dspb.xoaTheoMa(mapb);
                        // luu vao file
                        dspb.ghiDe(FILE_DANHSACHPHONGBAN);
                    } else {
                        System.err.println("\nKhonghong tim thay phong ban duoc chi dinh !");
                    }
                    break;

                case 6:
                    if(dspb.getSoLuong() == 0) {
                        System.err.println("Chua co phong ban nao de tim!");
                        break;
                    }
                    System.out.print("Tim kiem theo (1:ten / 2:ma phong ban): ");
                    int loaitim = scan.nextInt();
                    scan.nextLine();
                    DanhSachPhongBan dspb_tim_ten = new DanhSachPhongBan(dspb); // khởi tạo danh sách mới = danh sách cũ
                    switch (loaitim) {
                        case 1:
                            System.out.print("Nhap ten phong ban muon tim: ");
                            String ten = scan.nextLine();

                            // tìm theo tên
                            dspb_tim_ten = new DanhSachPhongBan(dspb.timKiemTheoTen(ten));

                        // case 1 không break, do sau khi tìm theo tên sẽ ra 1 mảng (nếu có người trùng tên)
                        // nên vẫn cần người dùng nhập mã (trong case 2) để xóa chính xác
                        case 2:
                            dspb_tim_ten.xuat(); // xuất mảng tìm thấy, nếu loaixoa == 2 thì chỗ xuất này xuất ra tất cả nv

                            System.out.print("Nhap ma phong ban muon tim: ");
                            String ma_muontim = scan.nextLine();

                            PhongBan timThay_theoma = dspb_tim_ten.timKiemTheoMa(ma_muontim);
                            if (timThay_theoma == null) {
                                System.err.println("Ma vua nhap khong trung khop!");
                            } else {
                                DanhSachPhongBan ds_temp = new DanhSachPhongBan();
                                ds_temp.them(timThay_theoma);
                                ds_temp.xuat();
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
                    System.err.println("\nLua chon khong dung !");
            }
        }
    }

    public void menuThongKe() {
        System.out.print("\n\n======================= Thong Ke =======================\n\n");
        System.out.println("1. Nhan Vien. ");
        System.out.println("2. Phong Ban. ");
        System.out.println("0: QUAY VE.");
        System.out.println("=====================================");
        System.out.print("Lua chon: ");

    }
}
