package lop;

public abstract class Food implements InterDanhSach,InterFile {
	private int id;
	private String tenMonAn;
	private double gia;
	
	public Food() {
		super();
	}
	public Food(int id, String tenMonAn, double gia) {
		super();
		this.id = id;
		this.tenMonAn = tenMonAn;
		this.gia = gia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenMonAn() {
		return tenMonAn;
	}
	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double tinhGiaTheoSize() {
		return 0;
	}
	public abstract double setGiaBan();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("|%-5s | %-20s | %-8s  ",
		        id, tenMonAn, gia);	
	}
}
