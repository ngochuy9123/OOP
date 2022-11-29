package service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import FileService.impl.FileService;
import lop.Food;
import lop.Hambuger;
import service.IStoreService;

public class StoreService implements IStoreService {
	static String orders;
	static String statics;
	static Map<Integer, Food> id = new HashMap<Integer, Food>();
	@Override
	public void order() {
		System.out.println(orders);
	}

	@Override
	public void printBill(Food product) {
		System.out.println(product.toString());
	}

	@Override
	public Double charge(Long giveMoney,Food product) {
		orders+=product.toString();
		statics+=product.toString();
		return giveMoney-product.getGia();
	}

	@Override
	public String printStatisc(){
			id.put(1, (new Hambuger().dsHambuger));
			FileInputStream fis = new FileInputStream("./src/file/DoanhThu");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			Double giaLoi=0d;
			Food listFood;
			while(line!=null) {
				String[] arr = line.split(";");
				 listFood=id.get(Integer.parseInt(arr[0]));
				 giaLoi+=listFood.getGia();
				line = br.readLine();
			}
	}
	
}
