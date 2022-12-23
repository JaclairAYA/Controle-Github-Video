package ma.emsi.jaclaircontrole.repositories;

import ma.emsi.jaclaircontrole.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket,String> {
}
