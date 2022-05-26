package javaOPP_Overiding;

public class Student extends Person implements IWork{
	@Override
public void eat() {
	System.out.println("Suat com  hoc sinh 15k");
}
	public void sleep() {
		System.out.println("Ngay ngu 12h");
	}
	@Override
	public void workingTime() {
		System.out.println("Hoc 3h");
	}
}
