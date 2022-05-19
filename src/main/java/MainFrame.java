import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton startPacketSnifferButton;
    private JTextField AmountInSeconds;
    private JButton stopPacketSnifferButton;
    private JLabel RunningTime;
    private JPanel mainPanel;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Packet Sniffer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        startPacketSnifferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeAsString = AmountInSeconds.getText();
                System.out.println(timeAsString);
            }
        });
        stopPacketSnifferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop");
                // Create a new error message
                JOptionPane.showMessageDialog(null, "Packed sniffer stopped", "Packet sniffer", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

    }
}