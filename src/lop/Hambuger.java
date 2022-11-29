package lop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Hambuger extends Food {
	private int idNguyenLieu;
	
	public static Hambuger[] dsHambuger = new Hambuger[0];
	public static String File_Hambuger = "./src/file/Hambuger";
	

	
	public Hambuger() {
		super();
	}
	public Hambuger(int id, String tenMonAn, double gia) {
		super(id, tenMonAn, gia);
	}
	public Hambuger(int id, String tenMonAn, double gia, int idNguyenLieu) {
		super(id, tenMonAn, gia);
		this.idNguyenLieu = idNguyenLieu;
	}
	
	
	
	public int getIdNguyenLieu() {
		return idNguyenLieu;
	}
	public void setIdNguyenLieu(int idNguyenLieu) {
		this.idNguyenLieu = idNguyenLieu;
	}
	
	@Override
	public double setGiaBan() {
		double giaThit = 0;
		for(Thit t:Thit.dsThit)
			if(idNguyenLieu == t.getId())
				giaThit = t.getGia();
		return getGia() + giaThit;
	}
	@Override
	public void xuatDs() {
		System.out.println("Danh Sach cua Mon An Thit la: ");
		System.out.printf("|%-5s | %-20s | %-8s  | %-2s ","ID", "Ten Mon An","Gia","ID Nguyen Lieu");
		System.out.println();
		for(Hambuger ham:dsHambuger)
			System.out.println(ham.toString());
		
	}
	@Override
	public void them() {
		int test = 1;
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
		
		System.out.println("Moi ban nhap ten San Pham");
		String tenSp = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhap gia San Pham");
		double gia = new Scanner(System.in).nextDouble();
		int idNl =0;
		System.out.println("Moi ban nhap id Nguyen Lieu");
		try {
			idNl = new Scanner(System.in).nextInt();
		} catch (Exception e) {
			System.out.println("Ban can nhap kieu so");
			
		}
		
		
		dsHambuger = Arrays.copyOf(dsHambuger, dsHambuger.length+1);
		dsHambuger[dsHambuger.length-1] = new Hambuger(id, tenSp, gia, idNl);
		
		try {
			ghiFile();
		} catch (IOException e) {
			System.out.println("loi ghi file");
			e.printStackTrace();
		}
	}
	@Override
	public void themNSp() {
		System.out.println("Moi ban nhap so san pham ma ban muon them:");
		int n = new Scanner(System.in).nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Moi ban nahp san pham thu: "+i);
			them();
		}
		
	}
	@Override
	public void xoa() {
		System.out.println("Moi ban nhap id ma ban can xoa");
		int id = new Scanner(System.in).nextInt();
		Hambuger[] dst = new Hambuger[0];
		for(Hambuger h:dsHambuger) {
			if(h.getId() != id) {
				dst = Arrays.copyOf(dst, dst.length+1);
				dst[dst.length-1] = new Hambuger(h.getId(), h.getTenMonAn(), h.getGia(), h.getIdNguyenLieu());
			}
			
		}
		dsHambuger = Arrays.copyOf(dst, dst.length);
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
			for(Hambuger ham:dsHambuger) {
				if(ham.getId()==id) {
					System.out.println("Ban muon sua cai gi");
					System.out.println("1. Ten Mon An");
					System.out.println("2. Gia");
					System.out.println("3. Id Nguyen Lieu");
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
						System.out.println("Nguyen Lieu Ban Dau la: ");
						int idt =0;
						for(Thit t: Thit.dsThit) {
							if(t.getId() == ham.getIdNguyenLieu()) {
								System.out.println(t.getId()+" - "+t.getTenNguyenLieu());
								System.out.println("Moi ban nhap id Nguyen Lieu Moi: ");
								while(true) {
									idt = new Scanner(System.in).nextInt();
									if(t.ktTrung(idt)==true) {
										System.out.println("Da Cap Nhat Thanh Cong");
										break;
									}
									else {
										System.out.println("Id nguyen lieu khong ton tai;");
									}
								}
							}
						}
						ham.setIdNguyenLieu(idt);
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
		Arrays.sort(dsHambuger, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(Hambuger h:dsHambuger)
			if(h.getTenMonAn().toLowerCase().contains(key))
				System.out.println(h.getTenMonAn());
		
	}
	
	@Override
	public boolean ktTrung(int id) {
		for(Hambuger h:dsHambuger)
			if(h.getId()==id)
				return true;
		return false;
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
		Arrays.sort(dsHambuger, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		
	}
	
	@Override
	public void sapXepTheoGia() {
		Hambuger ham = new Hambuger();
		for(int i=0;i<dsHambuger.length;i++) {
			for(int j=i+1;j<dsHambuger.length;j++) {
				if(dsHambuger[i].getGia() > dsHambuger[j].getGia()) {
					ham = dsHambuger[i];
					dsHambuger[i] = dsHambuger[j];
					dsHambuger[j] = ham;
				}
			}
		}
		
	}
	@Override
	public void sapXepTheoId() {
		Hambuger ham = new Hambuger();
		for(int i=0;i<dsHambuger.length;i++) {
			for(int j=i+1;j<dsHambuger.length;j++) {
				if(dsHambuger[i].getId() > dsHambuger[j].getId()) {
					ham = dsHambuger[i];
					dsHambuger[i] = dsHambuger[j];
					dsHambuger[j] = ham;
				}
			}
		}
		
	}
	
	
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_Hambuger);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==4) {
				dsHambuger = Arrays.copyOf(dsHambuger, dsHambuger.length+1);
				dsHambuger[dsHambuger.length-1] = new Hambuger(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),Integer.parseInt(arr[3]));
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
		FileOutputStream fos = new FileOutputStream(File_Hambuger);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(Hambuger t:dsHambuger) {
			String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGia()+";"+t.getIdNguyenLieu();
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
		return super.toString() + String.format("| %-2s|", idNguyenLieu) ;
	}
	
}
