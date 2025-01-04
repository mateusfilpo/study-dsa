package dsa.search;

public class TwoCrystalBallsProblem {
	
	public static void main(String[] args) {
		boolean[] bool = {false, false, false, true, true, true};
		System.out.println(twoCrystalBalls(bool));
	}
	
	public static int twoCrystalBalls(boolean[] breaks) {
		
		int jmpAmount = (int) Math.sqrt(breaks.length);
		
		int i = jmpAmount;
		
		for (; i < breaks.length; i += jmpAmount) {
			if (breaks[i]) {
				break;
			}
		}
		
		i -= jmpAmount;
		
		for (int j = 0; j <= jmpAmount && i < breaks.length; ++j, ++i) {
			if (breaks[i]) {
				return i;
			}
		}
		
		return -1;
	}
}
