package cinema;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    private int total_rows;
    private int total_columns;
    private List<CinemaInfo> available_seats;
    public Seats(){

    }
    public Seats(int row, int column){
        total_rows = row;
        total_columns = column;
        available_seats = new ArrayList<>();
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <= column; j++) {
                available_seats.add(i<=4? new CinemaInfo(i,j,10):new CinemaInfo(i,j,8));
            }

        }
    }

    public List<CinemaInfo> getAvailable_seats() {
        return available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public void setAvailable_seats(List<CinemaInfo> available_seats) {
        this.available_seats = available_seats;
    }
}
