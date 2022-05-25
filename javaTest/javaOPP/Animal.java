package javaOPP;

public abstract class Animal {
	// variable
	String annimalName = "Dog";

	// Method
	// Không có phần thân
	// Bắt buộc class con phải override các hàm này lại
	protected abstract void setAnimal();
}
