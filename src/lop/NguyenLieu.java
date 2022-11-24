package lop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NguyenLieu implements InterDanhSach,InterFile  {
	private int id;
	private String tenNguyenLieu;
	private double gia;//Gia Nhap Hang
	private Date hanSuDung;
	private int soLuong;
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public NguyenLieu() {
		super();
	}
	public NguyenLieu(int id, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong) {
		super();
		this.id = id;
		this.tenNguyenLieu = tenNguyenLieu;
		this.gia = gia;
		this.hanSuDung = hanSuDung;
		this.soLuong = soLuong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return  hanSuDung;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("|%-5s | %-20s | %-8s | %-6s | %-11s ",
		        id, tenNguyenLieu,gia,hanSuDung,soLuong);
	}
	
}
