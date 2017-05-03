package JavaDev2_3;

public class regNum {
	int regnum = 0;

	public regNum(int num) throws B0Exception {
		regnum = num;
		if (num < 0) {
			throw new B0Exception("Be aware that your number is below 0");
		}
	}
	
}
