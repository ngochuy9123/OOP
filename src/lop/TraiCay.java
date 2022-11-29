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
	private static String File_Trai_Cay = "./src/file/TraiCay";
	
	
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
		int test =1;
		int id =0;
		while(test==1) {
			System.out.println("Moi ban nhap id San Pham");
			id = new Scanner(System.in).nextInt();
			if(ktTrung(id)==true) {
				System.out.println("Id nay da ton tai");
				
			}
			else {
				test = 0;
			}
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
		System.out.println("Moi ban nhap id san pham ma ban muon xoa");
		int id = new Scanner(System.in).nextInt();
		if(ktTrung(id)==false)
			System.out.println("Id khong ton tai");
		else {
			TraiCay[] dst = new TraiCay[0];
			for(TraiCay t:dsTraiCay) {
				if(t.getId() == id)
					System.out.println("xoa"+t.getId());
				else {
					dst = Arrays.copyOf(dst, dst.length+1);
					dst[dst.length-1] = new TraiCay(t.getId(), t.getTenNguyenLieu(), t.getGia(), t.getHanSuDung(), t.getSoLuong(), t.getGhiChu(),t.getNoiNhap());
					
				}
				
			}
			dsTraiCay = Arrays.copyOf(dst, dst.length);
			ghiFile();
			
			System.out.println("Ban co muon xoa tiep khong ----- Nhan 'y' de xoa tiep");
			String c = new Scanner(System.in).nextLine();
			if(c.equals("y"))
				xoa();
		}
		
	}
	@Override
	public void sua() {
		System.out.println("Moi ban nhap id Nguyen Lieu ma ban muon sua");
		int id = new Scanner(System.in).nextInt();
		String temp = null;
		if(ktTrung(id)==true) {
			for(TraiCay t:dsTraiCay) {
			if(t.getId()==id) {
				System.out.println("Ban muon sua cai gi");
				System.out.println("1. Ten Nguyen Lieu");
				System.out.println("2. Gia");
				System.out.println("3. Han Su Dung");
				System.out.println("4. So Luong");
				System.out.println("5. Ghi Chu");
				System.out.println("6. Noi Nhap");
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
				
//				
				case 2: {
					System.out.println("Gia Ban Dau la:");
					System.out.println(t.getGia());
					System.out.println("Moi ban nhap Gia moi:");
					temp = new Scanner(System.in).nextLine();
					t.setGia(Double.parseDouble(temp));
					System.out.println("Da Thay Doi Gia");
					break;
				}
				case 3: {
					System.out.println("Han Su Dung Ban Dau la:");
					System.out.println(t.getHanSuDung());
					System.out.println("Moi ban nhap Han Su Dung moi:");
					temp = new Scanner(System.in).nextLine();
					Date time = null;
					try {
						time = (Date)df.parse(temp);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t.setHanSuDung(time);
					System.out.println("Da Thay Doi Han Su Dung");
					break;
				}
				case 4: {
					System.out.println("So Luong Ban Dau la:");
					System.out.println(t.getSoLuong());
					System.out.println("Moi ban nhap So Luong moi:");
					temp = new Scanner(System.in).nextLine();
					t.setSoLuong(Integer.parseInt(temp));
					System.out.println("Da Thay Doi So Luong");
					break;
				}
				case 5: {
					System.out.println("Ghi Chu Ban Dau la:");
					System.out.println(t.getGhiChu());
					System.out.println("Moi ban nhap Ghi Chu moi:");
					temp = new Scanner(System.in).nextLine();
					t.setTenNguyenLieu(temp);
					System.out.println("Da Thay Doi Ghi Chu");
					break;
				}
				case 6: {
					System.out.println("Noi Nhap Ban Dau la:");
					System.out.println(t.getGhiChu());
					System.out.println("Moi ban nhap Noi Nhap moi:");
					temp = new Scanner(System.in).nextLine();
					t.setTenNguyenLieu(temp);
					System.out.println("Da Thay Doi Noi Nhap");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + i);
				}
			}
		}
		
		}
	}
	@Override
	public void timKiem() {
		Arrays.sort(dsTraiCay, (a, b) -> a.getTenNguyenLieu().compareTo(b.getTenNguyenLieu()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(TraiCay t:dsTraiCay) {
			if(t.getTenNguyenLieu().toLowerCase().contains(key))
				System.out.println(t.getTenNguyenLieu());
		}
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
		System.out.println("Danh Sach cua Nguyen Lieu Trai Cay la: ");
		System.out.printf("|%-2s | %-20s | %-6s | %-7s | %-2s | %-20s|%-10s","ID", "Ten Nguyen Lieu","Gia","Han Su Dung","So Luong", "Ghi Chu","Noi Nhap");
		for(TraiCay t:dsTraiCay) {
			System.out.println(t.toString());
		}
			
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
		TraiCay temp = new TraiCay();
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
		
		ghiFile();
		
	}
	@Override
	public void sapXepTheoTen() {
		Arrays.sort(dsTraiCay, (a, b) -> a.getTenNguyenLieu().compareTo(b.getTenNguyenLieu()));
		
	}
	@Override
	public void sapXepTheoGia() {
		TraiCay t = new TraiCay();
		for(int j=0;j<dsTraiCay.length;j++) {
			for(int h=j+1;h<dsTraiCay.length;h++) {
				if(dsTraiCay[j].getGia()>dsTraiCay[h].getGia()) {
					t= dsTraiCay[j];
					dsTraiCay[j] = dsTraiCay[h];
					dsTraiCay[h] = t;
				}	
			}
		}
		
	}
	@Override
	public void sapXepTheoId() {
		TraiCay t = new TraiCay();
		for(int j=0;j<dsTraiCay.length;j++) {
			for(int h=j+1;h<dsTraiCay.length;h++) {
				if(dsTraiCay[j].getId()>dsTraiCay[h].getId()) {
					t= dsTraiCay[j];
					dsTraiCay[j] = dsTraiCay[h];
					dsTraiCay[h] = t;
				}	
			}
		}
		
	}
	
	@Override
	public String toString() {
		
		return super.toString() + String.format("| %-20s| %-10s", ghiChu,noiNhap);
	}
}
