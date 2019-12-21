package pl.awarkoczewski.blockbusters.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blockbuster {

    private Long id;
    private Long bookId;
    private Long rentalCount;

    public Long tagRentalCount(){
        return rentalCount += rentalCount+1;
    }
}
