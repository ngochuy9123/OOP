package kinhDoanh;

public class VaiTro {
	private int id;
	private String tenVaiTro;
	public VaiTro(int id, String tenVaiTro) {
		super();
		this.id = id;
		this.tenVaiTro = tenVaiTro;
	}
	public VaiTro() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenVaiTro() {
		return tenVaiTro;
	}
	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}
	
}
