package javaOPP_Overiding;

public class Employee extends Person implements IWork{
	public void eat() {
		System.out.println("Suat com di lam 30k");
	}
	public void sleep() {
		System.out.println("Ngay ngu 7h");
	}
	@Override
	public void workingTime() {
		System.out.println("Lam 8h");
	}
}
