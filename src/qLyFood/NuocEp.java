package qLyFood;

import java.util.Scanner;

public class NuocEp extends Food {
	private int idTraiCay;

	public NuocEp() {
		super();
	}
	public NuocEp(int id, String tenMonAn, double gia, String loai) {
		super(id, tenMonAn, gia, loai);
	}
	public NuocEp(int id, String tenMonAn, double gia, String loai, int idTraiCay) {
		super(id, tenMonAn, gia, loai);
		this.idTraiCay = idTraiCay;
	}
	public int getIdTraiCay() {
		return idTraiCay;
	}
	public void setIdTraiCay(int idTraiCay) {
		this.idTraiCay = idTraiCay;
	}

	@Override
	public double giaBan() {
		for(NguyenLieu nl:NguyenLieuList.dsnl) {
			if(nl.getIdNguyenLieu()==idTraiCay) {
				return nl.getGia()+getGiaLoi();
			}
		}
		return 0;
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
		
		setIdTraiCay(id);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("|%-3s |", idTraiCay);
	}
}
