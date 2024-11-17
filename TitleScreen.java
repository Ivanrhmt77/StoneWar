import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TitleScreen {

    private JFrame window;
    private Container container;
    private JPanel wrapperPanel;
    private JPanel titleNamePanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 120);

    public static void main(String[] args) {
         new TitleScreen();
    }

    public TitleScreen() {
        window = new JFrame();
        container = window.getContentPane();
        wrapperPanel = new JPanel();

        wrapperPanel.setLayout(null);
        wrapperPanel.setBounds(0, 0, 1200, 868);
        wrapperPanel.setBorder(new LineBorder(Color.WHITE, 5));
        wrapperPanel.setBackground(Color.BLACK);

        container.setBackground(Color.BLACK);
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle("Stone War");

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(300, 150, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("Stone War");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        titleNamePanel.add(titleNameLabel);
        wrapperPanel.add(titleNamePanel);
        container.add(wrapperPanel);
    }
}