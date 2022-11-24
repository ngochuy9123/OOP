package kinhDoanh;

import java.util.Arrays;
import java.util.Scanner;

public class NhanVien extends Person {
	
	 private String caPhucVu;
	 
	    Scanner sc = new Scanner(System.in);
	    public NhanVien() {
	    	
	    }


	public NhanVien(String caPhucVu) {
			super();
			
			this.caPhucVu = caPhucVu;
		}


	
	public void setCaPhucVu(String caPhucVu) {
        this.caPhucVu = caPhucVu;
    }
    public String getCaPhucVu() {
        return caPhucVu;
    }
	 @Override
	    public void nhapthongtin(){
	        super.nhapthongtin();
	        setChucVu("phucvu");
	        System.out.println("Nhap ca phuc vu:");
	        String ca = sc.nextLine();
	        while (ca.equalsIgnoreCase("sang")==false&&ca.equalsIgnoreCase("toi")==false) {
	            System.out.println("Ca lam la 'sang' hoac 'toi', nhap lai:" );
	            ca = sc.nextLine();
	        }
	        
	        setCaPhucVu(ca);
	        
	        
	    }
	 @Override
	    public double tinhLuong() {
	        return 200000;
	    }

	  @Override
	    public String toString(){
	        return super.toString() + String.format("| %-6s |%n", caPhucVu);
	    }


}
