package javaOPP.abstraction;

public interface IAnimal {
	int SUM_NUMBER = 100;

	public String getName();

	public void setName(String name);

	public abstract String getAddress();

	public abstract void setAddress(String address);
}
