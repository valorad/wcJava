
public class BankIssue {
	String name = "Default Bank";
	double YuE = 0.0;
	
	public void CK(double m) {
		YuE += m;
		System.out.println("Balance + " + m + ", you have " + YuE + " $ now.");
	}
	public void QK(double m) {
		if (YuE >= m) {
			YuE -= m;
			System.out.println("Balance - " + m + ", you still have " + YuE + " $ now.");
		}
		else {
			System.out.println("Balance < " + m + ", Withdraw action failure. You have " + YuE + " $ now.");
		}
		
	}
	
	public void CX() {
		System.out.println("you have " + YuE + " $ in " + name + " now.");
	}
	
	public static void main(String[] args) {		
		;
	}

}
