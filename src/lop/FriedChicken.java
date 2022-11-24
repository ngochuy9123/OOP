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
			String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGia()+";"+";"+t.getSlgGa()+t.getIdLoaiGa();
			bw.write(line);
			bw.newLine();	
		}
		bw.close();
		fos.close();
		osw.close();
		System.out.println("Ghi thanh Cong");
		
	}
	
}
