package FileService.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import FileService.IFileService;
import lop.Food;
import lop.Hambuger;

public class FileService implements IFileService{

	@Override
	public InputStreamReader docFile(String file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		return isr;
	}

	@Override
	public void ghiFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}
