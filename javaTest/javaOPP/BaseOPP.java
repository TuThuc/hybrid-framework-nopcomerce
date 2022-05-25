package javaOPP;

public class BaseOPP {
	public long shortTimeout = 15;
	protected long longTimeout = 45;
	public BaseOPP() {
		System.out.println("contructor cua class cha" );
	}
	public BaseOPP(String name) {
		System.out.println("contructor cua class cha " + name);
	}
	public BaseOPP(int number) {
		System.out.println("contructor cua class cha"+ number);
	}
	public void detTime() {
		System.out.println(longTimeout);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
