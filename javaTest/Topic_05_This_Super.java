
public class Topic_05_This_Super {
	private int firstNumber;
	private int secondNumber;

	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public Topic_05_This_Super() {

		this(5, 10);

	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super(5, 10);
		topic.sumNumber();
	}

}
