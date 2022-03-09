public class ImageView extends View{
    public static double scaleFactor;
    public static String filterName;
    public static String directoryOnDisk;


    public ImageView(String directoryOnDisk, String filterName, double scaleFactor) {
        this.directoryOnDisk = directoryOnDisk;
        this.filterName = filterName;
        this.scaleFactor = scaleFactor;
    }
}

