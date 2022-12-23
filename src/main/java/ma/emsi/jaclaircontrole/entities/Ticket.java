package ma.emsi.jaclaircontrole.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String references;

    private double price ;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Match match;
}
