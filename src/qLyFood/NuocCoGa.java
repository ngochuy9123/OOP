package qLyFood;

import java.util.Scanner;

public class NuocCoGa extends Food {
	private String hangNuoc;
	private double giaNhapHang;
	public NuocCoGa() {
		super();
	}
	public NuocCoGa(int id, String tenMonAn, double gia, String loai) {
		super(id, tenMonAn, gia, loai);
	}
	public NuocCoGa(int id, String tenMonAn, double gia, String loai, String hangNuoc, double giaNhapHang) {
		super(id, tenMonAn, gia, loai);
		this.hangNuoc = hangNuoc;
		this.giaNhapHang = giaNhapHang;
	}
	public String getHangNuoc() {
		return hangNuoc;
	}
	public void setHangNuoc(String hangNuoc) {
		this.hangNuoc = hangNuoc;
	}
	public double getGiaNhapHang() {
		return giaNhapHang;
	}
	public void setGiaNhapHang(double giaNhapHang) {
		this.giaNhapHang = giaNhapHang;
	}
	@Override
	public double giaBan() {
		// TODO Auto-generated method stub
		return getGiaLoi()+giaNhapHang;
	}
	
	@Override
	public void nhapthongtin() {
		// TODO Auto-generated method stub
		super.nhapthongtin();
		System.out.println("Moi ban nhap Hang Nuoc: ");
		String hangNuoc = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia nhap hang: ");
		double gia = new Scanner(System.in).nextDouble();
		
		setHangNuoc(hangNuoc);
		setGiaNhapHang(gia);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("|%-20s |%-20s |", hangNuoc,giaNhapHang);
	}
}
