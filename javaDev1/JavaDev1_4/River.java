package JavaDev1_4;

public class River extends Line {
    public void PrintInf(String[][] data)
    {
    	System.out.println("河 " + data[2][0] + "由点 (" + data[2][1] + "，" + data[2][2] + ") 到点 (" + data[2][3] + "，" + data[2][4] + ") ");
    }
    public River(){ };
    public River(String[][] data)
    {
        PrintInf(data);
    }
}
