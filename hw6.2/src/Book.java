public class Book {
    public String title;
    public String author;
    public String[] pages;

    public Book(String title, String author, String[] pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }


    public int getPageCount() {
        return pages.length;
    }

    public String getInfo() {
        return "Title: " + title + "; author: " + author + "; " + getPageCount() + " pages";
    }

    public String getPageText(int page) {
        page ++;
        return "Page number " + page + ": " + pages[page - 1];
    }
}
