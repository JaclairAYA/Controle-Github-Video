package ma.emsi.jaclaircontrole.Services.Ticket;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.jaclaircontrole.dtos.input.TicketInput;
import ma.emsi.jaclaircontrole.dtos.output.TicketOutput;
import ma.emsi.jaclaircontrole.entities.Match;
import ma.emsi.jaclaircontrole.entities.Status;
import ma.emsi.jaclaircontrole.entities.Ticket;
import ma.emsi.jaclaircontrole.exceptions.customs.*;
import ma.emsi.jaclaircontrole.mappers.MapperService;
import ma.emsi.jaclaircontrole.repositories.MatchRepository;
import ma.emsi.jaclaircontrole.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServicesImpl implements TicketServices{

    private TicketRepository ticketRepository;
    private MapperService mapperService;

    private MatchRepository matchRepository;



    public TicketOutput acheterTicket(TicketInput ticketInput) throws MissingFieldsException, GameIdNotFoundException, TicketsSoldOutException {
        if (ticketInput.getMatchId() == null || ticketInput.getMatchId().isEmpty()
                || ticketInput.getPrice().isNaN() || ticketInput.getPrice() <= 0)
            throw new MissingFieldsException();
        Match match= matchRepository.findById(ticketInput.getMatchId())
                .orElseThrow(
                        () -> new GameIdNotFoundException(ticketInput.getMatchId())
                );
        if(match.getAvailableTicketNumber()==0)
            throw  new TicketsSoldOutException();
        Ticket ticket= new Ticket();
        ticket.setID(UUID.randomUUID().toString());
        ticket.setPrice(ticketInput.getPrice());
        ticket.setStatus(Status.DESACTIVE);
        ticket.setReferences(UUID.randomUUID().toString());
        ticket.setMatch(match);
        match.setAvailableTicketNumber(match.getAvailableTicketNumber() -1);
        matchRepository.save(match);
        return mapperService.fromTicket(ticketRepository.save(ticket));

    }

    public void validateTicket(String id) throws TicketIdNotFoundException, TicketAlreadyValidatedException{

        Ticket ticket= ticketRepository.findById(id)
                .orElseThrow(
                        ()-> new TicketIdNotFoundException(id)
                );
        if(ticket.getStatus()==Status.DESACTIVE)
            throw new TicketAlreadyValidatedException(id);
        ticket.setStatus(Status.DESACTIVE);
        ticketRepository.save(ticket);

    }
    }

