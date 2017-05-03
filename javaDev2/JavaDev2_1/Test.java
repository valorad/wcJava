package JavaDev2_1;

public class Test {
	public static void main(String args[]) {
		String x[] = {"abc", "123", "a123"};
		int i = 0;
		int aa = 0;
		try{
			System.out.println("第1个数组元数值为:" + x[0]);
			System.out.println("第2个数组元数值为:" + x[1]);
			System.out.println("第4个数组元数值为:" + x[3]);			
		}
		catch (Exception e){
			//System.out.println(e.toString());
			//e belongs to ArrayIndexOutOfBoundsException
			System.out.println("数组下标索引越界异常");
		}

		try{
			aa = Integer.parseInt(x[0]);
		}
		catch (Exception e) {
			i = -1;
			System.out.println("Unable to parse some of the input fetures");	
		}
		finally {
			if (i != -1) {
				System.out.println("“转为整形的值为 " + aa);	
			}
		}
	}

}
