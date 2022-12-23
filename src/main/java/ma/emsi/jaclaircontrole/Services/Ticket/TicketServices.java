package ma.emsi.jaclaircontrole.Services.Ticket;

import ma.emsi.jaclaircontrole.dtos.input.TicketInput;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.dtos.output.TicketOutput;
import ma.emsi.jaclaircontrole.exceptions.customs.*;

public interface TicketServices {
        TicketOutput acheterTicket(TicketInput ticketInputput) throws MissingFieldsException, GameIdNotFoundException, TicketsSoldOutException;

        void validateTicket(String id) throws TicketIdNotFoundException, TicketAlreadyValidatedException;

}
