package cinema;

import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@RestController
public class Controller {
    private Seats seats ;
    private Hashtable<UUID, CinemaInfo> tickets = new Hashtable<UUID, CinemaInfo>();
    @Autowired
    public Controller(Component component){
        this.seats = component.getSeats();
    }




    @GetMapping("/seats")
    public Seats getSeats() throws IOException, JSONException {



        return seats;
    }
    @PostMapping("/purchase")
    public ResponseEntity<?> buyAnSeat(@RequestBody CinemaInfo cinemaInfo) {
            if( cinemaInfo.getRow()<=0 || cinemaInfo.getColumn()<=0 || cinemaInfo.getRow() > seats.getTotal_rows() || cinemaInfo.getColumn()> seats.getTotal_columns()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Reponse("The number of a row or a column is out of bounds!"));

            }
            Optional<CinemaInfo> cinemaInfoStream = seats.getAvailable_seats()
                    .stream()
                    .filter(cinemaInfo1 -> cinemaInfo1.equals(cinemaInfo))
                    .findFirst();

            if (cinemaInfoStream.isPresent()) {
                SeatWithToken ticket = new SeatWithToken(UUID.randomUUID(),cinemaInfoStream.get());
                seats.getAvailable_seats().remove(cinemaInfoStream.get());
                tickets.put(ticket.getToken(),ticket.getTicket());
                return ResponseEntity.ok(ticket);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Reponse("The ticket has been already purchased!"));

            }

}
    @PostMapping("/return")
    public ResponseEntity<?> refund(@RequestBody SeatWithToken ticket){
        if (tickets.containsKey(ticket.getToken())){
            CinemaInfo returned_ticket = tickets.get(ticket.getToken());
            tickets.remove(ticket.getToken());
            seats.getAvailable_seats().add(returned_ticket);
            ReturnResponse response = new ReturnResponse(returned_ticket);

            return ResponseEntity.ok(response);

        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Reponse("Wrong token!"));


        }

    }
    @GetMapping("/stats")
    public  ResponseEntity<?> stats(HttpServletRequest request){
        String password = request.getParameter("password");


            if(password != null && password.equals("super_secret")){
            StatsResponse statsResponse = new StatsResponse();
            statsResponse.setCurrent_income(tickets.values().stream().mapToInt(CinemaInfo::getPrice).sum());
            statsResponse.setNumber_of_purchased_tickets(tickets.values().size());
            statsResponse.setNumber_of_available_seats(seats.getAvailable_seats().size());
            return ResponseEntity.ok(statsResponse);

        }else{

                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Reponse("The password is wrong!"));



            }

    }

}


