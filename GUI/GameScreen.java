package GUI;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Game.Player;

public class GameScreen {

    private JFrame window;
    private Container container;
    private JPanel wrapperPanel;
    private Player player = new Player();
    private TitleScreen titleScreen = new TitleScreen();
    private WelcomeScreen welcomeScreen = new WelcomeScreen(player);

    public static void main(String[] args) {
         GameScreen gameScreen = new GameScreen();
         gameScreen.showWelcomeScreen();
    }

    public GameScreen() {
        window = new JFrame();
        container = window.getContentPane();
        wrapperPanel = new JPanel();

        wrapperPanel.setLayout(null);
        wrapperPanel.setBounds(50, 50, 1100, 768);
        wrapperPanel.setBorder(new LineBorder(Color.WHITE, 3));
        wrapperPanel.setBackground(Color.BLACK);

        container.setBackground(Color.BLACK);
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setTitle("Stone War");

        container.add(wrapperPanel);
    }

    public void showWelcomeScreen() {
        wrapperPanel.removeAll();
        wrapperPanel.add(welcomeScreen.getPanel());
        refreshScreen();
    }

    public void showTitleScreen() {
        wrapperPanel.removeAll();
        wrapperPanel.add(titleScreen.getTitleNamePanel());
        refreshScreen();
    }

    private void refreshScreen() {
        wrapperPanel.revalidate();
        wrapperPanel.repaint();
        container.revalidate();
        container.repaint();
    }
}