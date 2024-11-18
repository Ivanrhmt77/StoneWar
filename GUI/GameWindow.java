package GUI;

import java.awt.Color;

import javax.swing.JFrame;

public class GameWindow {

    private JFrame window;
    private ScreenHandler screenHandler;

    public static void main(String[] args) {
        new GameWindow();
    }

    public GameWindow() {
        initialize();
    }

    public void initialize() {
        window = new JFrame("Stone War");
        window.getContentPane().setBackground(Color.BLACK);
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        screenHandler = new ScreenHandler(window);
        screenHandler.switchScreen("welcome");

        window.setVisible(true);
    }

}