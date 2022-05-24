package javaOPP;

public class Testing extends Topic_04_Non_Access_Modifier {

	public static void main(String[] args) {
		// Truy cập trực tiếp từ tên class
	// KHông cần phải tạo instance/ Exer_Class_Object
		//Không nên lạm dụng tạo biến là static
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		// Khởi tạo các class
		Topic_04_Non_Access_Modifier.sendkeyToElement("link");
		//Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		//System.out.println(topic.colourCar);
	}
	@Override
	public void clickToElement(String elementName) {
		
	}
	
// Lớp lồng
	public static class NestedClass{
		
	}
}
