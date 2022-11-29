package qLyFood;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		NguyenLieuList dsNguyenLieu = new NguyenLieuList();
		try {
			dsNguyenLieu.docFile();
			
		} catch (IOException e) {
			System.out.println("Loi doc file");
		}
		
		dsNguyenLieu.timKiem();
	}
}
