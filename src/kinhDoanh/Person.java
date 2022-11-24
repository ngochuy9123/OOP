package kinhDoanh;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public abstract class Person {
	private String name;
	private int age;
	private String phone;
	private String address;
	private String id;
	private String chucVu;
 private String gioiTinh;
	
	
	public Person() {
	
}

	public Person(String name, int age, String phone, String address, String id, String chucVu, String gioiTinh) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.id = id;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	Scanner sc = new Scanner(System.in);

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public abstract double tinhLuong();
		
	
	public void nhapthongtin() {
			System.out.println("Nhap ho va ten: ");
			this.name = sc.nextLine();
			boolean check1 =true;
			while(check1 ==true) {
				System.out.println("Nhap id: ");
				this.id = sc.nextLine();
				String idt = id;
				boolean flag = true;
				for(Person per:PersonList.listPerson) {
					if(idt.equals(per.getId())) {
						System.out.println("ID da ton tai, Vui long nhap lai ID");
						flag = false;
					}
				}
				if(flag ==true) {
					break;
				}
			}
			
			System.out.println("Nhap nam sinh:");
	        int birthYear = Integer.parseInt(sc.nextLine());
	        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	        while ((currentYear-birthYear)<18) {
	            System.out.println("Tuoi nhan vien phai >= 18!");
	            birthYear = Integer.parseInt(sc.nextLine());
	        }
	        setAge(birthYear);
			
			System.out.println("Nhap dia chi");
			
			this.address = sc.nextLine();
			System.out.println("Nhap gioi tinh:");
	        String gender = sc.nextLine();
	        while (gender.equalsIgnoreCase("nam")==false && gender.equalsIgnoreCase("nu")==false) {
	            System.out.println("Gioi tinh phai la 'nam' hoac 'nu', nhap lai:");
	            gender = sc.nextLine();
	        }
	        setGioiTinh(gender);
	        System.out.println("Nhap SDT:");
	        boolean check;String phoneNumber;
	        do{
	        phoneNumber = sc.nextLine();
	        check = phoneNumber.matches("0\\d{9}");
	        if(!check) System.out.println("Dinh dang sdt khong dung (10 chu so), nhap lai:");
	        }while (!check);
	        setPhone(phoneNumber);
	}
	
	 @Override
	    public String toString(){
	        return String.format("|%-5s | %-20s | %-8s | %-6s | %-11s | %-10s ",
	        id, name, age, gioiTinh, address, phone);
	    };
	
}
