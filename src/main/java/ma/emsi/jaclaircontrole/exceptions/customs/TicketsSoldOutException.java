package ma.emsi.jaclaircontrole.exceptions.customs;

public class TicketsSoldOutException extends Exception{
    public TicketsSoldOutException(){
        super("Tickets For this Game are Sold Out!!!");
    }
}
