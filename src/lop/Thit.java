package lop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Thit extends NguyenLieu {
	
	public String moTa;
	private String File_Thit = "./src/file/Thit";
	public static Thit[] dsThit = new Thit[0];
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public Thit() {
		super();
	}

	public Thit(int id, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong) {
		super(id, tenNguyenLieu, gia, hanSuDung, soLuong);
	}

	public Thit(int id, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String moTa) {
		super(id, tenNguyenLieu, gia, hanSuDung, soLuong);
		
		this.moTa = moTa;
	}

	

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public static Thit[] getDsThit() {
		return dsThit;
	}

	public static void setDsThit(Thit[] dsThit) {
		Thit.dsThit = dsThit;
	}

	
	
	
	@Override
	public void them() {
		
		dsThit = Arrays.copyOf(dsThit, dsThit.length+1);
		
		System.out.println("Moi ban nhap id");
		int id = new Scanner(System.in).nextInt();
		if(ktTrung(id)==true) {
			System.out.println("Id nay da ton tai");
			them();
		}
			
		
		System.out.println("Moi ban nhap ten nguyen lieu");
		String tenNL = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia Nguyen Lieu");
		double gia = new Scanner(System.in).nextDouble();
		System.out.println("Moi ban nhap ngay het han");
		String ngay = new Scanner(System.in).nextLine();
		Date ngayhh = null;
		try {
			ngayhh = (Date)df.parse(ngay);
		} catch (ParseException e) {
			System.out.println("Loi Them Ngay");
			e.printStackTrace();
		}
		System.out.println("Moi ban nhap so luong");
		int sl = new Scanner(System.in).nextInt();
		System.out.println("Moi ban nhap mo ta");
		String moTa = new Scanner(System.in).nextLine();
		dsThit[dsThit.length-1] = new Thit(id, tenNL, gia,ngayhh , sl, moTa);
			
		try {
				ghiFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi ghi file");
				e.printStackTrace();
		}
		System.out.println("Hello World");
	}

	@Override
	public void xoa() {
		System.out.println("Moi ban nhap id san pham ma ban muon xoa");
		int id = new Scanner(System.in).nextInt();
		Thit[] dst = new Thit[0];
		for(Thit t:dsThit) {
			if(t.getId() == id)
				System.out.println("xoa"+t.getId());
			else {
				dst = Arrays.copyOf(dst, dst.length+1);
				dst[dst.length-1] = new Thit(t.getId(), t.getTenNguyenLieu(), t.getGia(), t.getHanSuDung(), t.getSoLuong(), t.getMoTa());
				
			}
			
		}
		dsThit = Arrays.copyOf(dst, dst.length);
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi ghi file");
			e.printStackTrace();
		}
	}

	@Override
	public void sua() {
		System.out.println("Moi ban nhap id Nguyen Lieu ma ban muon sua");
		int id = new Scanner(System.in).nextInt();
		String temp = null;
		for(Thit t:dsThit) {
			if(t.getId()==id) {
				System.out.println("Ban muon sua cai gi");
				System.out.println("1. Ten Nguyen Lieu");
				System.out.println("2. Gia");
				System.out.println("3. Han Su Dung");
				System.out.println("4. So Luong");
				System.out.println("5. Mo Ta");
				int i = new Scanner(System.in).nextInt();
				switch (i) {
				case 1: {
					System.out.println("Ten Nguyen Lieu Ban Dau la:");
					System.out.println(t.getTenNguyenLieu());
					System.out.println("Moi ban nhap Ten Nguyen Lieu moi:");
					temp = new Scanner(System.in).nextLine();
					t.setTenNguyenLieu(temp);
					System.out.println("Da Thay Doi Ten Nguyen Lieu");
					break;
				}
				
//				Lam Tiep Buoc Nay
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + i);
				}
			}
				
		}
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("loi ghi FIle");
			e.printStackTrace();
		}
	}

	@Override
	public void timKiem() {
		Arrays.sort(dsThit, (a, b) -> a.getTenNguyenLieu().compareTo(b.getTenNguyenLieu()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(Thit t:dsThit) {
			if(t.getTenNguyenLieu().toLowerCase().contains(key))
				System.out.println(t.getTenNguyenLieu());
		}
			
		
	}

	@Override
	public void docFile() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(File_Thit);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line!=null) {
				String[] arr = line.split(";");
				
				if(arr.length==6) {
					dsThit = Arrays.copyOf(dsThit, dsThit.length+1);
					dsThit[dsThit.length-1] = new Thit(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),(Date)df.parse(arr[3]),Integer.parseInt(arr[4]),arr[5]);
				}
				
				line = br.readLine();
			}
			
			
			br.close();
			isr.close();
			fis.close();
			System.out.println("Doc Thanh Cong");
		} catch (FileNotFoundException | NumberFormatException | ParseException e) {
			System.out.println("Loi Date");
			e.printStackTrace();
		}
		
	}

	@Override
	public void ghiFile() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(File_Thit);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			for(Thit t:dsThit) {
				String line = t.getId()+";"+t.getTenNguyenLieu()+";"+t.getGia()+";"+df.format(t.getHanSuDung()) +";"+t.getSoLuong()+";"+t.getMoTa();
				bw.write(line);
				bw.newLine();	
			}
			bw.close();
			fos.close();
			osw.close();
			System.out.println("Ghi thanh Cong");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean ktTrung(int id) {
		for(Thit t:dsThit)
			if(t.getId()==id)
				return true;
		return false;
	}
	
	
	
//	@Override
//	public int compareTo(Thit o) {
//		System.out.println("Moi ban cho thu can sap xep");
//		return this.getTenNguyenLieu().compareToIgnoreCase(o.getTenNguyenLieu());
//	}

	@Override
	public void sapXep() {
		
		Thit temp = new Thit();
		System.out.println("Moi ban nhap thu can sap xep");
		System.out.println("1. id");
		System.out.println("2. Ten Nguyen Lieu");
		System.out.println("3. gia");
		System.out.println("4. Ngay Het Han");
		int i = new Scanner(System.in).nextInt();
		switch (i) {
		case 1: {
			sapXepTheoId();
			break;
		}
		case 2:{
			sapXepTheoTen();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
		
//		Xuat Danh Sach
		for(Thit te:dsThit)
			System.out.println(te.getId()+"\t"+te.getTenNguyenLieu());
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi Ghi File");
			e.printStackTrace();
		}
		
	}

	@Override
	public void xuatDs() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("", dsThit);
	}

	@Override
	public void themNSp() {
		System.out.println("Moi ban nhap so luong nguyen lieu Thit ma ban muon them");
		int n = new Scanner(System.in).nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Moi ban nhap nguyen lieu thu "+(i+1));
			them();
		}
	}

	
	public void swap(Thit a, Thit b) {
		Thit t = a;
		a=b;
		b=t;
		
	}

	@Override
	public void sapXepTheoTen() {
		Arrays.sort(dsThit, (a, b) -> a.getTenNguyenLieu().compareTo(b.getTenNguyenLieu()));
		
	}

	@Override
	public void sapXepTheoGia() {
		Thit t = new Thit();
		for(int j=0;j<dsThit.length;j++) {
			for(int h=j+1;h<dsThit.length;h++) {
				if(dsThit[j].getGia()>dsThit[h].getGia()) {
					t= dsThit[j];
					dsThit[j] = dsThit[h];
					dsThit[h] = t;
				}	
			}
		}
		
	}

	@Override
	public void sapXepTheoId() {
		Thit t = new Thit();
		for(int j=0;j<dsThit.length;j++) {
			for(int h=j+1;h<dsThit.length;h++) {
				if(dsThit[j].getId()>dsThit[h].getId()) {
					t= dsThit[j];
					dsThit[j] = dsThit[h];
					dsThit[h] = t;
				}	
			}
		}
	}
	
}
