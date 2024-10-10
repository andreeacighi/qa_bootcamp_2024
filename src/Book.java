import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Book {
    @Setter @Getter
    private String name;
    @Setter @Getter
    private  int year;
    @Setter @Getter
    private Author author;
    @Setter @Getter
    private double price;

    public Book(String name, int year, Author author, double price) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.price = price;
    }

}
