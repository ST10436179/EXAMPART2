public interface IMovieTickets {
    double CalculateTotalTicketPrice(int[] numberOfTickets,double ticketPrice);
    boolean validateData(MovieTicketData movieTicketData);
}
