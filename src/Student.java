import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Student extends Person {
    private double[] grades;

    public void takeExam(){
        System.out.println("The student attends the exam ");
    }
}
