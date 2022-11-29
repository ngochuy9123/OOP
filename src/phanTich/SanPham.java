package phanTich;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import lop.InterFile;

public class SanPham implements InterFile {
	private int loaiSanPham;
	private int idSanPham;
	private int soLieu;
	String file_Doanh_Thu = "./src/file/DoanhThu";
	public static SanPham[] dssp = new SanPham[0];
	
	public SanPham() {
		super();
	}
	public SanPham(int loaiSanPham, int idSanPham, int soLieu) {
		super();
		this.loaiSanPham = loaiSanPham;
		this.idSanPham = idSanPham;
		this.soLieu = soLieu;
	}
	public int getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(int loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getSoLieu() {
		return soLieu;
	}
	public void setSoLieu(int soLieu) {
		this.soLieu = soLieu;
	}
	
	
	@Override
	public void docFile() throws IOException {
		FileInputStream fis = new FileInputStream(file_Doanh_Thu);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			
			if(arr.length==4) {
				dssp = Arrays.copyOf(dssp, dssp.length+1);
				dssp[dssp.length-1] = new SanPham(Integer.parseInt(arr[0]) ,Integer.parseInt(arr[2])  , Integer.parseInt(arr[3]) );
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
		System.out.println("Khong Can Thiet");
		
	}
	
}
