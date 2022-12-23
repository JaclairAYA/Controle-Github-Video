package ma.emsi.jaclaircontrole.repositories;

import ma.emsi.jaclaircontrole.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,String> {
}
