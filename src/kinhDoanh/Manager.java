package kinhDoanh;

import java.util.Arrays;
import java.util.Scanner;

public class Manager extends Person {
	private double PhuCap;
	Person ds[] = new Person[0];

	public double getPhuCap() {
		return PhuCap;
	}

	public void setPhuCap(double phuCap) {
		PhuCap = phuCap;
	}
	
	private double Phucap;
	private String boPhanQl;

	    public double getPhucap() {
		return Phucap;
	}

	public void setPhucap(double phucap) {
		Phucap = phucap;
	}

		
		public Manager(double phuCap, double phucap2, String boPhanQl) {
		super();
		PhuCap = phuCap;
		Phucap = phucap2;
		this.boPhanQl = boPhanQl;
	}

		Scanner sc = new Scanner(System.in);

	    public Manager(){}

	    public void setBoPhanQl(String boPhanQl) {
	        this.boPhanQl = boPhanQl;
	    }
	    public String getBoPhanQl() {
	        return boPhanQl;
	    }

	    @Override
	    public void nhapthongtin(){
	        super.nhapthongtin();
	        setChucVu("quanly");
	        System.out.println("Chon bo phan quan ly 1)Nhan su\t2)Kho hang");
	        int choice = Integer.parseInt(sc.nextLine());
	        while (choice !=1 && choice !=2) {
	            System.out.println("Lua chon khong hop le, chon lai:");
	            choice = Integer.parseInt(sc.nextLine());
	        }
	        switch (choice) {
	            case 1:
	                setBoPhanQl("Nhan su"); break;
	            case 2:
	                setBoPhanQl("Kho hang"); break;
	        }
	    }

	    @Override
	    public double tinhLuong() {
	        if (boPhanQl.equalsIgnoreCase("Nhan su")) return 500000;
	        else if (boPhanQl.equalsIgnoreCase("Kho hang")) return 450000;
	        else return 0;
	    }

	    @Override
	    public String toString(){
	        return super.toString() + String.format("| %-13s|%n", boPhanQl);
	    }
		

}
