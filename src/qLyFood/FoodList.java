package qLyFood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import lop.InterDanhSach;
import lop.InterFile;

public class FoodList implements InterDanhSach, InterFile {
	public static Food[] dsFood = new Food[0];
	private static String File_Food = "./src/file/Food";
	public static Food[] getDsFood() {
		return dsFood;
	}
	public static void setDsFood(Food[] dsFood) {
		FoodList.dsFood = dsFood;
	}
	public static String getFile_NL() {
		return File_Food;
	}
	public static void setFile_NL(String file_NL) {
		File_Food = file_NL;
	}
	
	
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_Food);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			String l = arr[3];
			switch (l) {
			case "hambuger": {
				dsFood = Arrays.copyOf(dsFood, dsFood.length+1);
				dsFood[dsFood.length-1] = new Hambuger();
				((Hambuger)dsFood[dsFood.length-1]).setIdNguyenLieuThit(Integer.parseInt(arr[4]));
				break;
			}
			case "gachien":{
				dsFood = Arrays.copyOf(dsFood, dsFood.length+1);
				dsFood[dsFood.length-1] = new GaChien();
				((GaChien)dsFood[dsFood.length-1]).setSlgGa(Integer.parseInt(arr[4]));
				((GaChien)dsFood[dsFood.length-1]).setIdLoaiGa(Integer.parseInt(arr[5]));
				break;
			}
			case "nuocep":{
				dsFood = Arrays.copyOf(dsFood, dsFood.length+1);
				dsFood[dsFood.length-1] = new NuocEp();
				((NuocEp)dsFood[dsFood.length-1]).setIdTraiCay(Integer.parseInt(arr[4]));
				break;
			}
			case "nuoccoga":{
				dsFood = Arrays.copyOf(dsFood, dsFood.length+1);
				dsFood[dsFood.length-1] = new NuocCoGa();
				((NuocCoGa)dsFood[dsFood.length-1]).setHangNuoc(arr[4]);
				((NuocCoGa)dsFood[dsFood.length-1]).setGiaNhapHang(Double.parseDouble(arr[5]));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + l);
			}
			dsFood[dsFood.length-1].setId(Integer.parseInt(arr[0]));
			dsFood[dsFood.length-1].setTenMonAn(arr[1]);
			dsFood[dsFood.length-1].setGiaLoi(Double.parseDouble(arr[2]));
			dsFood[dsFood.length-1].setLoai(arr[3]);
			
			
			line = br.readLine();
		}
		br.close();
		isr.close();
		fis.close();
		System.out.println("Doc Thanh Cong");
	}
	@Override
	public void ghiFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(File_Food);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(Food t:dsFood) {
				String line = t.getId()+";"+t.getTenMonAn()+";"+t.getGiaLoi()+";"+t.getLoai() ;
				if(t instanceof Hambuger) line+=((Hambuger) t).getIdNguyenLieuThit();
				else if(t instanceof GaChien) {
					line += ((GaChien) t).getSlgGa()+";"+((GaChien) t).getIdLoaiGa();
				}
				else if(t instanceof NuocEp) {
					line += ((NuocEp) t).getIdTraiCay();
				}
				else if(t instanceof NuocCoGa) {
					line += ((NuocCoGa) t).getHangNuoc()+";"+((NuocCoGa) t).getGiaLoi();
				}
				bw.write(line);
				bw.newLine();
		}
		bw.close();
		fos.close();
		osw.close();
		System.out.println("Ghi thanh Cong");
	}
	
	@Override
	public void xuatDs() {
		System.out.println("\n\t\t\tDanh sach cac Nguyen Lieu:\n");
        System.out.println("---Danh sach Hambuger---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s | %-10s |%-3s |%n",
    	        "ID", "Ten Mon An","Gia Loi","Loai","Id Nguyen Lieu Thit");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:dsFood) {
        	if(nl instanceof Hambuger) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---Danh sach Ga Chien---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s | %-10s |%-20s | %-20s |%n",
        		 "ID", "Ten Mon An","Gia Loi","Loai","So Luong Ga","Id Nguyen Lieu Thit");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:dsFood) {
        	if(nl instanceof GaChien) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---------------------------------------------------------------------------------------------\n\n");
        System.out.println("---Danh sach Nuoc Ep---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s | %-10s |%-20s |%n",
        		"ID", "Ten Mon An","Gia Loi","Loai","Id Trai Cay");
        System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:dsFood) {
        	if(nl instanceof NuocEp) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---------------------------------------------------------------------------------------------\n\n");
        System.out.println("---Danh sach Nuoc Co Ga---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s | %-10s |%-20s |%-20s |%n",
        		"ID", "Ten Mon An","Gia Loi","Loai","Hang Nuoc","Gia Nhap Hang");
        System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:dsFood) {
        	if(nl instanceof NuocCoGa) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---------------------------------------------------------------------------------------------\n\n");

	}
	@Override
	public void them() {
		System.out.println("Nhap so luong Mon AN muon them:");
        int sl = new Scanner(System.in).nextInt();
        while (sl <= 0) {
            System.out.println("So luong them khong the <=0 !, nhap lai:");
            sl = new Scanner(System.in).nextInt();
        }
		
		for(int i=0;i<sl;i++) {
			System.out.println("Chon loai nguyen lieu can them: 1)Hambuger \t 2)Ga Chien \t 2)Nuoc Ep \t 2)Nuoc Co Ga");
			int lc = new Scanner(System.in).nextInt();
			while (lc<1 || lc>2) {
		            System.out.println("Lua chon khong hop le, chon lai:");
		            lc = new Scanner(System.in).nextInt();
		    }
			dsFood = Arrays.copyOf(dsFood, dsFood.length+1);
			switch (lc) {
			case 1: {
				dsFood[dsFood.length-1]= new Hambuger();
				dsFood[dsFood.length-1].nhapthongtin();
				break;
			}
			case 2:{
				dsFood[dsFood.length-1]= new GaChien();
				dsFood[dsFood.length-1].nhapthongtin();
				break;
			}
			case 3:{
				dsFood[dsFood.length-1]= new NuocEp();
				dsFood[dsFood.length-1].nhapthongtin();
				break;
			}
			case 4:{
				dsFood[dsFood.length-1]= new NuocCoGa();
				dsFood[dsFood.length-1].nhapthongtin();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + lc);
			}
		}
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi GHi file them");
			//e.printStackTrace();
		}
	}
	
	@Override
	public void xoa() {
		System.out.println("Nhap ID nhan vien muon xoa:");
        int DelID =  new Scanner(System.in).nextInt();
        Boolean flag = false;
        
       
        
		for(int i=0;i<dsFood.length;i++) {
			if(dsFood[i].getId() == DelID) {
				flag = true;
				 for(int j = i; j < dsFood.length-1; j++) {
                     dsFood[j] = dsFood[j+1];
                 }
			}
			
			
		}
		if (flag == false){
            System.out.println("Khong tim thay ID da nhap!\n");
        }
		else {
			dsFood = Arrays.copyOf(dsFood, dsFood.length-1);
		}
		
		setDsFood(dsFood);
		try {
			ghiFile();
		} catch (IOException e) {
			System.out.println("Loi cho xoa nguyen lieu");
		}
	}
	@Override
	public void sua() {
		boolean flag = true;
		System.out.println("Moi ban nhap id ma ban muon sua: ");
		int id = new Scanner(System.in).nextInt();
		for(Food nl:dsFood) {
			if(nl.getId() == id) {
				flag=false;
				System.out.println("Chon loai nguyen lieu: 1)Hambuger \t 2)Ga Chien \t 3)Nuoc Ep \t 4)Nuoc Co Ga");
				int lc = new Scanner(System.in).nextInt();
				while (lc<1 || lc>4) {
			            System.out.println("Lua chon khong hop le, chon lai:");
			            lc = new Scanner(System.in).nextInt();
			    }
				if(lc==1) {
					dsFood[dsFood.length-1]= new Hambuger();
					dsFood[dsFood.length-1].nhapthongtin();
					break;
				}
				else if(lc==2) {
					dsFood[dsFood.length-1]= new GaChien();
					dsFood[dsFood.length-1].nhapthongtin();
					break;
				}
				else if(lc==3) {
					dsFood[dsFood.length-1]= new NuocEp();
					dsFood[dsFood.length-1].nhapthongtin();
					break;
				}
				else if(lc==4) {
					dsFood[dsFood.length-1]= new NuocCoGa();
					dsFood[dsFood.length-1].nhapthongtin();
					break;
				}
			}
		}
		if(flag==true) {
			System.out.println("Id khong ton tai");
		}
		else {
			try {
				ghiFile();
			} catch (IOException e) {
				System.out.println("Loi ghi file cho xoa");
				e.printStackTrace();
			}
		}
	}
	@Override
	public void timKiem() {
		System.out.println("Moi ban nhap tu can tim: ");
		String key = new Scanner(System.in).nextLine();
		for(Food h:dsFood)
			if(h.getTenMonAn().toLowerCase().contains(key))
				System.out.println(h.toString());
	}
	@Override
	public void sapXep() {
		System.out.println("Moi ban chon thu can sap xep ");
		System.out.println("1. id Nguyen Lieu");
		System.out.println("2. Gia Mon An");
		int n = new Scanner(System.in).nextInt();
		
		switch (n) {
		case 1: {
			sapXepTheoId();
			break;
		}
		case 2: {
			sapXepTheoGia();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
		xuatDs();
	}
	
	@Override
	public void sapXepTheoGia() {
		System.out.println("Chon loai nguyen lieu can sap xep theo Gia: 1)Hambuger \t 2)Ga Chien \t 3)Nuoc Ep \t 4)Nuoc Co Ga");
		int lc = new Scanner(System.in).nextInt();
		while (lc<1 || lc>4) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = new Scanner(System.in).nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].giaBan() > dsFood[j].giaBan() && dsFood[i] instanceof Hambuger&& dsFood[j] instanceof Hambuger  ) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==2) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].giaBan() > dsFood[j].giaBan() && dsFood[i] instanceof GaChien&& dsFood[j] instanceof GaChien  ) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==3) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].giaBan() > dsFood[j].giaBan() && dsFood[i] instanceof NuocEp&& dsFood[j] instanceof NuocEp  ) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==4) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].giaBan() > dsFood[j].giaBan() && dsFood[i] instanceof NuocCoGa&& dsFood[j] instanceof NuocCoGa  ) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		
		
	}
	@Override
	public void sapXepTheoId() {
		System.out.println("Chon loai nguyen lieu can sap xep theo Id: 1)Hambuger \t 2)Ga Chien \t 3)Nuoc Ep \t 4)Nuoc Co Ga");
		int lc = new Scanner(System.in).nextInt();
		while (lc<1 || lc>4) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = new Scanner(System.in).nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].getId() > dsFood[j].getId() && dsFood[i] instanceof Hambuger&& dsFood[j] instanceof Hambuger  ) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==2) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].getId() > dsFood[j].getId() && dsFood[i] instanceof GaChien&& dsFood[j] instanceof GaChien) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==3) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].getId() > dsFood[j].getId() && dsFood[i] instanceof NuocEp&& dsFood[j] instanceof NuocEp) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
		else if(lc==4) {
			for(int i=0;i<dsFood.length;i++) {
				for(int j=i+1;j<dsFood.length;j++) {
					if(dsFood[i].getId() > dsFood[j].getId() && dsFood[i] instanceof NuocCoGa&& dsFood[j] instanceof NuocCoGa) {
						Food t = dsFood[i];
						dsFood[i] = dsFood[j];
						dsFood[j] = t;
					}
				}
			}
		}
	}
	
}
