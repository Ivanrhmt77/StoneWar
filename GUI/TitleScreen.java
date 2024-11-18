package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Player;

public class TitleScreen extends Screen {
    
    private JLabel titleNameLabel;

    public TitleScreen(ScreenHandler screenHandler, Player player) {
        super(screenHandler);
        this.player = player;
        initialize();
    }

    @Override
    protected void initialize() {
        panel = new JPanel();
        panel.setBounds(250, 100, 600, 150);
        panel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("Stone War");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 120));

        panel.add(titleNameLabel);
    }

}
