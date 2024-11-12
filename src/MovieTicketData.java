public class MovieTicketData {
    String movieName;
    int ticketPrice;
    int numOfTickets;

    public MovieTicketData(String movieName, int ticketPrice, int numOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numOfTickets = numOfTickets;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }
}
