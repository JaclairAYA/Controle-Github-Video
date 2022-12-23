package ma.emsi.jaclaircontrole.web;

import lombok.AllArgsConstructor;
import ma.emsi.jaclaircontrole.Services.Ticket.TicketServices;
import ma.emsi.jaclaircontrole.dtos.input.MatchInput;
import ma.emsi.jaclaircontrole.dtos.input.TicketInput;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.dtos.output.TicketOutput;
import ma.emsi.jaclaircontrole.exceptions.customs.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TicketGraphqlController {

    private TicketServices ticketServices;
    private TicketOutput prendreTicket(@Argument TicketInput ticketInput) throws GameIdNotFoundException, MissingFieldsException, TicketsSoldOutException {
        return ticketServices.acheterTicket(ticketInput);

    }

    @QueryMapping
    private void MettreaJourTicket(@Argument String id) throws TicketIdNotFoundException,TicketAlreadyValidatedException{
    ticketServices.validateTicket(id);
    }
}
