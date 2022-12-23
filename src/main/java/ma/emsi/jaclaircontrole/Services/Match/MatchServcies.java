package ma.emsi.jaclaircontrole.Services.Match;

import ma.emsi.jaclaircontrole.dtos.input.MatchInput;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.exceptions.customs.InvalidTicketsNumberException;
import ma.emsi.jaclaircontrole.exceptions.customs.MissingFieldsException;

import java.util.List;

public interface MatchServcies {
    MatchOutput creerMatch(MatchInput matchInput) throws MissingFieldsException, InvalidTicketsNumberException;
    List<MatchOutput> matchList();
}
