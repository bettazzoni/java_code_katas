package leapyear;

public class LeapYear {

	public boolean isLeap(int i) {
		
		return 	(i>=4) && (isDivisibleBy(i, 4))
				&& 
				((i < 1582)
						|| ( ! isDivisibleBy(i, 100) || isDivisibleBy(i, 400)));
	}

	private boolean isDivisibleBy(int i, int div) {
		return i % div == 0;
	}

}
