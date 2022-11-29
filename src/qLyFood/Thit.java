package qLyFood;

import java.util.Date;
import java.util.Scanner;

public class Thit extends NguyenLieu {
	private String moTa;

	public Thit() {
		super();
	}
	public Thit(int idNguyenLieu, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String loai) {
		super(idNguyenLieu, tenNguyenLieu, gia, hanSuDung, soLuong, loai);
	}
	public Thit(int idNguyenLieu, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String loai,
			String moTa) {
		super(idNguyenLieu, tenNguyenLieu, gia, hanSuDung, soLuong, loai);
		this.moTa = moTa;
	}
	
	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public void nhapThongTin() {
		// TODO Auto-generated method stub
		super.nhapThongTin();
		System.out.println("Moi ban nhap phan mo ta: ");
		String mt = new Scanner(System.in).nextLine();
		setMoTa(mt);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("|%-26s |", moTa);
	}
}
