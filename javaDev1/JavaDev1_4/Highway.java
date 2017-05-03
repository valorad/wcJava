package JavaDev1_4;

public class Highway extends Line {
    public void PrintInf(String[][] data)
    {
    	System.out.println("公路 " + data[1][0] + "由点 (" + data[1][1] + "，" + data[1][2] + ") 到点 (" + data[1][3] + "，" + data[1][4] + ") ");
    }
    public Highway(){ };
    public Highway(String[][] data)
    {
        PrintInf(data);
    }
}
