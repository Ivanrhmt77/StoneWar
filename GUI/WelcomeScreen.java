package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Game.Player;

public class WelcomeScreen extends Screen {
    
    private JFormattedTextField inputNameField;
    private JButton submitButton;

    public WelcomeScreen(ScreenHandler screenHandler) {
        super(screenHandler);
        initialize();
        submitAction();
    }

    @Override
    protected void initialize() {
        super.initialize();

        inputNameField = new JFormattedTextField();
        inputNameField.setBounds(300,359, 500, 50);
        inputNameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        inputNameField.setHorizontalAlignment(JTextField.CENTER);

        submitButton = addButton("Start Game", 401, 510, 300);

        panel.add(addLabel("Welcome to Stone War !", 215, 100, 671, 85, 64));
        panel.add(addLabel("Enter The Name :", 405, 286, 311, 53, 40));
        panel.add(inputNameField);
        panel.add(submitButton);
    }

    @Override
    protected void submitAction() {
        super.submitAction();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = inputNameField.getText().trim();

                if(playerName.isEmpty())
                    JOptionPane.showMessageDialog(inputNameField, "Please enter your name!", "Warning", JOptionPane.WARNING_MESSAGE);
                else {
                    player = new Player();
                    player.setName(playerName);
                    screenHandler.addScreen("title", new TitleScreen(screenHandler, player));
                    screenHandler.switchScreen("title");
                }
            }
        });
    }

}
