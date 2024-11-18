package GUI;

import javax.swing.JPanel;

import Game.Player;

public abstract class Screen {

    protected JPanel panel;
    protected ScreenHandler screenHandler;
    protected Player player;

    public Screen(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
    }

    protected abstract void initialize();

    public JPanel getPanel() {
        return panel;
    }

}
