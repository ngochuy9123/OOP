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

public class FriedChicken extends Food {
	private int slgGa;
	private int idLoaiGa;
	public static FriedChicken[] dsGaChien = new FriedChicken[0];
	public static String File_Fried_Chicken = "./src/file/Ga";
	
	public FriedChicken() {
		super();
	}
	
	public FriedChicken(int id, String tenMonAn, double gia) {
		super(id, tenMonAn, gia);
	}

	public FriedChicken(int id, String tenMonAn, double gia, int slgGa, int idLoaiGa) {
		super(id, tenMonAn, gia);
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

	public static FriedChicken[] getDsGaChien() {
		return dsGaChien;
	}

	public static void setDsGaChien(FriedChicken[] dsGaChien) {
		FriedChicken.dsGaChien = dsGaChien;
	}

	public static String getFile_Fried_Chicken() {
		return File_Fried_Chicken;
	}

	public static void setFile_Fried_Chicken(String file_Fried_Chicken) {
		File_Fried_Chicken = file_Fried_Chicken;
	}

	@Override
	public double setGiaBan() {
		// TODO Auto-generated method stub
		double giaThit = 0;
		for(Thit t:Thit.dsThit)
			if(t.getId()==idLoaiGa)
				giaThit = t.getGia();
		return (getGia()+giaThit)*slgGa;
	}

	@Override
	public boolean ktTrung(int id) {
		for(FriedChicken h:dsGaChien)
			if(h.getId()==id)
				return true;
		return false;
	}

	@Override
	public void xuatDs() {
		System.out.println("Danh Sach cua Mon An Thit la: ");
		System.out.printf("|%-2s | %-20s | %-6s | %-7s | %-7s","ID", "Ten Mon An","Gia","SLg Ga","Loai Ga");
		System.out.println();
		for(FriedChicken ga:dsGaChien)
			System.out.println(ga.toString());
		
	}

	@Override
	public void them() {
		System.out.println("Moi ban nhap id San Pham");
		int id = new Scanner(System.in).nextInt();
		int test = 1;
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
		System.out.println("Moi ban nhap so luong ga");
		int slg = new Scanner(System.in).nextInt();
		System.out.println("Moi ban nhap id Nguyen Lieu");
		int idNlG = new Scanner(System.in).nextInt();
		
		dsGaChien = Arrays.copyOf(dsGaChien, dsGaChien.length+1);
		dsGaChien[dsGaChien.length-1] = new FriedChicken(id, tenSp, gia,slg, idNlG);
		
		try {	
			ghiFile();
		} catch (IOException e) {
			System.out.println("loi ghi file");
			e.printStackTrace();
		}
		
	}

	@Override
	public void themNSp() {
		System.out.println("Moi ban nhap so luong ma ban muon them: ");
		int n = new Scanner(System.in).nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Moi ban nhap mon an thu "+i);
			them();
		}
		
	}

	@Override
	public void xoa() {
		System.out.println("Moi ban nhap id ma ban can xoa");
		int id = new Scanner(System.in).nextInt();
		FriedChicken[] dst = new FriedChicken[0];
		for(FriedChicken h:dsGaChien) {
			if(h.getId() != id) {
				dst = Arrays.copyOf(dst, dst.length+1);
				dst[dst.length-1] = new FriedChicken(h.getId(), h.getTenMonAn(), h.getGia(), h.getSlgGa(),h.getIdLoaiGa());
			}
			
		}
		dsGaChien = Arrays.copyOf(dst, dst.length);
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
			for(FriedChicken ham:dsGaChien) {
				if(ham.getId()==id) {
					System.out.println("Ban muon sua cai gi");
					System.out.println("1. Ten Mon An");
					System.out.println("2. Gia");
					System.out.println("3. So Luong Ga");
					System.out.println("4. Id Nguyen Lieu");
					int lc = new Scanner(System.in).nextInt();
					switch (lc) {
					case 1: {
						System.out.println("Ten Mon An Ban Dau la:");
						System.out.println(ham.getTenMonAn());
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
						System.out.println("So Luong Ga Ban Dau la:");
						System.out.println(ham.getSlgGa());
						System.out.println("Moi ban nhap Gia moi:");
						int tam = new Scanner(System.in).nextInt();
						ham.setSlgGa(tam);
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
						System.out.println("Nguyen Lieu Ban Dau la: ");
						int idt =0;
						for(Thit t: Thit.dsThit) {
							if(t.getId() == ham.getIdLoaiGa()) {
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
						ham.setIdLoaiGa(idt);
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
		Arrays.sort(dsGaChien, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
		System.out.println("Moi ban nhap tu can tim");
		String key = new Scanner(System.in).nextLine();
		for(FriedChicken h:dsGaChien)
			if(h.getTenMonAn().toLowerCase().contains(key))
				System.out.println( h.toString());
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
		Arrays.sort(dsGaChien, (a, b) -> a.getTenMonAn().compareTo(b.getTenMonAn()));
	}

	@Override
	public void sapXepTheoGia() {
		FriedChicken ham = new FriedChicken();
		for(int i=0;i<dsGaChien.length;i++) {
			for(int j=i+1;j<dsGaChien.length;j++) {
				if(dsGaChien[i].getGia() > dsGaChien[j].getGia()) {
					ham = dsGaChien[i];
					dsGaChien[i] = dsGaChien[j];
					dsGaChien[j] = ham;
				}
			}
		}
		
	}

	@Override
	public void sapXepTheoId() {
		FriedChicken t = new FriedChicken();
		for(int j=0;j<dsGaChien.length;j++) {
			for(int h=j+1;h<dsGaChien.length;h++) {
				if(dsGaChien[j].getId()>dsGaChien[h].getId()) {
					t= dsGaChien[j];
					dsGaChien[j] = dsGaChien[h];
					dsGaChien[h] = t;
				}	
			}
		}
		
	}

	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_Fried_Chicken);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==5) {
				dsGaChien = Arrays.copyOf(dsGaChien, dsGaChien.length+1);
				dsGaChien[dsGaChien.length-1] = new FriedChicken(Integer.parseInt(arr[0]) ,arr[1] , Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
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
		FileOutputStream fos = new FileOutputStream(File_Fried_Chicken);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(FriedChicken t:dsGaChien) {
			String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGia()+";"+t.getSlgGa()+";"+t.getIdLoaiGa();
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
		return super.toString() + String.format("| %-2s|%-2s|", slgGa,idLoaiGa) ;
	}
	
}
