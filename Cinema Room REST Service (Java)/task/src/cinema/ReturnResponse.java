package cinema;

public class ReturnResponse {
    public CinemaInfo getReturned_ticket() {
        return returned_ticket;
    }
    public  ReturnResponse(){

    }

    public ReturnResponse(CinemaInfo returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public void setReturned_ticket(CinemaInfo returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    private CinemaInfo returned_ticket;

}
