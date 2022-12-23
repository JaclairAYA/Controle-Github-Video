package ma.emsi.jaclaircontrole.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchOutput {

    private String id;
    private String ReferenceMatch;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateAndTime;
    private String lieu;

    private String Equipe1;

    private String Equipe2;
}
