package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Game.Player;

public class WelcomeScreen extends Screen {
    
    private JLabel welcomeTextLabel;
    private JLabel inputNameLabel;
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

        welcomeTextLabel = new JLabel("Welcome to Stone War !");
        welcomeTextLabel.setBounds(215, 100, 671, 85);
        welcomeTextLabel.setForeground(Color.WHITE);
        welcomeTextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 64));

        inputNameLabel = new JLabel("Enter The Name :");
        inputNameLabel.setBounds(405, 286, 311, 53);
        inputNameLabel.setForeground(Color.WHITE);
        inputNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        inputNameField = new JFormattedTextField();
        inputNameField.setBounds(300,359, 500, 50);
        inputNameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        inputNameField.setHorizontalAlignment(JTextField.CENTER);

        submitButton = new JButton("Start Game");
        submitButton.setBounds(401, 510, 300, 50);
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        panel.add(welcomeTextLabel);
        panel.add(inputNameLabel);
        panel.add(inputNameField);
        panel.add(submitButton);
    }

    private void submitAction() {
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
