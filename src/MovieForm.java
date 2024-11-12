import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MovieForm extends JFrame {

    //
     public TextField movieName;
    public JTextField numOfTickets;
    public JTextField ticketPrice;
    public JTextArea ticketReportArea;
    MovieTickets tickets;

    public void RunApp(){
        tickets = new MovieTickets();
        // initializing the form
        setTitle("Movie Tickets");
        setSize(500,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // JPanel initialize
        JPanel panel = new JPanel(new GridLayout(5,2));
        // initializing the fields
//        movieName = new JComboBox<String>(String)
        movieName = new TextField();
        numOfTickets = new JTextField();
        ticketPrice = new JTextField();

        panel.add(new JLabel("Movie: "));
        panel.add(movieName);

        panel.add(new JLabel("Number Of Tickets: "));
        panel.add(numOfTickets);

        panel.add(new JLabel("Ticket Price"));
        panel.add(ticketPrice);

        add(panel,BorderLayout.NORTH);
        panel.add(new JLabel("Ticket Report"));
        add(new JScrollPane(ticketReportArea),BorderLayout.CENTER);
        // Menu Items

        MenuBar menuBar = new MenuBar();
        JMenu FileMenu = new JMenu("File");
        JMenu ToolsMenu = new JMenu("Tools");

        /// Menu items EXIT
        JMenuItem exit = new JMenuItem("exit");
        exit.addActionListener(e -> System.exit(0));
        FileMenu.add(exit);


        /// PROCESS MENU ITEM
        JMenuItem process = new JMenuItem("process");
        process.addActionListener(e -> {
            try {
                process();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ToolsMenu.add(process);

        // CLEAR ITEM MENU
        JMenuItem clear = new JMenuItem("clear");
        clear.addActionListener(e -> clear());
        ToolsMenu.add(clear);

//        menuBar.add(FileMenu);
//        menuBar.add(ToolsMenu);
        setMenuBar(menuBar);





    }

    //Process Method

    public void process() throws IOException {
        int ticketPriceCorrect = Integer.parseInt(ticketPrice.getText());
        int numberOfTickets = Integer.parseInt(numOfTickets.getText());

        MovieTicketData movieTickets = new MovieTicketData("OppenHeimer", ticketPriceCorrect,numberOfTickets);

        int[] num2tickets = {numberOfTickets};


        if(tickets.validateData(movieTickets)){

            int totalTicketPrice = (int) tickets.CalculateTotalTicketPrice(num2tickets,ticketPriceCorrect);
            // Displaying data on text area
            ticketReportArea.append("Movie: " + movieName.getName() + "\n");
            ticketReportArea.append("Movie Ticket Price " + ticketPriceCorrect + "\n");
            ticketReportArea.append("Number Of Tickets " + ticketPriceCorrect + "\n");
            ticketReportArea.append("Total Movie Ticket Price " + totalTicketPrice + "\n");

            // printing the message to reports text
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))){
                writer.write(ticketReportArea.getText());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    // RESET VALUES FOR MOVIES TICKETS TO PRICE TICKET
    public void clear(){
//        movieName
        numOfTickets.setText("");
        ticketPrice.setText("");
        ticketReportArea.setText("");
    }



     public static void main(String[] args) {

        MovieForm app = new MovieForm();
        app.RunApp();
        app.setVisible(true);

    }


}
