public class MovieTickets implements IMovieTickets{
    @Override
    public double CalculateTotalTicketPrice(int[] numberOfTickets, double ticketPrice) {

        return numberOfTickets.length * ticketPrice;
    }

    @Override
    public boolean validateData(MovieTicketData movieTicketData) {

        // VALIDATING MOVIE INFO
        if(movieTicketData.movieName.isEmpty()){
            return false;
        }
        if(movieTicketData.getTicketPrice() <= 0){
            return false;
        }
        if(movieTicketData.getNumOfTickets() <= 0){
            return false;
        }
        return true;
    }
}
