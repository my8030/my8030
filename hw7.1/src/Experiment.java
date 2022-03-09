public class Experiment {
    public static void main(String[] args) {
        String tort1 = "Tort";
        String tort2 = "Tort";
        String tort3 = new String("Tort");

        if (tort1 == tort2){
            System.out.println("tort1 == tort2 True");
        } else {
            System.out.println("tort1 == tort2 False");
        }

        if (tort1 == tort3){
            System.out.println("tort1 == tort2 True");
        } else {
            System.out.println("tort1 == tort2 False");
        }

    }
}
