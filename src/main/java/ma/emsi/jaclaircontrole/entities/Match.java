package ma.emsi.jaclaircontrole.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String ReferenceMatch;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateAndTime;
    private  String lieu;

    private String Equipe1;

    private String Equipe2;

    private Integer availableTicketNumber;
    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets;

}
