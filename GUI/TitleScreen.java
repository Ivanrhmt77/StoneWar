package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Game.Player;
import GameSystem.AudioPlayer;

public class TitleScreen extends Screen {

    private AudioPlayer backgroundMusic = new AudioPlayer("/Assets/Audio/titleScreenBG.wav");

    public TitleScreen(ScreenHandler screenHandler, Player player) {
        super(screenHandler);

        this.player = player;
        backgroundMusic.loop();

        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        panel.add(addLabel("Stone War", 276, 100, 548, 160, 120));
        panel.add(addLabel("Name : " + player.getName(), 30, 30, 326, 32, 24));
        panel.add(addLabel("Level " + player.getLevel(), 601, 30, 92, 32, 24));
        panel.add(addLabel("Exp : " + player.getExp() + "/" + player.getMaxExp(), 743, 30, 150, 32, 24));
        panel.add(addLabel("Gold : " + player.getGold(), 943, 30, 127, 32, 24));

        panel.add(addMenuButton("Start Battle", 358));
        panel.add(addMenuButton("Gacha", 428));
        panel.add(addMenuButton("Inventory", 498));
        panel.add(addMenuButton("Exit", 568));
    }

    private JLabel addLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);

        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));

        return label;
    }

    private JButton addMenuButton(String text, int y) {
        JButton button = new JButton(text);

        button.setBounds(301, y, 500, 50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        button.setBorder(new LineBorder(Color.WHITE, 1));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBorder(new LineBorder(Color.MAGENTA, 2));
            }
    
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBorder(new LineBorder(Color.WHITE, 1));
            }
        });

        return button;
    }

}
