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

import kinhDoanh.KeToan;
import kinhDoanh.Manager;
import kinhDoanh.NhanVien;
import kinhDoanh.Person;
import lop.Hambuger;
import lop.InterDanhSach;
import lop.InterFile;


public class NguyenLieuList implements InterFile,InterDanhSach {
	public static NguyenLieu[] dsnl = new NguyenLieu[0];
	private static String File_NL = "./src/file/NguyenLieu";
	
	
	
	
	public static NguyenLieu[] getDsnl() {
		return dsnl;
	}

	public static void setDsnl(NguyenLieu[] dsnl) {
		NguyenLieuList.dsnl = dsnl;
	}

	public static String getFile_NL() {
		return File_NL;
	}

	public static void setFile_NL(String file_NL) {
		File_NL = file_NL;
	}

	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_NL);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			String l = arr[5];
			switch (l) {
			case "thit": {
				dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
				dsnl[dsnl.length-1] = new Thit();
				((Thit)dsnl[dsnl.length-1]).setMoTa(arr[6]);
				break;
			}
			case "traicay":{
				dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
				dsnl[dsnl.length-1] = new TraiCay();
				((TraiCay)dsnl[dsnl.length-1]).setNoiNhap(arr[6]);
				((TraiCay)dsnl[dsnl.length-1]).setGhiChu(arr[7]);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + l);
			}
			dsnl[dsnl.length-1].setIdNguyenLieu(Integer.parseInt(arr[0]));
			dsnl[dsnl.length-1].setTenNguyenLieu(arr[1]);
			dsnl[dsnl.length-1].setGia(Double.parseDouble(arr[2]));
			try {
				dsnl[dsnl.length-1].setHanSuDung((Date)NguyenLieu.df.parse(arr[3]));
			} catch (ParseException e) {
				System.out.println("Loi them ngay vao danh sach");
				e.printStackTrace();
			}
			dsnl[dsnl.length-1].setSoLuong(Integer.parseInt(arr[4]));
			dsnl[dsnl.length-1].setLoaiNL(arr[5]);
			
			line = br.readLine();
		}
		br.close();
		isr.close();
		fis.close();
		System.out.println("Doc Thanh Cong");
	}

	@Override
	public void ghiFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(File_NL);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(NguyenLieu t:dsnl) {
				String line = t.getIdNguyenLieu()+";"+t.getTenNguyenLieu()+";"+t.getGia()+";"+NguyenLieu.df.format(t.getHanSuDung())+";"+t.getSoLuong()+";"+t.getLoaiNL()+";" ;
				if(t instanceof Thit) line+=((Thit) t).getMoTa();
				else if(t instanceof TraiCay) {
					line += ((TraiCay) t).getNoiNhap()+";"+((TraiCay) t).getGhiChu();
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
        System.out.println("---Danh sach Thit---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-2s | %-25s | %-6s | %-15s | %-11s | %-10s | %-25s |%n",
    	        "ID", "Ten Nguyen Lieu","Gia","Han Su Dung","So Luong","Loai","Mo Ta");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(NguyenLieu nl:dsnl) {
        	if(nl instanceof Thit) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---Danh sach Trai Cay---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-2s | %-25s | %-6s | %-15s | %-11s | %-10s | %-15s | %-25s |%n",
    	        "ID", "Ten Nguyen Lieu","Gia","Han Su Dung","So Luong","Loai","Noi Nhap","Ghi Chu");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(NguyenLieu nl:dsnl) {
        	if(nl instanceof TraiCay) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---------------------------------------------------------------------------------------------\n\n");

	}

	@Override
	public void them() {
		System.out.println("Nhap so luong Nguyen Lieu muon them:");
        int sl = new Scanner(System.in).nextInt();
        while (sl <= 0) {
            System.out.println("So luong them khong the <=0 !, nhap lai:");
            sl = new Scanner(System.in).nextInt();
        }
		
		for(int i=0;i<sl;i++) {
			System.out.println("Chon loai nguyen lieu can them: 1)Thit \t 2)Trai Cay");
			int lc = new Scanner(System.in).nextInt();
			while (lc<1 || lc>2) {
		            System.out.println("Lua chon khong hop le, chon lai:");
		            lc = new Scanner(System.in).nextInt();
		    }
			dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
			switch (lc) {
			case 1: {
				dsnl[dsnl.length-1]= new Thit();
				dsnl[dsnl.length-1].nhapThongTin();
				break;
			}
			case 2:{
				dsnl[dsnl.length-1]= new TraiCay();
				dsnl[dsnl.length-1].nhapThongTin();
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
        
       
        
		for(int i=0;i<dsnl.length;i++) {
			if(dsnl[i].getIdNguyenLieu() == DelID) {
				flag = true;
				 for(int j = i; j < dsnl.length-1; j++) {
                     dsnl[j] = dsnl[j+1];
                 }
			}
			
			
		}
		if (flag == false){
            System.out.println("Khong tim thay ID da nhap!\n");
        }
		else {
			dsnl = Arrays.copyOf(dsnl, dsnl.length-1);
		}
		
		setDsnl(dsnl);
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
		for(NguyenLieu nl:dsnl) {
			if(nl.getIdNguyenLieu() == id) {
				flag=false;
				System.out.println("Chon loai nguyen lieu: 1)Thit \t 2)Trai Cay");
				int lc = new Scanner(System.in).nextInt();
				while (lc<1 || lc>2) {
			            System.out.println("Lua chon khong hop le, chon lai:");
			            lc = new Scanner(System.in).nextInt();
			    }
				if(lc==1) {
					dsnl[dsnl.length-1]= new Thit();
					dsnl[dsnl.length-1].nhapThongTin();
					break;
				}
				else {
					dsnl[dsnl.length-1]= new TraiCay();
					dsnl[dsnl.length-1].nhapThongTin();
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
		for(NguyenLieu h:dsnl)
			if(h.getTenNguyenLieu().toLowerCase().contains(key))
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
		System.out.println("Chon loai nguyen lieu can sap xep theo Gia: 1)Thit \t 2)Trai Cay");
		int lc = new Scanner(System.in).nextInt();
		while (lc<1 || lc>2) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = new Scanner(System.in).nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getGia() > dsnl[j].getGia() && dsnl[i] instanceof Thit&& dsnl[j] instanceof Thit  ) {
						NguyenLieu t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		else {
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getGia() > dsnl[j].getGia() && dsnl[i] instanceof TraiCay&& dsnl[j] instanceof TraiCay) {
						NguyenLieu t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		
	}

	@Override
	public void sapXepTheoId() {
		System.out.println("Chon loai nguyen lieu can sap xep theo Id: 1)Thit \t 2)Trai Cay");
		int lc = new Scanner(System.in).nextInt();
		while (lc<1 || lc>2) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = new Scanner(System.in).nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getIdNguyenLieu() > dsnl[j].getIdNguyenLieu() && dsnl[i] instanceof Thit&& dsnl[j] instanceof Thit  ) {
						NguyenLieu t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		else {
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getIdNguyenLieu() > dsnl[j].getIdNguyenLieu() && dsnl[i] instanceof TraiCay&& dsnl[j] instanceof TraiCay) {
						NguyenLieu t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		
	}
}
