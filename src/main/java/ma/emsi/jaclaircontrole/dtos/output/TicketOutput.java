package ma.emsi.jaclaircontrole.dtos.output;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.jaclaircontrole.entities.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutput {

    private String ID;
    private String references;

    private double price ;

    @Enumerated(EnumType.STRING)
    private Status status;

    private MatchOutput matchOutput;
}
