package JunitTesting;

public class JUnitExample {

	private int first;
	private int second;
	
	
	public JUnitExample(int one, int two) {
		first = one;
		second = two;
	}

	public int simpleDivision() {
		int d = first / second;
		return (int) d;
	}
	
	
	public int simpleMultiplication(){
		int m = first * second;
		return (int) m;
	}

	public int simpleAddition(){
		int add = first + second;
		return (int) add;
	}

	public int simpleSubtraction(){
		int sub = first - second;
		return (int) sub;
	}
}