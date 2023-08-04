package cinema;

public class CinemaInfo {
    private int row;
    private int column;
    private int price;
    public CinemaInfo(){

    }
    public CinemaInfo(int row, int column){
        this.row = row;
        this.column = column;
    }

    public CinemaInfo(int row ,int column, int price){
        this.row = row;
        this.column = column;
        this.price = price;


    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column= column;
    }
    public void setPrice(int price){
        this.price= price;
    }
    public int getPrice(){
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()){return false;}
        CinemaInfo cinemaInfo = (CinemaInfo) obj;
        return cinemaInfo.getColumn() == this.getColumn() && cinemaInfo.getRow() == this.getRow();
    }
}
