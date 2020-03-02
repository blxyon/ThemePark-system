package comms;

import mainMenu.swapManagament.Swap;

public class SwapParser {
	public SwapParser() {};
	
	public Swap fromString(String swapString) {
		String[] elements = swapString.split(",");
		if (elements[0] != "swap") {
			return null;
		}
		Swap result = new Swap(elements[1], elements[2], elements[3], elements[4], elements[5]);
		return result;
	}
	
	public String turnToString(Swap swap) {
		String result = "swap";
		result += "," + swap.getTime();
		result += "," + swap.getT1();
		result += "," + swap.getT2();
		result += "," + swap.getT3();
		result += "," + swap.getT4();
		return result;
	}
}
