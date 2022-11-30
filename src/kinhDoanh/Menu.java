package kinhDoanh;

import java.io.IOException;
import java.util.Scanner;

import kinhDoanh.PersonList;
import kinhDoanh.User;
import qLyFood.FoodList;
import qLyFood.NguyenLieuList;

public class Menu {
	public static String exit ="khong";
	public static User user = new User();
	public static PersonList dsP = new PersonList();
	public static FoodList dsf = new FoodList();
	public static NguyenLieuList dsn = new NguyenLieuList();
	
	public static void docFile() {
		try {
			user.docFile();
		} catch (IOException e) {
			System.out.println("Loi doc File User");
			e.printStackTrace();
		}
		
		dsP.docFileDsPerson();
		try {
			dsf.docFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi doc file Thuc An");
			e.printStackTrace();
		}
		try {
			dsn.docFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi doc file Nguyen Lieu");
			e.printStackTrace();
		}
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
	
	public static void quanLyThucAn() {
		System.out.println("\t•~•quan ly thuc an•~•");int lc =0;
		 do{
			System.out.println(" 1.Hien thi danh sach thuc an\n 2.them thuc an\n 3.Chinh sua\n 4.Xoa\n 5.Tim Kiem\n 6.Sap xep\n 7.Quay lai");
			
			System.out.println("Nhap chuc nang: ");
			lc=new Scanner(System.in).nextInt();
			if(lc<1&& lc>7) {
				System.out.println("Ban da nhap sai yeu cau");
			}
		}while(lc<1&& lc>7);
		switch (lc) {
			case 1: {
				dsf.xuatDs();
			}
			case 2:{
				dsf.them();
			}
			case 3:{
				dsf.sua();
			}
			case 4:{
				dsf.xoa();
			}
			case 5:{
				dsf.timKiem();
			}
			case 6:{
				dsf.sapXep();
			}
			case 7:{
				quanLy();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + lc);
		}
		
	}
	
	public static void quanLyNguyenLieu() {
		System.out.println("\t•~•quan ly Nguyen Lieu•~•");int lc =0;
		do{
			System.out.println(" 1.Hien thi danh sach Nguyen Lieu\n 2.them Nguyen Lieu\n 3.Chinh sua\n 4.Xoa\n 5.Tim Kiem\n 6.Sap xep\n 7.Quay lai");
			
			System.out.println("Nhap chuc nang: ");
			lc=new Scanner(System.in).nextInt();
			if(lc<1&& lc>7) {
				System.out.println("Ban da nhap sai yeu cau");
			}
		}while(lc<1&& lc>7) ;
		switch (lc) {
		case 1: {
			dsn.xuatDs();
		}
		case 2:{
			dsn.them();
		}
		case 3:{
			dsn.sua();
		}
		case 4:{
			dsn.xoa();
		}
		case 5:{
			dsn.timKiem();
		}
		case 6:{
			dsn.sapXep();
		}
		case 7:{
			quanLy();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + lc);
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
			quanLyThucAn();
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
			quanLyNguyenLieu();

		}
		else {
			System.out.println("Ban da nhap sai yeu cau");
		}
	}
	
	public static void nhanVien() {
		while(true) {
			System.out.println("Ban muon xem thong tin cua Mon An nao: ");
			System.out.println("0. Thoat");
			System.out.println("1. Tim Kiem Mon An");
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
				dsf.timKiem();
			}
			default:
				System.out.println("Ban da nhap sai yeu cau de bai");
			}
		}
		
	}
	
	public static void quanLyNhanVien() {
		Scanner sc = new Scanner(System.in);
		PersonList dsP = new PersonList();
		
		
		dsP.docFileDsPerson();
		int function = 0;
        do{
            System.out.println("\t•~•quan ly nhan vien•~•");
            System.out.println(" 1.Hien thi danh sach nhan vien\n 2.them nhan vien\n 3.Chinh sua\n 4.Xoa\n 5.Tim Kiem\n 6.Sap xep\n 7.Quay lai");
            try{
            	System.out.println("Nhap chuc nang: ");
            function=Integer.parseInt(sc.nextLine());
            switch(function)
            {
                case 1:dsP.xuatDS();break;
                case 2:dsP.themDS();break;
                case 3:dsP.suaDS();break;
                case 4:dsP.xoaDS();break;
                case 5:{
                	System.out.println("1.Tim kiem theo ID");
                	System.out.println("2.Tim kiem theo ten");
                	boolean checkOption = true;
                	int option = 0;
                	while(checkOption) {
                    	System.out.println("Vui long nhap lua chon: ");
                    	option = sc.nextInt();
                    	if(option == 1 || option ==2) {
                    		checkOption = false;
                    	}
                    	else {
                    		System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    	}
                	}
                	if(option==1) {
                		
                		dsP.searchByID();
                		String temp = sc.nextLine();
                		break;
                	}
                	else if(option ==2) {
                		dsP.searchByName();
                		String temp = sc.nextLine();
                		break;
                	}
                	
                	
                	break;
                }
                case 6:{
                	dsP.sortByName();
                	dsP.xuatDS();
                	
                	break;
                }
                case 7:{
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
                default: System.out.println("Vui long nhap dung chuc nang!!");break;
            }
            }catch(NumberFormatException E)
            {
                System.out.println("Gia tri can nhap la so!!");
            }
        }while(function!=7);
		
	}
	
	
	public static void menu() {
		int vaiTro = user.dangNhap();
		if(vaiTro==1) {
			quanLy();
		}
		else if(vaiTro == 2) {
			System.out.println("Moi ban chon chuc nang: ");
			System.out.println("1. Quan Ly Nhan Vien");
			System.out.println("Phan Tich Thong So Ban Hang");
			int lc = new Scanner(System.in).nextInt();
			if(lc==1) {
				quanLyNhanVien();
			}
			else if(lc==2) {
				
			}
			
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
