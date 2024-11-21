package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Game.Player;
import GameSystem.AudioPlayer;

public abstract class Screen {

    protected JPanel panel;
    protected ScreenHandler screenHandler;
    protected Player player;
    protected JButton backButton;
    protected AudioPlayer titleScreenBacksound = new AudioPlayer("/Assets/Audio/titleScreenBG.wav");
    protected AudioPlayer battleScreenBacksound = new AudioPlayer("/Assets/Audio/battleScreenBG.wav");
    protected AudioPlayer victorySound = new AudioPlayer("/Assets/Audio/VictorySFX.wav");
    protected AudioPlayer defeatSound = new AudioPlayer("/Assets/Audio/DefeatSFX.wav");

    public Screen(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
    }

    protected void initialize() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1100, 768);
        panel.setBorder(new LineBorder(Color.WHITE, 3));
        panel.setBackground(Color.BLACK);

        backButton = addButton("Back", 10, 10, 100);
    }

    protected void submitAction() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.switchScreen("title");
            }
        });
    }

    protected abstract void onShow();

    protected JLabel addLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);

        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));

        return label;
    }

    protected JButton addButton(String text, int x, int y, int width) {
        JButton button = new JButton(text);

        button.setBounds(x, y, width, 50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        button.setBorder(new LineBorder(Color.WHITE, 1));
        button.setFocusPainted(false);

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

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBorder(new LineBorder(Color.WHITE, 1));
            }
        });
        
        return button;
    }

    public JPanel getPanel() {
        return panel;
    }
    
}
