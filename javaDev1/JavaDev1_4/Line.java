package JavaDev1_4;

public abstract class Line {
    public void PrintInf(String[][] data)
    {
    	System.out.println("线对象 " + data[0][0] + "由点 (" + data[0][1] + "，" + data[0][2] + ") 到点 (" + data[0][3] + "，" + data[0][4] + ") ");
    }
    public Line() { };
    public Line(String[][] data)
    {
        PrintInf(data);
    }
}
