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

public class NuocEp extends Food {
	private int idTraiCay;
	public static NuocEp[] dsNuocEp = new NuocEp[0];
	public static String File_Nuoc_Ep = "./src/file/NuocEp";
	public NuocEp() {
		super();
	}
	public NuocEp(int id, String tenMonAn, double gia) {
		super(id, tenMonAn, gia);
	}
	public NuocEp(int id, String tenMonAn, double gia, int idTraiCay) {
		super(id, tenMonAn, gia);
		this.idTraiCay = idTraiCay;
	}
	
	
	public int getIdTraiCay() {
		return idTraiCay;
	}
	public void setIdTraiCay(int idTraiCay) {
		this.idTraiCay = idTraiCay;
	}
	public static NuocEp[] getDsNuocEp() {
		return dsNuocEp;
	}
	public static void setDsNuocEp(NuocEp[] dsNuocEp) {
		NuocEp.dsNuocEp = dsNuocEp;
	}
	public static String getFile_Nuoc_Ep() {
		return File_Nuoc_Ep;
	}
	public static void setFile_Nuoc_Ep(String file_Nuoc_Ep) {
		File_Nuoc_Ep = file_Nuoc_Ep;
	}
	
	@Override
	public double setGiaBan() {
		double giaNcEp = 0;
		for(TraiCay tc: TraiCay.dsTraiCay)
			if(tc.getId() == idTraiCay)
				giaNcEp = tc.getGia();
		return giaNcEp+getGia();
	}
	
	@Override
	public boolean ktTrung(int id) {
		for(NuocEp nc:dsNuocEp)
			if(nc.getId()==id)
				return true;
		return false;
	}
	@Override
	public void xuatDs() {
		System.out.println("Danh Sach cua Nuoc Ep la: ");
		System.out.printf("|%-2s | %-20s | %-6s | %-7s ","ID", "Ten Mon An","Gia","Trai Cay");
		System.out.println();
		for(NuocEp nc:dsNuocEp)
			System.out.println(nc.toString());
		
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
		System.out.println("Moi ban nhap id Nguyen Lieu");
		int idNl = new Scanner(System.in).nextInt();
		
		dsNuocEp = Arrays.copyOf(dsNuocEp, dsNuocEp.length+1);
		dsNuocEp[dsNuocEp.length-1] = new NuocEp(id, tenSp, gia, idNl);
		
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
		NuocEp[] dst = new NuocEp[0];
		for(NuocEp h:dsNuocEp) {
			if(h.getId() != id) {
				dst = Arrays.copyOf(dst, dst.length+1);
				dst[dst.length-1] = new NuocEp(h.getId(), h.getTenMonAn(), h.getGia(), h.getIdTraiCay());
			}
			
		}
		dsNuocEp = Arrays.copyOf(dst, dst.length);
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
			for(NuocEp ham:dsNuocEp) {
				if(ham.getId()==id) {
					System.out.println("Ban muon sua cai gi");
					System.out.println("1. Ten Mon An");
					System.out.println("2. Gia");
					System.out.println("3. Id Trai Cay");
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
						for(TraiCay t: TraiCay.dsTraiCay) {
							if(t.getId() == ham.getIdTraiCay()) {
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
						ham.setIdTraiCay(idt);
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
		Arrays.sort(dsNuocEp, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(NuocEp t:dsNuocEp) {
			if(t.getTenMonAn().toLowerCase().contains(key))
				System.out.println(t.getTenMonAn());
		}
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
		Arrays.sort(dsNuocEp, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		
	}
	@Override
	public void sapXepTheoGia() {
		NuocEp ham = new NuocEp();
		for(int i=0;i<dsNuocEp.length;i++) {
			for(int j=i+1;j<dsNuocEp.length;j++) {
				if(dsNuocEp[i].getGia() > dsNuocEp[j].getGia()) {
					ham = dsNuocEp[i];
					dsNuocEp[i] = dsNuocEp[j];
					dsNuocEp[j] = ham;
				}
			}
		}
	}
	@Override
	public void sapXepTheoId() {
		NuocEp ham = new NuocEp();
		for(int i=0;i<dsNuocEp.length;i++) {
			for(int j=i+1;j<dsNuocEp.length;j++) {
				if(dsNuocEp[i].getId() > dsNuocEp[j].getId()) {
					ham = dsNuocEp[i];
					dsNuocEp[i] = dsNuocEp[j];
					dsNuocEp[j] = ham;
				}
			}
		}
	}
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_Nuoc_Ep);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==4) {
				dsNuocEp = Arrays.copyOf(dsNuocEp, dsNuocEp.length+1);
				dsNuocEp[dsNuocEp.length-1] = new NuocEp(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),Integer.parseInt(arr[3]));
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
		FileOutputStream fos = new FileOutputStream(File_Nuoc_Ep);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(NuocEp t:dsNuocEp) {
			String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGia()+";"+t.getIdTraiCay();
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
		return super.toString() + String.format("| %-1s|", idTraiCay);
	}
}
