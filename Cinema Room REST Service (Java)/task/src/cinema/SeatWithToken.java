package cinema;

import java.util.UUID;

public class SeatWithToken {
    private UUID token;

    private  CinemaInfo ticket;
    public SeatWithToken(){

    }

    public SeatWithToken(UUID token, CinemaInfo ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public CinemaInfo getTicket() {
        return ticket;
    }

    public void setTicket(CinemaInfo ticket) {
        this.ticket = ticket;
    }
}
