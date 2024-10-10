import lombok.Getter;
import lombok.Setter;

public  class Author {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
