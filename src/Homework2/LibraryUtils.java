package Homework2;

import Homework2.Author;

public class LibraryUtils {
    public static void printDetails(Author author, Book book){
        System.out.println();
        System.out.println("Homework2.Book " + "< " + book.getName()+" >" + " ( " + book.getPrice() + " RON )" +
                " , by " + author.getName() + " , published in " + book.getYear());
        System.out.println("Contact the author for more details at the email address: " + author.getEmail());
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
