package javaOPP;

import javabasic.Topic_05_String;

public class Exer_Class_Object {
private int maSinhVien;
private String tenSinhVien;
private float diemLyThuyet;
private float diemThucHanh;
Topic_05_String  topic = new Topic_05_String();


	public Exer_Class_Object(int maSinhVien, String tenSinhVien, float diemLyThuyet, float diemThucHanh) {
	this.maSinhVien = maSinhVien;
	this.tenSinhVien = tenSinhVien;
	this.diemLyThuyet = diemLyThuyet;
	this.diemThucHanh = diemThucHanh;
}
	

	protected int getMaSinhVien() {
		return maSinhVien;
	}


	protected void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}


	protected String getTenSinhVien() {
		return tenSinhVien;
	}


	protected void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}


	protected float getDiemLyThuyet() {
		return diemLyThuyet;
	}


	protected void setDiemLyThuyet(float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}


	protected float getDiemThucHanh() {
		return diemThucHanh;
	}


	protected void setDiemThucHanh(float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}
public float diemTrungBinh() {
	 return (this.diemLyThuyet+this.diemThucHanh*2)/3;
	
			}
public void showInfoSV() {
	System.out.println("Ma SV: " + getMaSinhVien());
	System.out.println("Ten SV: " + getTenSinhVien());
	System.out.println("diem Trung binh: " + diemTrungBinh());
	
}
	public static void main(String[] args) {
		Exer_Class_Object sv1 = new Exer_Class_Object(1,"Hoa", 5,6);
		sv1.showInfoSV();
		Exer_Class_Object sv2 = new Exer_Class_Object( 2, "Thu" , 6, 7);
		Exer_Class_Object sv3 = new Exer_Class_Object( 3, "Thuy" , 7, 8);
		sv2.showInfoSV();
		sv3.showInfoSV();

	}

}
