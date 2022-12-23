package ma.emsi.jaclaircontrole.dtos.input;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInput {

    private Double price;
    private String matchId;
}
