package ma.emsi.jaclaircontrole.web;

import lombok.AllArgsConstructor;
import ma.emsi.jaclaircontrole.Services.Match.MatchServcies;
import ma.emsi.jaclaircontrole.dtos.input.MatchInput;
import ma.emsi.jaclaircontrole.dtos.output.MatchOutput;
import ma.emsi.jaclaircontrole.exceptions.customs.InvalidTicketsNumberException;
import ma.emsi.jaclaircontrole.exceptions.customs.MissingFieldsException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class MatchGraphqlController {
    private MatchServcies matchServcies;
    @MutationMapping
    private MatchOutput ajouterMatch(@Argument MatchInput matchInput) throws MissingFieldsException , InvalidTicketsNumberException{
        return matchServcies.creerMatch(matchInput);

    }

    @QueryMapping
    private List<MatchOutput>getMatch(){
        return matchServcies.matchList();
    }
}
