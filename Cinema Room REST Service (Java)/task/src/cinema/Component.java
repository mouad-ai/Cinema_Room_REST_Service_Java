package cinema;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Component
public class Component {
    private Seats seats;
    private List<CinemaInfo> occupiedSeats;

    @PostConstruct
    public void initialize(){
        seats = new Seats(9,9);


    }
    public Seats getSeats() {
        return seats;
    }
}
