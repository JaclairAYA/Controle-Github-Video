package ma.emsi.jaclaircontrole.exceptions.customs;

public class TicketAlreadyValidatedException extends Exception{
    public TicketAlreadyValidatedException(String id){
        super("Ticket with id: "+id+", Has Already been used!!");
    }
}
