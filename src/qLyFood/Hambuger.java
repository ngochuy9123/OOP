package qLyFood;

import java.util.Scanner;

public class Hambuger extends Food {
	private int idNguyenLieuThit;

	public Hambuger() {
		super();
	}
	public Hambuger(int id, String tenMonAn, double gia, String loai) {
		super(id, tenMonAn, gia, loai);
	}
	public Hambuger(int id, String tenMonAn, double gia, String loai, int idNguyenLieuThit) {
		super(id, tenMonAn, gia, loai);
		this.idNguyenLieuThit = idNguyenLieuThit;
	}
	public int getIdNguyenLieuThit() {
		return idNguyenLieuThit;
	}
	public void setIdNguyenLieuThit(int idNguyenLieuThit) {
		this.idNguyenLieuThit = idNguyenLieuThit;
	}
	
	@Override
	public void nhapthongtin() {
		// TODO Auto-generated method stub
		super.nhapthongtin();
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
		
		setIdNguyenLieuThit(id);
	}
	
	@Override
	public double giaBan() {
		for(NguyenLieu nl:NguyenLieuList.dsnl) {
			if(nl.getIdNguyenLieu()==idNguyenLieuThit) {
				return nl.getGia()+getGiaLoi();
			}
		}
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("|%-20s |", idNguyenLieuThit);
	}
	
}
