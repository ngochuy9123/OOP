package lop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import kinhDoanh.User;

public class Test {
	public static void main(String[] args) throws IOException  {
//		String[] test = new String[5];
//		test[0] = "Hello";
//		test[1] = "Nguyen Hong Son";
//		test[2] = "Do Dang Khoa";
//		test[3]="Nguyen Ngoc Huy";
//		test[4]="Nguyen Minh Tien";
//		
//		String found[]= new String[0];
//		for(String t:test) {
//			
//			if(t.toLowerCase().contains("nguy")) {
//				found = Arrays.copyOf(found, found.length+1);
//				found[found.length-1]=t;
//				System.out.println(found[ found.length-1]);
//				
//			}
//		}
		
		
//		Thit t = new Thit();
//		t.docFile();
//		Arrays.sort(t.dsThit, (a, b) -> a.getTenNguyenLieu().compareTo(b.getTenNguyenLieu()));
//		for(Thit te:t.dsThit) {
//			System.out.println(te.getTenNguyenLieu());
//			
//
//			
//		}
		
//		int[] t = new int[2];
//		t[0]=5;
//		t[1]=10;
//		for(int i=0;i<2;i++) {
//			System.out.print("Ten: ");
//			for(int h=0;h<t[i];h++)
//				System.out.print("-");
//			System.out.println(200);
//		}
		
		
//		Thit t = new Thit();
//		t.docFile();
//		t.them();
//		TraiCay tc = new TraiCay();
//		tc.docFile();
//		for(TraiCay t:TraiCay.dsTraiCay)
//			System.out.println(t.getTenNguyenLieu());
//		tc.them();
		
		Hambuger ham = new Hambuger();
		ham.docFile();
		String exit ="khong";
		do {
			System.out.println(
	                "\nPlease choice:             \n"
				  + "0. Thoat               \n"
	              + "1. Them               \n"
	              + "2. Xoa             \n"
	              + "3. Sua                \n"
	              + "4. tim kiem                \n"
	              + "5. sap xep                     "
				);
			int i = new Scanner(System.in).nextInt();
			switch (i) {
			case 0:{
				exit="co";
			}
			case 1: {
				ham.them();
				break;
			}
			case 2: {
				ham.xoa();
				break;
			}
			case 3: {
				ham.sua();
				break;
			}
			case 4: {
				ham.timKiem();
				break;
			}
			case 5: {
				ham.sapXep();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		}while(exit!="co");
		

			
		for(Hambuger h:Hambuger.dsHambuger) {
			System.out.println(h.getTenMonAn());
		}
		
//		User u = new User();
//		u.docFile();
//		System.out.println(u.dangNhap());
			
		
		
	}
}
