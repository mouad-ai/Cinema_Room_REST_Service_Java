package cinema;

public class Reponse {
    String error ;
    public Reponse(){

    }
    public Reponse(String error){
        this.error = error;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
