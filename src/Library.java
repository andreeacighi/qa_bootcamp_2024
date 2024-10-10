public class Library {
    public static void main(String[] args) {
        // varianta cu o singura carte
        Author author = new Author("Delia Owens","delia.owens@gmail.com");
        Book book = new Book("Acolo unde canta racii",2022,author,53.10);

        LibraryUtils.printDetails(author,book);

        // varianta cu stocarea a mai multor carti
        Author[] authors = new Author[4];
        authors[0] = new Author("Ashley Elston","ashleyElston@gmail.com");
        authors[1] = new Author("Rebecca Yarros","reb.yarros@yahoo.com");
        authors[2] = new Author("Horatiu Malaele","horatiumalaele@gmail.com");
        authors[3] = new Author("Catherine Isaac","catherine.Isaac@yahoo.com");

        Book[] books = new Book[4];
        books[0] = new Book("Cine minte primul",2024,authors[0],39.9);
        books[1] = new Book("Wilder",2024,authors[1],39.9);
        books[2] = new Book("Tahomir",2024,authors[2],29);
        books[3] = new Book("Aici, acum, mereu",2018,authors[3],33.99);

        for (int i = 0; i < authors.length ; i++) {
            for (int j = 0; j < books.length; j++) {
                if (i == j) {
                   LibraryUtils.printDetails(authors[i], books[j]);
                }
            }
        }
    }
}
