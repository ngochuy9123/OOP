package kinhDoanh;

import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonList implements ManagerList {
	
	 	public static  Person listPerson[] = new Person[0];
	    private int n;
	    private static double vonTraLuong = 0;

	    Scanner sc1 = new Scanner(System.in);

	    public PersonList(){}
	    public void setListPerson(Person[] listPerson) {
	        this.listPerson = listPerson;
	    }
	    
	    public void setN(int n) {
	        this.n = n;
	    }
	    public Person[] getListPerson() {
	        return listPerson;
	    }
	    public  int getN() {
	        return n;
	    }
	    public static double getVonTraLuong() {
	        return vonTraLuong;
	    }
	    public int capNhatSoPerson(){
	        int count = 0;
	        try {
	            BufferedReader rd = new BufferedReader(new FileReader("./src/file/dsnhanvien.txt"));
	            while ((rd.readLine())!=null) {
	                count+=1;
	            }
	            rd.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return count;
	    }
	    Scanner sc = new Scanner(System.in);
	    public void docFileDsPerson(){
	        n = capNhatSoPerson();
	        listPerson = new Person[n];
	        try {
	            BufferedReader r = new BufferedReader(new FileReader("./src/file/dsnhanvien.txt"));
	            String line;
	            for (int i = 0; i < listPerson.length; i++) {
	                line = r.readLine();
	                String split[] = line.split(", ");
	                String chucvu = split[4];
	                switch (chucvu) {
	                    case "phucvu":
	                        listPerson[i] = new NhanVien();
	                        ((NhanVien) listPerson[i]).setCaPhucVu(split[7]);
	                        break;
	                    case "ketoan":
	                        listPerson[i] = new KeToan();
	                        ((KeToan) listPerson[i]).setNamKinhNghiem(Integer.parseInt(split[7]));
	                        break;
	                    case "quanly":
	                        listPerson[i] = new Manager();
	                        ((Manager) listPerson[i]).setBoPhanQl(split[7]);
	                        break;
	                    default:
	                        i-=1; break;
	                    }
	                listPerson[i].setId(split[0]);
	                listPerson[i].setName(split[1]);
	                listPerson[i].setAge(Integer.parseInt(split[2]));
	                listPerson[i].setGioiTinh(split[3]);
	                listPerson[i].setChucVu(split[4]);
	                listPerson[i].setAddress(split[5]);
	                listPerson[i].setPhone(split[6]);
	                vonTraLuong = vonTraLuong + listPerson[i].tinhLuong();
	            }
	            r.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public void ghiFileDSPerson(){
	        try {
	            BufferedWriter w = new BufferedWriter(new FileWriter("dsnhanvien.txt"));
	            for (int i = 0; i < listPerson.length; i++) {
	                w.write(listPerson[i].getId() + ", ");
	                w.write(listPerson[i].getName() + ", ");
	                w.write(Integer.toString(listPerson[i].getAge()) + ", ");
	                w.write(listPerson[i].getGioiTinh() + ", ");
	                w.write(listPerson[i].getChucVu() + ", ");
	                w.write(listPerson[i].getAddress() + ", ");
	                w.write(listPerson[i].getPhone() + ", ");
	                if (listPerson[i] instanceof NhanVien) w.write(((NhanVien) listPerson[i]).getCaPhucVu() + ", ");
	                else if (listPerson[i] instanceof Manager) w.write(((Manager) listPerson[i]).getBoPhanQl());
	                else w.write(Integer.toString(((KeToan) listPerson[i]).getNamKinhNghiem()));
	                if (i != (listPerson.length-1)) {
	                    w.newLine();
	                }
	            }
	            w.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    @Override
	    public void themDS(){
	        System.out.println("Nhap so luong nham vien muon them:");
	        int sl = Integer.parseInt(sc.nextLine());
	        while (sl <= 0) {
	            System.out.println("So luong them khong the <=0 !, nhap lai:");
	            sl = Integer.parseInt(sc.nextLine());
	        }
	        n = listPerson.length;
	        Person newListPerson[] = Arrays.copyOf(listPerson, listPerson.length+sl);
	        for (int i = 0; i < sl; i++) {
	            System.out.println("Chon chuc vu nhan vien can them: 1)Phuc vu\t2)Quan ly\t3)Ke toan");
	            int choice = Integer.parseInt(sc.nextLine());
	            while (choice<1 || choice>3) {
	                System.out.println("Lua chon khong hop le, chon lai:");
	                choice = Integer.parseInt(sc.nextLine());
	            }
	            switch (choice) {
	                case 1:
	                    newListPerson[n] = new NhanVien();
	                    newListPerson[n].nhapthongtin(); break;
	                case 2:
	                    newListPerson[n] = new Manager();
	                    newListPerson[n].nhapthongtin(); break;
	                case 3:
	                    newListPerson[n] = new KeToan();
	                    newListPerson[n].nhapthongtin(); break;
	            }
	            n += 1;
	        }
	        setListPerson(newListPerson);
	        ghiFileDSPerson();
	    }
	    @Override
	    public void xuatDS(){
	        System.out.println("\n\t\t\tDanh sach cac nhan vien:\n");
	        System.out.println("---Danh sach cac nhan vien phuc vu---");
	        System.out.println("---------------------------------------------------------------------------------------");
	        System.out.printf("|%-5s | %-20s | %-8s | %-6s | %-11s | %-10s | %-6s |%n",
	        "ID", "Hoten","Nam sinh","Gender","Que quan","SDT","Ca lam");
	        System.out.println("---------------------------------------------------------------------------------------");
	        for (int i = 0; i < listPerson.length; i++) {
	            if (listPerson[i] instanceof NhanVien) System.out.print(listPerson[i].toString());
	        }
	        System.out.println("---------------------------------------------------------------------------------------\n\n");
	        System.out.println("---Danh sach cac nhan vien ke toan---");
	        System.out.println("------------------------------------------------------------------------------------------------");
	        System.out.printf("|%-5s | %-20s | %-8s | %-6s | %-11s | %-10s | %-16s|%n", 
	        "ID", "Hoten","Nam sinh","Gender","Que quan","SDT", "Nam kinh nghiem");
	        System.out.println("------------------------------------------------------------------------------------------------");
	        for (int i = 0; i < listPerson.length; i++) {
	            if (listPerson[i] instanceof KeToan) System.out.print(listPerson[i].toString());
	        }
	        System.out.println("------------------------------------------------------------------------------------------------\n\n");
	        System.out.println("---Danh sach cac nhan vien quan ly---");
	        System.out.println("---------------------------------------------------------------------------------------------");
	        System.out.printf("|%-5s | %-20s | %-8s | %-6s | %-11s | %-10s | %-13s|%n", 
	        "ID", "Hoten","Nam sinh","Gender","Que quan","SDT", "Bo phan q.ly");
	        System.out.println("---------------------------------------------------------------------------------------------");
	        for (int i = 0; i < listPerson.length; i++) {
	            if (listPerson[i] instanceof Manager) System.out.print(listPerson[i].toString());
	        }
	        System.out.println("---------------------------------------------------------------------------------------------\n\n");
	    }
	    @Override
		public void suaDS() {
			
	    	System.out.println("Nhap ID cua nhan vien muon sua:");
	        String EditID = sc.nextLine();
	        boolean flag = false;
	        for (int i = 0; i < listPerson.length; i++) {
	            if (listPerson[i].getId().equalsIgnoreCase(EditID)){
	                flag = true;
	                System.out.println("Chon chuc vu nhan vien: 1)Nhan vien\t2)Quan ly\t3)Ke toan");
	                int choice = Integer.parseInt(sc.nextLine());
	                while (choice<1 || choice>3) {
	                    System.out.println("Lua chon khong hop le, chon lai:");
	                    choice = Integer.parseInt(sc.nextLine());
	                }
	                switch (choice) {
	                    case 1:
	                        listPerson[i] = new NhanVien();
	                        listPerson[i].nhapthongtin(); break;
	                    case 2:
	                        listPerson[i] = new Manager();
	                        listPerson[i].nhapthongtin(); break;
	                    case 3:
	                        listPerson[i] = new KeToan();
	                        listPerson[i].nhapthongtin(); break;
	                }
	            }
	        }
	        if (flag == false) System.out.println("Khong tim thay ID da nhap!\n");
	        ghiFileDSPerson();
		}
		@Override
		public void xoaDS() {
	       
	            System.out.println("Nhap ID nhan vien muon xoa:");
	            String DelID = sc.nextLine();
	            Boolean flag = false;
	            int notFind = 0;
	            for (int i = 0; i < listPerson.length; i++) {
	                if (listPerson[i].getId().equalsIgnoreCase(DelID)){
	                    flag = true;
	                    for (int j = i; j < listPerson.length-1; j++) {
	                        listPerson[j] = listPerson[j+1];
	                    }
	                }
	            }
	            if (flag == false){
	            	notFind +=1;
	                System.out.println("Khong tim thay ID da nhap!\n");
	            }
	        Person newListPerson[] = Arrays.copyOf(listPerson, listPerson.length-(1-notFind));
	        n = newListPerson.length;
	        setListPerson(newListPerson);
	        ghiFileDSPerson();
		}
		@Override
		public void searchByID() {
			System.out.println("Nhap ID cua nhan vien tra cuu:");
	        String IDSearch = sc.nextLine();
	        boolean flag = false;
	        for (int i = 0; i < listPerson.length; i++) {
	            if (listPerson[i].getId().equalsIgnoreCase(IDSearch)) {
	                flag = true;
	                System.out.println("Da tim thay! Thong tin nhan vien:");
	                System.out.println(listPerson[i].toString());
	            }
	        }
	        if (flag == false) System.out.println("Khong tim thay nhan vien co ID da nhap!\n");
	       
		}
	
		@Override
		public void searchByName() {
			System.out.println("Nhap ten can tim: ");
			String nameSearch = sc.nextLine();
			String nameLower = nameSearch.toLowerCase();
			for(int i =0;i<listPerson.length;i++) {
				if(listPerson[i].getName().toLowerCase().contains(nameLower)) {
					 System.out.println("Da tim thay! Thong tin nhan vien:");
		             System.out.println(listPerson[i].toString());
				}
			}
			
		}
		@Override
		public void sortByName() {
			for(int i =0;i<listPerson.length-1;i++) {
				String[] spliti = listPerson[i].getName().split(" ");
//				System.out.println("ten i"+spliti[spliti.length-1]);
			
				for(int j =i+1;j<listPerson.length;j++) {
					String[] splitj = listPerson[j].getName().split(" ");
//					System.out.println("ten j"+splitj[splitj.length-1]);
					spliti = listPerson[i].getName().split(" ");
					 
					if(spliti[spliti.length-1].compareTo(splitj[splitj.length-1])>0) {
						
						if(listPerson[i] instanceof NhanVien && listPerson[j] instanceof NhanVien) {
							
								Person temp = new NhanVien();
								temp = listPerson[i];
								listPerson[i] = listPerson[j];
								listPerson[j]=temp;
								System.out.println(listPerson[i].getName());
								
						
						}
						else if(listPerson[i] instanceof KeToan && listPerson[j] instanceof KeToan) {
							
								Person temp = new KeToan();
								temp = listPerson[i];
								listPerson[i] = listPerson[j];
								listPerson[j]=temp;
								System.out.println(spliti[spliti.length-1] + " > "+splitj[splitj.length-1] );
						
						}
						else if(listPerson[i] instanceof Manager && listPerson[j] instanceof Manager) {
								Person temp = new Manager();
								temp = listPerson[i];
								listPerson[i] = listPerson[j];
								listPerson[j]=temp;
								System.out.println(spliti[spliti.length-1] + " > "+splitj[splitj.length-1] );
						
						}
					}
						
					
					}
				}

			
		}

}
