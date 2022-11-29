package qLyFood;

import java.util.Calendar;
import java.util.Scanner;

import kinhDoanh.Person;
import kinhDoanh.PersonList;

public abstract class Food  {
	private int id;
	private String tenMonAn;
	private double giaLoi;
	private String loai;
	public Food() {
		super();
	}
	public Food(int id, String tenMonAn, double gia, String loai) {
		super();
		this.id = id;
		this.tenMonAn = tenMonAn;
		this.giaLoi = gia;
		this.loai = loai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenMonAn() {
		return tenMonAn;
	}
	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}
	public double getGiaLoi() {
		return giaLoi;
	}
	public void setGiaLoi(double giaLoi) {
		this.giaLoi = giaLoi;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	public void nhapthongtin() {
		boolean check1 =true;int id = 0;
		do {
			System.out.println("Nhap ID: ");
			id = new Scanner(System.in).nextInt();
			boolean flag = true;
			for(Food f:FoodList.dsFood) {
				if(f.getId() == id) {
					System.out.println("ID da ton tai, Vui long nhap lai ID");
					flag = false;
				}
			}
			if(flag == true)
				check1 = false;
		}while(check1==true);
		
		System.out.println("Moi ban nhap ten mon an: ");
		String tenMonAn = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia loi ma ban muon: ");
		double giaLoi = new Scanner(System.in).nextDouble();
		String loai = "";
		boolean check2 = true;
		while(check2 == true) {
			System.out.println("Moi ban nhap loai mon an('hambuger','gachien','nuocep','nuoccoga'): ");
			loai = new Scanner(System.in).nextLine();
			loai = loai.toLowerCase();
			if(loai.equals("hambuger")||loai.equals("gachien")||loai.equals("nuocep")||loai.equals("nuoccoga")) {
				check2 = false;
			}
			else {
				System.out.println("Ban da nhap sai ten Loai ");
				
			}
		}
		setTenMonAn(tenMonAn);
		setId(id);
		setLoai(loai);
		setGiaLoi(giaLoi);
	}
	
	
	public abstract double giaBan();
	
	@Override
	public String toString() {
		return String.format("|%-3s | %-26s | %-5s | %-10s  ",
		        id, tenMonAn,giaLoi,loai);
	}
}
