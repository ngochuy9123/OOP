package qLyFood;

import java.util.Date;
import java.util.Scanner;

public class TraiCay extends NguyenLieu {
	private String noiNhap;
	private String ghiChu;
	public TraiCay() {
		super();
	}
	public TraiCay(int idNguyenLieu, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String loai) {
		super(idNguyenLieu, tenNguyenLieu, gia, hanSuDung, soLuong, loai);
	}
	public TraiCay(int idNguyenLieu, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String loai,
			String noiNhap, String ghiChu) {
		super(idNguyenLieu, tenNguyenLieu, gia, hanSuDung, soLuong, loai);
		this.noiNhap = noiNhap;
		this.ghiChu = ghiChu;
	}

	public String getNoiNhap() {
		return noiNhap;
	}
	public void setNoiNhap(String noiNhap) {
		this.noiNhap = noiNhap;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Override
	public void nhapThongTin() {
		// TODO Auto-generated method stub
		super.nhapThongTin();
		System.out.println("Moi ban nhap Noi nhap hang: ");
		String nn = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap ghi chu: ");
		String gc = new Scanner(System.in).nextLine();
		
		setGhiChu(gc);
		setNoiNhap(nn);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+String.format("|%-15s | %-26s |", noiNhap,ghiChu);
	}
}
