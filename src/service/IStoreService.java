package service;

import lop.Food;

public interface IStoreService {
	void order();
	void printBill(Food product);
	Double charge(Long giveMoney,Food product);
	String printStatisc(String statics);
	String printStatisc();
}
