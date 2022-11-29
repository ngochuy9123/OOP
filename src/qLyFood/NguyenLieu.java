package qLyFood;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class NguyenLieu {
	private int idNguyenLieu;
	private String tenNguyenLieu;
	private double gia;//Gia Nhap Hang
	private Date hanSuDung;
	private int soLuong;
	private String loaiNL;
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public NguyenLieu() {
		super();
	}
	public NguyenLieu(int idNguyenLieu, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong,String loai) {
		super();
		this.idNguyenLieu = idNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.gia = gia;
		this.hanSuDung = hanSuDung;
		this.soLuong = soLuong;
		this.loaiNL = loai;
	}
	
	public String getLoaiNL() {
		return loaiNL;
	}
	public void setLoaiNL(String loaiNL) {
		this.loaiNL = loaiNL;
	}
	public int getIdNguyenLieu() {
		return idNguyenLieu;
	}
	public void setIdNguyenLieu(int idNguyenLieu) {
		this.idNguyenLieu = idNguyenLieu;
	}
	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}
	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public Date getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public static DateFormat getDf() {
		return df;
	}
	public static void setDf(DateFormat df) {
		NguyenLieu.df = df;
	}
	
	public void nhapThongTin() {
		boolean check1 = true;int id =0;
		while(check1==true) {
			System.out.println("Moi ban nhap id ");
			id = new Scanner(System.in).nextInt();
			boolean flag = true;
			for(NguyenLieu nl:NguyenLieuList.dsnl) {
				if(nl.getIdNguyenLieu()==id) {
					System.out.println("Id nay da ton tai");
					flag = false;
				}
					
			}
			if(flag==true) {
				check1 = false;
			}
		}
		System.out.println("Moi ban nhap ten nguyen lieu");
		String tenNl = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia nguyen lieu: ");
		double gia = new Scanner(System.in).nextDouble();
		System.out.println("Moi ban nhap han su dung: ");
		String ngay = new Scanner(System.in).nextLine();
		Date ngayhh = null;
		try {
			ngayhh = (Date)df.parse(ngay);
		} catch (ParseException e) {
			System.out.println("Loi Them Ngay");
			e.printStackTrace();
		}
		System.out.println("Moi ban nhap so luong ton: ");
		int slg = new Scanner(System.in).nextInt();
		
		boolean check2 = true;	String l = "error";
		while(check2==true) {
			System.out.println("Moi ban nhap loai nguyen lieu ('thit','traicay'): ");
			l = new Scanner(System.in).nextLine();
			l = l.toLowerCase();
			if(l.equals("thit") || l.equals("traicay")) {
				check2 = false;
			}
			else {
				System.out.println("Ban da nhap sai Loai ");
			}
		}
		
		
		
		setIdNguyenLieu(id);
		setTenNguyenLieu(tenNl);
		setHanSuDung(ngayhh);
		setGia(gia);
		setSoLuong(slg);
		setLoaiNL(l);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("|%-2s | %-25s | %-6s | %-15s | %-10s | %-10s ",
		        idNguyenLieu, tenNguyenLieu,gia,df.format(hanSuDung),soLuong,loaiNL);
	}
	
}
