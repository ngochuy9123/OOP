package lop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class NuocCoGa extends Food {
	private String tenHangNuoc;
	private double giaNhapHang;
	public static NuocCoGa[] dsNuocCoGa = new NuocCoGa[0];
	public static String File_Nuoc_Co_Ga = "./src/file/NuocCoGa";
	
	public NuocCoGa() {
		super();
	}
	public NuocCoGa(int id, String tenMonAn, double gia) {
		super(id, tenMonAn, gia);
	}
	public NuocCoGa(int id, String tenMonAn, double gia, String tenHangNuoc, double giaNhapHang) {
		super(id, tenMonAn, gia);
		this.tenHangNuoc = tenHangNuoc;
		this.giaNhapHang = giaNhapHang;
	}
	
	
	
	public String getTenHangNuoc() {
		return tenHangNuoc;
	}
	public void setTenHangNuoc(String tenHangNuoc) {
		this.tenHangNuoc = tenHangNuoc;
	}
	public double getGiaNhapHang() {
		return giaNhapHang;
	}
	public void setGiaNhapHang(double giaNhapHang) {
		this.giaNhapHang = giaNhapHang;
	}
	public static NuocCoGa[] getDsNuocCoGa() {
		return dsNuocCoGa;
	}
	public static void setDsNuocCoGa(NuocCoGa[] dsNuocCoGa) {
		NuocCoGa.dsNuocCoGa = dsNuocCoGa;
	}
	public static String getFile_Nuoc_Co_Ga() {
		return File_Nuoc_Co_Ga;
	}
	public static void setFile_Nuoc_Co_Ga(String file_Nuoc_Co_Ga) {
		File_Nuoc_Co_Ga = file_Nuoc_Co_Ga;
	}
	
	@Override
	public boolean ktTrung(int id) {
		for(NuocCoGa nc: dsNuocCoGa)
			if(nc.getId()==id)
				return true;
		return false;
	}
	@Override
	public void xuatDs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void them() {
		System.out.println("Moi ban nhap id San Pham");
		int id = new Scanner(System.in).nextInt();
		if(ktTrung(id)==true) {
			System.out.println("Id nay da ton tai");
			them();
		}
		System.out.println("Moi ban nhap ten San Pham");
		String tenSp = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia San Pham");
		double gia = new Scanner(System.in).nextDouble();
		System.out.println("Moi ban nhap ten Hang");
		String tenHang = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia Nhap Hang");
		double giaNhapHang = new Scanner(System.in).nextDouble();
		dsNuocCoGa = Arrays.copyOf(dsNuocCoGa, dsNuocCoGa.length+1);
		dsNuocCoGa[dsNuocCoGa.length-1] = new NuocCoGa(id, tenSp, gia, tenHang,giaNhapHang);
		
		try {
			ghiFile();
		} catch (IOException e) {
			System.out.println("loi ghi file");
			e.printStackTrace();
		}
		
	}
	@Override
	public void themNSp() {
		System.out.println("Moi ban nhap so luong san pham ma ban muon them: ");
		int n = new Scanner(System.in).nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Moi ban nhap san pham thu "+i);
			them();
		}
		
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
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_Nuoc_Co_Ga);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==5) {
				dsNuocCoGa = Arrays.copyOf(dsNuocCoGa, dsNuocCoGa.length+1);
				dsNuocCoGa[dsNuocCoGa.length-1] = new NuocCoGa(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),arr[3],Double.parseDouble(arr[4]));
			}
			
			line = br.readLine();
		}
		
		
		br.close();
		isr.close();
		fis.close();
		System.out.println("Doc Thanh Cong");
		
	}
	@Override
	public void ghiFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(File_Nuoc_Co_Ga);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(NuocCoGa t:dsNuocCoGa) {
			String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGia()+";"+t.getTenHangNuoc()+";"+t.getGiaNhapHang();
			bw.write(line);
			bw.newLine();	
		}
		bw.close();
		fos.close();
		osw.close();
		System.out.println("Ghi thanh Cong");
		
	}
	@Override
	public double setGiaBan() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
