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
		System.out.println("Danh Sach cua Mon An Thit la: ");
		System.out.printf("|%-1s | %-20s | %-6s | %-10s | %-10s","ID", "Ten Mon An","Gia","Ten Hang Nuoc","Gia Nhap Hang");
		System.out.println();
		for(NuocCoGa nc:dsNuocCoGa)
			System.out.println(nc.toString());
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
		System.out.println("Moi ban nhap id ma ban can xoa");
		int id = new Scanner(System.in).nextInt();
		NuocCoGa[] dst = new NuocCoGa[0];
		for(NuocCoGa h:dsNuocCoGa) {
			if(h.getId() != id) {
				dst = Arrays.copyOf(dst, dst.length+1);
				dst[dst.length-1] = new NuocCoGa(h.getId(), h.getTenMonAn(), h.getGia(), h.getTenHangNuoc(),h.getGiaNhapHang());
			}
			
		}
		dsNuocCoGa = Arrays.copyOf(dst, dst.length);
		try {
			ghiFile();
		} catch (IOException e) {
			System.out.println("Loi ghi file");
			e.printStackTrace();
		}
		
		System.out.println("Ban co muon xoa tiep khong ----- Nhan 'y' de xoa tiep");
		String c = new Scanner(System.in).nextLine();
		if(c.equals("y"))
			xoa();
	}
	@Override
	public void sua() {
		System.out.println("Moi ban nhap id Mon An ma ban muon sua");
		int id = new Scanner(System.in).nextInt();
		String temp = null;	
		if(ktTrung(id)==false) {
			System.out.println("Khong Ton tai id Thuc An nay;");
		}
		else {
			for(NuocCoGa ham:dsNuocCoGa) {
				if(ham.getId()==id) {
					System.out.println("Ban muon sua cai gi");
					System.out.println("1. Ten Mon An");
					System.out.println("2. Gia");
					System.out.println("3. Id Nguyen Lieu");
					System.out.println("4. Id Nguyen Lieu");
					int lc = new Scanner(System.in).nextInt();
					switch (lc) {
					case 1: {
						System.out.println("Ten Mon An Ban Dau la:");
						
						System.out.println("Moi ban nhap Ten Mon An moi:");
						temp = new Scanner(System.in).nextLine();
						ham.setTenMonAn(temp);
						System.out.println("Da Thay Doi Ten Nguyen Lieu");
						try {
							ham.ghiFile();
						} catch (IOException e) {
							System.out.println("Loi ghi file cap nhat");
							e.printStackTrace();
						}
						break;
						}
					case 2: {
						System.out.println("Gia Ban Dau la:");
						System.out.println(ham.getGia());
						System.out.println("Moi ban nhap Gia moi:");
						double tam = new Scanner(System.in).nextDouble();
						ham.setGia(tam);
						System.out.println("Da Thay Doi Thanh Cong");
						try {
							ham.ghiFile();
						} catch (IOException e) {
							System.out.println("Loi ghi file cap nhat");
							e.printStackTrace();
						}
						break;
					}
					case 3:{
						System.out.println("Ten Hang Nuoc Ban Dau la:");
						System.out.println(ham.getTenHangNuoc());
						System.out.println("Moi ban nhap Ten Hang Nuoc moi:");
						String tam = new Scanner(System.in).nextLine();
						ham.setTenHangNuoc(tam);
						System.out.println("Da Thay Doi Thanh Cong");
						try {
							ham.ghiFile();
						} catch (IOException e) {
							System.out.println("Loi ghi file cap nhat");
							e.printStackTrace();
						}
						break;
					}
					case 4:{
						System.out.println("Gia Nhap Hang Ban Dau la:");
						System.out.println(ham.getGiaNhapHang());
						System.out.println("Moi ban nhap Ten Hang Nuoc moi:");
						Double tam = new Scanner(System.in).nextDouble();
						ham.setGiaNhapHang(tam);
						System.out.println("Da Thay Doi Thanh Cong");
						try {
							ham.ghiFile();
						} catch (IOException e) {
							System.out.println("Loi ghi file cap nhat");
							e.printStackTrace();
						}
						break;
					}
					
					}
				}
			}
		}
	}
	@Override
	public void timKiem() {
		Arrays.sort(dsNuocCoGa, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(NuocCoGa h:dsNuocCoGa)
			if(h.getTenMonAn().toLowerCase().contains(key))
				System.out.println(h.getTenMonAn());
	}
	@Override
	public void sapXep() {
		System.out.println("Moi ban chon thu can sap xep ");
		System.out.println("1. id Nguyen Lieu");
		System.out.println("2. Ten Mon An");
		System.out.println("3. Gia Mon An");
		int n = new Scanner(System.in).nextInt();
		
		switch (n) {
		case 1: {
			sapXepTheoId();
			break;
		}
		case 2: {
			sapXepTheoTen();
			break;
		}
		case 3: {
			sapXepTheoGia();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
		xuatDs();
	}
	@Override
	public void sapXepTheoTen() {
		Arrays.sort(dsNuocCoGa, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		
	}
	@Override
	public void sapXepTheoGia() {
		NuocCoGa ham = new NuocCoGa();
		for(int i=0;i<dsNuocCoGa.length;i++) {
			for(int j=i+1;j<dsNuocCoGa.length;j++) {
				if(dsNuocCoGa[i].getGia() > dsNuocCoGa[j].getGia()) {
					ham = dsNuocCoGa[i];
					dsNuocCoGa[i] = dsNuocCoGa[j];
					dsNuocCoGa[j] = ham;
				}
			}
		}
	}
	@Override
	public void sapXepTheoId() {
		NuocCoGa ham = new NuocCoGa();
		for(int i=0;i<dsNuocCoGa.length;i++) {
			for(int j=i+1;j<dsNuocCoGa.length;j++) {
				if(dsNuocCoGa[i].getId() > dsNuocCoGa[j].getId()) {
					ham = dsNuocCoGa[i];
					dsNuocCoGa[i] = dsNuocCoGa[j];
					dsNuocCoGa[j] = ham;
				}
			}
		}
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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+String.format("| %-10s| %-5s|", tenHangNuoc,giaNhapHang);
	}
	
	@Override
	public double setGiaBan() {
		return giaNhapHang+getGia();
	}
	
	
}
