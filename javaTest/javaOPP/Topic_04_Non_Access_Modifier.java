package javaOPP;

public abstract class Topic_04_Non_Access_Modifier {
	//static : Variable / Method
	// Dùng cho tất cả instance/ object
	// Phạm vi cho toàn hệ thống sử dụng
	// Có thể override được
			static String browserName  = "Chrome";
			//Non static 
	String serverName = "Testing";	
	// Hằng số
	final String colourCar = "Red";
	final static String REGISTER_BUTTON = "";
	public static void main(String[] args) {
		System.out.println(browserName);
		browserName  = "firefox";
		System.out.println(browserName);
		
		
//		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
//		System.out.println(topic.serverName);
//		//Không được phép gán lại giá trị
//			System.out.println(topic.colourCar);
//			
//		topic.clickToElement("button");
		sendkeyToElement("test");
	}
	//Non static
public void clickToElement(String elementName) {
	System.out.println(elementName);
}
// Static
public static void sendkeyToElement(String elementName) {
	System.out.println(elementName);
}
// final Method
public final void setCarName() {
	
}

}
