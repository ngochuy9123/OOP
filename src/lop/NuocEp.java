package lop;

import java.io.IOException;

public class NuocEp extends Food {
	private int idTraiCay;
	public static NuocEp[] dsNuocEp = new NuocEp[0];
	public static String File_Nuoc_Ep = "./src/file/NuocEp";
	public NuocEp() {
		super();
	}
	public NuocEp(int id, String tenMonAn, double gia) {
		super(id, tenMonAn, gia);
	}
	public NuocEp(int id, String tenMonAn, double gia, int idTraiCay) {
		super(id, tenMonAn, gia);
		this.idTraiCay = idTraiCay;
	}
	
	
	public int getIdTraiCay() {
		return idTraiCay;
	}
	public void setIdTraiCay(int idTraiCay) {
		this.idTraiCay = idTraiCay;
	}
	public static NuocEp[] getDsNuocEp() {
		return dsNuocEp;
	}
	public static void setDsNuocEp(NuocEp[] dsNuocEp) {
		NuocEp.dsNuocEp = dsNuocEp;
	}
	public static String getFile_Nuoc_Ep() {
		return File_Nuoc_Ep;
	}
	public static void setFile_Nuoc_Ep(String file_Nuoc_Ep) {
		File_Nuoc_Ep = file_Nuoc_Ep;
	}
	
	@Override
	public double setGiaBan() {
		double giaNcEp = 0;
		for(TraiCay tc: TraiCay.dsTraiCay)
			if(tc.getId() == idTraiCay)
				giaNcEp = tc.getGia();
		return giaNcEp+getGia();
	}
	
	@Override
	public boolean ktTrung(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void xuatDs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void them() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void themNSp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void xoa() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sua() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoTen() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoGia() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sapXepTheoId() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void docFile() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ghiFile() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
