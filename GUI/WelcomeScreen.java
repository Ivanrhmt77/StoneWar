package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Game.Player;

public class WelcomeScreen {
    
    private Player player;
    private JPanel panel;
    private JLabel welcomeTextLabel;
    private JLabel inputNameLabel;
    private JFormattedTextField inputNameField;
    private JButton submitButton;

    public WelcomeScreen(Player player) {
        this.player = player;
        intializePanel();
        intializeWelcomeText();
        intializeInputName();
        intializeSubmit();
        submitAction();
    }

    private void intializePanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1100, 768);
        panel.setBorder(new LineBorder(Color.WHITE, 3));
        panel.setBackground(Color.BLACK);
    }

    private void intializeWelcomeText() {
        welcomeTextLabel = new JLabel("Welcome to Stone War !");
        welcomeTextLabel.setBounds(215, 100, 671, 85);
        welcomeTextLabel.setForeground(Color.WHITE);
        welcomeTextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 64));

        panel.add(welcomeTextLabel);
    }

    private void intializeInputName() {
        inputNameLabel = new JLabel("Enter The Name :");
        inputNameLabel.setBounds(405, 286, 311, 53);
        inputNameLabel.setForeground(Color.WHITE);
        inputNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        inputNameField = new JFormattedTextField();
        inputNameField.setBounds(300,359, 500, 50);
        inputNameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        inputNameField.setHorizontalAlignment(JTextField.CENTER);

        panel.add(inputNameLabel);
        panel.add(inputNameField);
    }

    private void intializeSubmit(){
        submitButton = new JButton("Start Game");
        submitButton.setBounds(401, 510, 300, 50);
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        panel.add(submitButton);
    }

    private void submitAction() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = inputNameField.getText().trim();

                if(playerName.isEmpty())
                    JOptionPane.showMessageDialog(inputNameField, "Please enter your name!", "Warning", JOptionPane.WARNING_MESSAGE);
                else
                    player.setName(playerName);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

}
