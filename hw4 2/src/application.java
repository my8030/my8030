import java.util.Scanner;

public class NumberOfVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
        int counter = 0;

        for (int i = 0; i < text.length(); i++){
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == (text.charAt(i))){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}

