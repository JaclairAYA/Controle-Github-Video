package ma.emsi.jaclaircontrole.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.dtos.output.TicketOutput;
import ma.emsi.jaclaircontrole.entities.Match;
import ma.emsi.jaclaircontrole.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public MatchOutput fromMatch(Match match){
        MatchOutput matchOutput = new MatchOutput();
        BeanUtils.copyProperties(match,matchOutput);
        return matchOutput;
    }
    public TicketOutput fromTicket(Ticket ticket){
        TicketOutput ticketOutput = new TicketOutput();
        BeanUtils.copyProperties(ticket,ticketOutput);
        ticketOutput.setMatchOutput(this.fromMatch(ticket.getMatch()));
        return ticketOutput;
    }
}
