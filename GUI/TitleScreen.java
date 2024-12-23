package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Game.Player;

public class TitleScreen extends Screen {

    private JLabel levelLabel;
    private JLabel expLabel;
    private JLabel goldLabel;
    private JButton startButton;
    private JButton gachaButton;
    private JButton inventoryButton;
    private JButton exitButton;

    public TitleScreen(ScreenHandler screenHandler, Player player) {
        super(screenHandler);
        this.player = player;
        initialize();
        submitAction();
    }

    @Override
    protected void initialize() {
        super.initialize();

        levelLabel = addLabel("Level " + player.getLevel(), 601, 30, 92, 32, 24);
        expLabel = addLabel("Exp : " + player.getExp() + "/" + player.getMaxExp(), 743, 30, 150, 32, 24);
        goldLabel = addLabel("Gold : " + player.getGold(), 943, 30, 127, 32, 24);

        startButton = addButton("Start Battle", 301, 358, 500);
        gachaButton = addButton("Gacha", 301, 428, 500);
        inventoryButton = addButton("Inventory", 301, 498, 500);
        exitButton = addButton("Exit", 301, 568, 500);

        panel.add(addLabel("Stone War", 276, 100, 548, 160, 120));
        panel.add(addLabel("Name : " + player.getName(), 30, 30, 326, 32, 24));
        panel.add(levelLabel);
        panel.add(expLabel);
        panel.add(goldLabel);

        panel.add(startButton);
        panel.add(gachaButton);
        panel.add(inventoryButton);
        panel.add(exitButton);
    }

    @Override
    protected void submitAction() {
        super.submitAction();
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.addScreen("select", new SelectHeroScreen(screenHandler, player, soundRepository));
                screenHandler.switchScreen("select");
            }
        });

        gachaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.addScreen("soon", new ComingSoon(screenHandler));
                screenHandler.switchScreen("soon");
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.addScreen("soon", new ComingSoon(screenHandler));
                screenHandler.switchScreen("soon");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void onShow() {
        updatePlayerStats();
        soundRepository.getSound("titleScreen").loop();
    }

    private void updatePlayerStats() {
        levelLabel.setText("Level " + player.getLevel());
        expLabel.setText("Exp : " + player.getExp() + "/" + player.getMaxExp());
        goldLabel.setText("Gold : " + player.getGold());
    }

}
