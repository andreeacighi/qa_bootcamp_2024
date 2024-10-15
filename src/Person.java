import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Person {

    private String name;
    private String surname;
    private String dateOfBirth;

    public void eat(){
        System.out.println("The person eats healthy every day.");
    }
}
