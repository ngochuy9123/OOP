package lop;

import java.io.IOException;
import java.util.Scanner;

import kinhDoanh.PersonList;
import kinhDoanh.User;

public class Menu {
	public static String exit ="khong";
	public static User user = new User();
	public static PersonList dsP = new PersonList();
	public static Hambuger ham = new Hambuger();
	public static FriedChicken gaChien = new FriedChicken();
	public static Thit thit = new Thit();
	public static TraiCay tc = new TraiCay();
	public static NuocEp ncEp = new NuocEp();
	public static NuocCoGa ncCoGa = new NuocCoGa();
	
	public static void docFile() {
		try {
			user.docFile();
		} catch (IOException e) {
			System.out.println("Loi doc File User");
			e.printStackTrace();
		}
		try {
			ham.docFile();
		} catch (IOException e) {
			System.out.println("Loi doc File Hambuger");
			e.printStackTrace();
		}
		try {
			gaChien.docFile();
		} catch (IOException e) {
			System.out.println("Loi doc File Ga Chien");
			e.printStackTrace();
		}
		try {
			ncEp.docFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ncCoGa.docFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			thit.docFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tc.docFile();
		dsP.docFileDsPerson();
		
	}
	
	public static void cacYeuCau() {
		System.out.println("Ban Muon: ");
		System.out.println("0. Thoat");
		System.out.println("1. Them");
		System.out.println("2. Sua ");
		System.out.println("3. Xoa ");
		System.out.println("4. Sap Xep");
		System.out.println("5. Tim Kiem");
		System.out.println("6. Xem Gia Ban");
	}
	
	public static void chinhSuaHambuger() {
		String exit = "khong";
		do {
			ham.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu san pham khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					ham.themNSp();
				}
				else {
					ham.them();
				}
				
				break;
			}
			case 2:{
				ham.sua();
				break;
			}
			case 3:{
				ham.xoa();
				break;
			}
			case 4:{
				ham.sapXep();
				break;
			}
			case 5:{
				ham.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(ham.ktTrung(id)==true) {
					for(Hambuger h:ham.dsHambuger)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenMonAn()+" la: "+h.setGiaBan());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	public static void chinhSuaGaChien() {
		String exit = "khong";
		do {
			gaChien.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu san pham khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					gaChien.themNSp();
				}
				else {
					gaChien.them();
				}
				break;
			}
			case 2:{
				gaChien.sua();
				break;
			}
			case 3:{
				gaChien.xoa();
				break;
			}
			case 4:{
				gaChien.sapXep();
				break;
			}
			case 5:{
				gaChien.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(gaChien.ktTrung(id)==true) {
					for(FriedChicken h:gaChien.dsGaChien)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenMonAn()+" la: "+h.setGiaBan());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	public static void chinhSuaNuocEp() {
		String exit = "khong";
		do {
			ncEp.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu san pham khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					ncEp.themNSp();
				}
				else {
					ncEp.them();
				}
				break;
			}
			case 2:{
				ncEp.sua();
				break;
			}
			case 3:{
				ncEp.xoa();
				break;
			}
			case 4:{
				ncEp.sapXep();
				break;
			}
			case 5:{
				ncEp.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(ncEp.ktTrung(id)==true) {
					for(NuocEp h:ncEp.dsNuocEp)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenMonAn()+" la: "+h.setGiaBan());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	public static void chinhSuaNuocCoGa() {
		String exit = "khong";
		do {
			ncCoGa.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu san pham khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					ncCoGa.themNSp();
				}
				else {
					ncCoGa.them();
				}
				break;
			}
			case 2:{
				ncCoGa.sua();
				break;
			}
			case 3:{
				ncCoGa.xoa();
				break;
			}
			case 4:{
				ncCoGa.sapXep();
				break;
			}
			case 5:{
				ncCoGa.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(ncCoGa.ktTrung(id)==true) {
					for(NuocCoGa h:ncCoGa.dsNuocCoGa)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenMonAn()+" la: "+h.setGiaBan());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	public static void chinhSuaThit() {
		String exit = "khong";
		do {
			thit.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu nguyen lieu khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					thit.themNSp();
				}
				else {
					thit.them();
				}
				break;
			}
			case 2:{
				thit.sua();
				break;
			}
			case 3:{
				thit.xoa();
				break;
			}
			case 4:{
				thit.sapXep();
				break;
			}
			case 5:{
				thit.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(thit.ktTrung(id)==true) {
					for(Thit h:thit.dsThit)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenNguyenLieu()+" la: "+h.getGia());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	public static void chinhSuaTraiCay() {
		String exit = "khong";
		do {
			tc.xuatDs();
			cacYeuCau();
			int lc  = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				exit = "co";
				break;
			}
			case 1:{
				System.out.println("Ban muon them nhieu nguyen lieu khong? ---- 'y' de dong y");
				String yn = new Scanner(System.in).nextLine();
				if(yn.equals("y")) {
					thit.themNSp();
				}
				else {
					thit.them();
				}
				break;
			}
			case 2:{
				tc.sua();
				break;
			}
			case 3:{
				tc.xoa();
				break;
			}
			case 4:{
				tc.sapXep();
				break;
			}
			case 5:{
				tc.timKiem();
				break;
			}
			case 6:{
				System.out.println("MOi ban nhap id Mon An ma ban muon xem Gia Ban: ");
				int id = new Scanner(System.in).nextInt();
				if(tc.ktTrung(id)==true) {
					for(TraiCay h:tc.dsTraiCay)
						if(h.getId()==id)
							System.out.println("Gia ban cua "+h.getTenNguyenLieu()+" la: "+h.getGia());
				}
				else {
					System.out.println("Id khong ton tai");
				}
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau");
			}
			
		}while(exit.equals("khong"));
		
	}
	
	public static void suaNguyenLieu() {
		while(true) {
			int lc;
			System.out.println("Moi ban chon Nguyen Lieu can thay doi: ");
			System.out.println("0. Thoat");
			System.out.println("1. Thit");
			System.out.println("2. Trai Cay");
			lc = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0:{
				quanLy();
			}
			case 1: {
				chinhSuaThit();
				break;
			}
			case 2:{
				chinhSuaTraiCay();
				break;
			}
			
			default:
				System.out.println("Ban Da nhap sai theo Yeu Cau");
			}
		}
		
	}
	public static void suaMonAn() {
		while(true) {
			int lc = 0;
			System.out.println("Moi ban chon Mon can thay doi:");
			System.out.println("0. Thoat");
			System.out.println("1. Hambuger");
			System.out.println("2. Ga Chien");
			System.out.println("3. Nuoc Ep");
			System.out.println("4. Nuoc Co Ga");
			lc = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0:{
				quanLy();
				break;
			}
			case 1: {
				chinhSuaHambuger();
				break;
			}
			case 2:{
				chinhSuaGaChien();
				break;
			}
			case 3:{
				chinhSuaNuocEp();
				break;
			}
			case 4:{
				chinhSuaNuocCoGa();
				break;
			}
			default:
				System.out.println("Ban da nhap sai theo yeu cau");
			}
		}
		

	}
	public static void quanLy() {
		System.out.println("Quan Ly");
		System.out.println("Ban muon thay doi: ");
		System.out.println("0. Thoat");
		System.out.println("1. Thuc An");
		System.out.println("2. Nguyen Lieu");
		int lc = new Scanner(System.in).nextInt();
		if(lc==1) {
			suaMonAn();
		}
		else if(lc==0) {
			System.out.println(
	                " _______________________________________________ \n" +
	                "|                                               |\n" +
	                "|      THANKS FOR USING OUR APPLICATION         |\n" +
	                "|                                               |\n" +
	                "                                                 \n" +
	                "            • ˚ •˛•˚ * 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
	                "            • ˚Happy★* 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
	                "            •。★Holidays!★ 。* • ˚。             \n" +
	                "            ° 。 ° ˛˚˛ *__Π____*。*˚             \n" +
	                "            ˚ ˛ •˛•˚ */______/~＼。˚ ˚ ˛         \n" +
	                "            ˚˛ •˛• ˚ ｜ 田田 ｜門｜ ˚              \n" +
	                "                                                 \n" +
	                "                                                 \n" +
	                "|                                               |\n" +
	                "|     MERRY CHRISTMAS AND HAPPY NEW YEAR        |\n" +
	                "|_______________________________________________|");
			System.exit(0);
			
		}
		else if(lc==2){
			suaNguyenLieu();

		}
		else {
			System.out.println("Ban da nhap sai yeu cau");
		}
	}
	
	public static void nhanVien() {
		while(true) {
			System.out.println("Ban muon xem thong tin cua Mon An nao: ");
			System.out.println("0. Thoat");
			System.out.println("1. Hambuger");
			System.out.println("2. Ga Chien");
			System.out.println("3. Nuoc Ep");
			System.out.println("4. Nuoc Co Ga");
			int lc = new Scanner(System.in).nextInt();
			switch (lc) {
			case 0: {
				System.out.println(
		                " _______________________________________________ \n" +
		                "|                                               |\n" +
		                "|      THANKS FOR USING OUR APPLICATION         |\n" +
		                "|                                               |\n" +
		                "                                                 \n" +
		                "            • ˚ •˛•˚ * 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
		                "            • ˚Happy★* 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
		                "            •。★Holidays!★ 。* • ˚。             \n" +
		                "            ° 。 ° ˛˚˛ *__Π____*。*˚             \n" +
		                "            ˚ ˛ •˛•˚ */______/~＼。˚ ˚ ˛         \n" +
		                "            ˚˛ •˛• ˚ ｜ 田田 ｜門｜ ˚              \n" +
		                "                                                 \n" +
		                "                                                 \n" +
		                "|                                               |\n" +
		                "|     MERRY CHRISTMAS AND HAPPY NEW YEAR        |\n" +
		                "|_______________________________________________|");
				System.exit(0);
				break;
			}
			case 1:{
				ham.xuatDs();
				break;
			}
			case 2:{
				gaChien.xuatDs();
				break;
			}
			case 3:{
				ncEp.xuatDs();
				break;
			}
			case 4:{
				ncCoGa.xuatDs();
				break;
			}
			default:
				System.out.println("Ban da nhap sai yeu cau de bai");
			}
		}
		
	}
	
	
	public static void menu() {
		int vaiTro = user.dangNhap();
		if(vaiTro==1) {
			quanLy();
		}
		else if(vaiTro == 2) {
			System.out.println("Ke Toan");
		}
		else {
			nhanVien();
		}
	}
	public static void main(String[] args) {
		docFile();
		menu();
	}
}
