import java.util.Scanner;

public class BookReader {
    public static void main(String[] args) {

        Book[] books = {
                new Book(
                        "Russian fairy tales",
                        "Russian people",
                        new String[] {"Жили были дед и баба", "Жили были прадед и прабаба", "Жили были кот и собака", "Жили были пракот и прасобака", "А потом все померли. Конец"}
                ),
                new Book(
                        "Ukrainian fairy tales",
                        "Ukrainian people",
                        new String[] {"Жили були дід та баба", "Жили були прадід і прабаба", "Жили були кіт і собака", "Жили були пракіт і прасобака", "А потім всі померли. Кінець"}
                ),
                new Book(
                        "English fairy tales",
                        "English people",
                        new String[] {"Once upon a time there lived a grandfather and a woman", "There lived a great-grandfather and a great-grandfather", "There lived a cat and a dog", "There lived a great-cat and a great-dog", "And then everyone died. The end."}
                )
        };
        printBookInfo(books);
        readPage(books);
    }


    public static void printBookInfo(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getInfo());
        }
        System.out.println("================================ \n");
    }

    public static void readPage(Book[] books){
        System.out.println("Enter the book number to read: ");
        int bookNumber = numberBook(books);
        System.out.println("Enter the page number to read: ");
        int pageNumber = numberPage(bookNumber, books);
        System.out.println(books[bookNumber-1].getPageText(pageNumber-1));
    }

    public static int numberBook(Book[] books){
        Scanner scanner = new Scanner(System.in);
        int numberBook = 0;
        while (numberBook <= 0 || numberBook > books.length) {
            numberBook = scanner.nextInt();
            if (numberBook <= 0 || numberBook > books.length) {
                System.out.println("There is no such book!");
            }
        }
        return numberBook;
    }

    public static int numberPage(int bookNumber, Book[] books){
        Scanner scanner = new Scanner(System.in);
        int numberPage = 0;
        while (numberPage <= 0 || numberPage > books[bookNumber-1].getPageCount()) {
            numberPage = scanner.nextInt();
            if (numberPage <= 0 || numberPage > books[bookNumber-1].getPageCount()) {
                System.out.println("There is no such book!");
            }
        }
        return numberPage;
    }


}
