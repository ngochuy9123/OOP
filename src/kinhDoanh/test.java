package kinhDoanh;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
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
                case 7:break;
                default: System.out.println("Vui long nhap dung chuc nang!!");break;
            }
            }catch(NumberFormatException E)
            {
                System.out.println("Gia tri can nhap la so!!");
            }
        }while(function!=7);
		
		
	}
}
