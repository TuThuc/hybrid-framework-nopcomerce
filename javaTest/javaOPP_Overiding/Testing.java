package javaOPP_Overiding;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static boolean checkState() {
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("C+");
		list.add("PHP Java");
		list.add("PHP ");

		boolean state = true;
		int countJava = 0;
		// show list
		for (String string : list) {
			System.out.println("----" + string);
			if (!string.contains("Java")) {
				state = false;

				// if ((string.contains("Java"))) {
				// state = false;
				// countJava++;
				// //
				// } else {
				//
				// state = false;
				// countJava++;
				// break;

			}
		}
		// System.out.println("----countJava=" + countJava);
		return state;

	}

	public static void main(String[] args) {
		boolean test = checkState();
		System.out.println("");
		System.out.println("");
		System.out.println(test);

	}

}
