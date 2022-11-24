package lop;

import java.io.IOException;

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
	
	
	
	
	public static void menu() {
		try {
			user.docFile();
		} catch (IOException e) {
			System.out.println("Loi Doc File Log in");
			e.printStackTrace();
		}
		if(user.dangNhap()==1) {
			System.out.println("Quan Ly");
		}
	}
	public static void main(String[] args) {
		menu();
	}
}
