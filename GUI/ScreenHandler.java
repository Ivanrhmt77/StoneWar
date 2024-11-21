package GUI;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ScreenHandler {

    private JPanel wrapperPanel;

    private Map<String, Screen> screens = new HashMap<>();
    private Screen currentScreen;

    public ScreenHandler(JFrame window) {
        initialize();

        window.getContentPane().add(wrapperPanel);
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public void addScreen(String name, Screen screen) {
        screens.put(name, screen);
    }

    public void switchScreen(String name) {
        if(currentScreen != null)
            wrapperPanel.removeAll();
        
        Screen newScreen = screens.get(name);
        if(newScreen != null && newScreen.getPanel() != null) {
            wrapperPanel.add(newScreen.getPanel());
            currentScreen = newScreen;
            currentScreen.onShow();
        }

        wrapperPanel.revalidate();
        wrapperPanel.repaint();
    }

    private void initialize() {
        wrapperPanel = new JPanel();
        wrapperPanel.setLayout(null);
        wrapperPanel.setBounds(50, 50, 1100, 768);
        wrapperPanel.setBorder(new LineBorder(Color.WHITE, 3));
        wrapperPanel.setBackground(Color.BLACK);

        addScreen("welcome", new WelcomeScreen(this));
    }

}
