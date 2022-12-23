package ma.emsi.jaclaircontrole.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchInput {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateAndTime;
    private String lieu;

    private String Equipe1;

    private String Equipe2;

    private Integer availableTicketNumber;
}
