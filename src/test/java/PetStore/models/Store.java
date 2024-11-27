package PetStore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private int id;
    private int petId;
    private int quantity;
    private String  shipDate;
    private String status;
    private boolean complete;
}
