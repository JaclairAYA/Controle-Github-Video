package ma.emsi.jaclaircontrole.Services.Match;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.jaclaircontrole.dtos.input.MatchInput;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.entities.Match;
import ma.emsi.jaclaircontrole.exceptions.customs.InvalidTicketsNumberException;
import ma.emsi.jaclaircontrole.exceptions.customs.MissingFieldsException;
import ma.emsi.jaclaircontrole.mappers.MapperService;
import ma.emsi.jaclaircontrole.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MatchServicesImpl implements MatchServcies{

    private MatchRepository matchRepository;
    private MapperService mapperService;


    public MatchOutput creerMatch(MatchInput matchInput) throws MissingFieldsException, InvalidTicketsNumberException {

        if (matchInput.getDateAndTime() == null || matchInput.getAvailableTicketNumber() == null
                || matchInput.getLieu() == null || matchInput.getLieu().isEmpty()
                || matchInput.getEquipe1() == null || matchInput.getEquipe1().isEmpty()
                || matchInput.getEquipe2() == null || matchInput.getEquipe2().isEmpty())
            throw new MissingFieldsException();
        if (matchInput.getAvailableTicketNumber() > 2022 || matchInput.getAvailableTicketNumber() <= 0)
            throw new InvalidTicketsNumberException(matchInput.getAvailableTicketNumber());
        Match match = new Match();
        match.setId(UUID.randomUUID().toString());
        match.setDateAndTime(matchInput.getDateAndTime());
        match.setLieu(match.getLieu());
        match.setEquipe1(match.getEquipe1());
        match.setEquipe2(match.getEquipe2());
        match.setReferenceMatch(match.getReferenceMatch());
        return mapperService.fromMatch(matchRepository.save(match));

    }

    @Override
    public List<MatchOutput> matchList() {
        return matchRepository.findAll().stream().map(
                m->mapperService.fromMatch(m)
        ).toList();
    }
}

