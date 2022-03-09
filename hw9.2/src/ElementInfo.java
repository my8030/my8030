public class ElementInfo {
    static public String elementName = View.elementName;
    static public int elementPositionX = View.elementPositionX;
    static public int elementPositionY = View.elementPositionY;
    static public int elementSize = View.elementSize;

    static public String text = TextView.text;

    static private String iconName = ButtonView.iconName;

    static public String directoryOnDisk = ImageView.directoryOnDisk;
    static public String filterName = ImageView.filterName;
    static public double scaleFactor = ImageView.scaleFactor;




    public static String  printInfo(){
        StringBuilder builder = new StringBuilder("");
        builder.append("Element Name: " + elementName + ";\t");
        builder.append("Position: X=" + elementPositionX + " Y=" + elementPositionY + ";\t");
        builder.append("Size: " + elementSize + ";\n");
        builder.append("Text: " + text + ";\n");
        builder.append("Icon Name: " + iconName + ";\t");
        builder.append("Directory On Disk: " + directoryOnDisk + "\t");
        builder.append("Filter Name: " + filterName + ";\t");
        builder.append("Scale Factor: " + scaleFactor + ";\t");
        return builder.toString();


    }
}
