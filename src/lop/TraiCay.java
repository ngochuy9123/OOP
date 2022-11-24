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

public class TraiCay extends NguyenLieu {
	private String ghiChu;
	private String noiNhap;
	public static TraiCay[] dsTraiCay = new TraiCay[0];
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private String File_Trai_Cay = "./src/file/TraiCay";
	
	
	public TraiCay() {
		super();
	}
	public TraiCay(int id, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong) {
		super(id, tenNguyenLieu, gia, hanSuDung, soLuong);
	}
	public TraiCay(int id, String tenNguyenLieu, double gia, Date hanSuDung, int soLuong, String ghiChu,
			String noiNhap) {
		super(id, tenNguyenLieu, gia, hanSuDung, soLuong);
		this.ghiChu = ghiChu;
		this.noiNhap = noiNhap;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNoiNhap() {
		return noiNhap;
	}
	public void setNoiNhap(String noiNhap) {
		this.noiNhap = noiNhap;
	}
	public static TraiCay[] getDsTraiCay() {
		return dsTraiCay;
	}
	public static void setDsTraiCay(TraiCay[] dsTraiCay) {
		TraiCay.dsTraiCay = dsTraiCay;
	}
	@Override
	public void them() {
		// TODO Auto-generated method stub
		
		System.out.println("Moi ban nhap id");
		int id = new Scanner(System.in).nextInt();
		if(ktTrung(id)==true) {
			System.out.println("Id nay da ton tai");
			
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
		System.out.println("Moi ban nhap noi nhap hang");
		String noiNhapHang = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap ghi chu");
		String ghiChu = new Scanner(System.in).nextLine();
		dsTraiCay = Arrays.copyOf(dsTraiCay, dsTraiCay.length+1);
		dsTraiCay[dsTraiCay.length-1] = new TraiCay(id, tenNL, gia, ngayhh, sl, ghiChu, noiNhapHang);
		ghiFile();
	}
	@Override
	public void xoa() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sua() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void docFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(File_Trai_Cay);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line!=null) {
				String[] arr = line.split(";");
				
				if(arr.length==7) {
					dsTraiCay = Arrays.copyOf(dsTraiCay, dsTraiCay.length+1);
					dsTraiCay[dsTraiCay.length-1] = new TraiCay(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),(Date)df.parse(arr[3]),Integer.parseInt(arr[4]),arr[5],arr[6]);
				}
				
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
			System.out.println("Doc Thanh Cong");
		} catch (FileNotFoundException e) {
			System.out.println("Khong Tim Thay File");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Khong doc duoc dong");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Loi Chuyen sang Ngay");
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public void ghiFile() {
		try {
			FileOutputStream fos = new FileOutputStream(File_Trai_Cay);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			for(TraiCay t:dsTraiCay) {
				String line = t.getId()+";"+t.getTenNguyenLieu()+";"+t.getGia()+";"+df.format(t.getHanSuDung()) +";"+t.getSoLuong()+";"+t.getNoiNhap()+";"+t.getGhiChu();
				bw.write(line);
				bw.newLine();	
			}
			bw.close();
			fos.close();
			osw.close();
			System.out.println("Ghi thanh Cong");
			
		} catch (IOException e) {
			System.out.println("Loi ghi file");
			e.printStackTrace();
		}
		
	}
	@Override
	public void xuatDs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void themNSp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean ktTrung(int id) {
		for(TraiCay tc:dsTraiCay) {
			if(tc.getId() == id)
				return true;
		}
		return false;
	}
	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoTen() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoGia() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoId() {
		// TODO Auto-generated method stub
		
	}
	
	
}
