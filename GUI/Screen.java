package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Game.Player;

public class Screen {

    protected JPanel panel;
    protected ScreenHandler screenHandler;
    protected Player player;

    public Screen(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
    }

    protected void initialize() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1100, 768);
        panel.setBorder(new LineBorder(Color.WHITE, 3));
        panel.setBackground(Color.BLACK);
    }

    public JPanel getPanel() {
        return panel;
    }

}
