import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton startPacketSnifferButton;
    private JTextField AmountInSeconds;
    private JButton stopPacketSnifferButton;
    private JLabel RunningTime;
    private JPanel mainPanel;
    private JLabel status;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Packet Sniffer");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        // Start button
        startPacketSnifferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeAsString = AmountInSeconds.getText();
                System.out.println(timeAsString);
                int time = 0;
                boolean converted = false;

                // check if timeAsString string contains anything except numbers
                // if it does we give an error message
                // if it doesn't we convert it to an int and start the sniffer
                if (timeAsString.matches("[0-9]+")) {
                    // putting the time conversion into an int to a try catch block in case the number entered is bigget than int limit
                    // TODO: make it so that it doesn't crash if the number is bigger than int limit
                        try {
                            time = Integer.parseInt(timeAsString);
                            converted = true;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "The number is too big", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        if(converted) {
                            RunningTime.setText("Running for: " + time + " seconds");
                            status.setText("Status: Running");
                        }

                }else {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }


            }
        });

        // Stop button
        stopPacketSnifferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop");
                status.setText("Status: Stopped");
                // Create a new error message
                JOptionPane.showMessageDialog(null, "Packed sniffer stopped", "Packet sniffer", JOptionPane.INFORMATION_MESSAGE);



            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

    }

}