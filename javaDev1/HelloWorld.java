
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		BankIssue bank = new BankIssue();
		bank.name = "CCCCCCB";
		bank.YuE = 20.8888;
		bank.CK(130.66);
		bank.QK(800.66);
		bank.CX();
		
		Triangle tr1 = new Triangle(3, 4);
		System.out.println(tr1.CaArea());
		Triangle tr2 = new Triangle(9, 10, 1.5);
		System.out.println(tr2.CaArea());
		System.out.println(tr2.AltAnglePlusCaArea(0.6));
		
	}

}
