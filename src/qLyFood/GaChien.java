package qLyFood;

import java.util.Scanner;

public class GaChien extends Food {
	private int slgGa;
	private int idLoaiGa;
	public GaChien() {
		super();
	}
	public GaChien(int id, String tenMonAn, double gia, String loai) {
		super(id, tenMonAn, gia, loai);
	}
	public GaChien(int slgGa, int idLoaiGa) {
		super();
		this.slgGa = slgGa;
		this.idLoaiGa = idLoaiGa;
	}
	public int getSlgGa() {
		return slgGa;
	}
	public void setSlgGa(int slgGa) {
		this.slgGa = slgGa;
	}
	public int getIdLoaiGa() {
		return idLoaiGa;
	}
	public void setIdLoaiGa(int idLoaiGa) {
		this.idLoaiGa = idLoaiGa;
	}
	@Override
	public double giaBan() {
		for(NguyenLieu nl:NguyenLieuList.dsnl) {
			if(nl.getIdNguyenLieu()==idLoaiGa) {
				return nl.getGia()*slgGa+getGiaLoi();
			}
		}
		return 0;
	}
	
	@Override
	public void nhapthongtin() {
		// TODO Auto-generated method stub
		super.nhapthongtin();
		
		System.out.println("Moi ban nhap so luong ga: ");
		int slg = new Scanner( System.in).nextInt();
		
		boolean check = true; int id =0;
		while(check == true) {
			System.out.println("Moi ban nhap id Nguyen Lieu");
			boolean flag  = false;
			id = new Scanner(System.in).nextInt();
			for(NguyenLieu nl:NguyenLieuList.dsnl) {
				if(nl.getIdNguyenLieu()==id) {
					flag = true;
				}
			}
			if(flag == true) {
				check = false;
			}
			else {
				System.out.println("Id Nguyen lieu nay khong ton tai ");
			}
		}
		
		setSlgGa(slg);
		setIdLoaiGa(id);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+String.format("|%-3s | %-3s |", slgGa,idLoaiGa);
	}
	
}
