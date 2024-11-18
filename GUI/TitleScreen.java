package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen {
    
    private JPanel titleNamePanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 120);

    public TitleScreen() {
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(250, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("Stone War");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        titleNamePanel.add(titleNameLabel);
    }

    public JPanel getTitleNamePanel() {
        return titleNamePanel;
    }

}
