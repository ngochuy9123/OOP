package kinhDoanh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

import lop.Hambuger;
import lop.InterFile;

public class User implements InterFile {
	private String username;
	private String password;
	private String vaiTro;
	private static User[] dsUser = new User[0]; 
	public static String File_User = "./src/file/User";
	public User(String username, String password, String vaiTro) {
		super();
		this.username = username;
		this.password = password;
		this.vaiTro = vaiTro;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	public static User[] getDsUser() {
		return dsUser;
	}
	public static void setDsUser(User[] dsUser) {
		User.dsUser = dsUser;
	}
	public static String getFile_User() {
		return File_User;
	}
	public static void setFile_User(String file_User) {
		File_User = file_User;
	}
	
	public static int dangNhap() {
		String exit = "khong";
		do {
			System.out.print("Moi ban nhap username: ");
			String username = new Scanner(System.in).nextLine();
			System.out.println("Moi ban nhap password: ");
			String pass = new Scanner(System.in).nextLine();
			for(User u:dsUser) {
				if(u.getUsername().equals(username) && u.getPassword().equals(pass)) {
					switch (u.getVaiTro()) {
					case "quanly": {
						exit = "co";
						return 1;
					}
					case "ketoan":{
						exit = "co";
						return 2;
					}
					case "nhanvien":{
						exit = "co";
						return 3;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + u.getVaiTro());
					}
				}
			}
			System.out.println("Tk hoac mk chua dung");
			System.out.println("Ban co muon nhap lai khong (nhap 'y' de tiep tuc)");
			String yn = new Scanner(System.in).nextLine();
			if(yn.equals("y"))
				System.out.println("Moi ban nhap tiep ");
			else {
				exit ="co";
				
			}
				
		}while(exit.equals("khong"));
			
		return 0;
		
	}
	
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_User);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==3) {
				dsUser = Arrays.copyOf(dsUser, dsUser.length+1);
				dsUser[dsUser.length-1] = new User(arr[0] ,arr[1] , arr[2]);
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
		FileOutputStream fos = new FileOutputStream(File_User);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(User t:dsUser) {
			String line = t.getUsername()+";"+t.getPassword()+";"+t.getVaiTro();
			bw.write(line);
			bw.newLine();	
		}
		bw.close();
		fos.close();
		osw.close();
		System.out.println("Ghi thanh Cong");
		
		
	}
	
}
