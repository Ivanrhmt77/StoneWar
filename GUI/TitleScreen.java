package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Game.Hero;
import Game.Player;
import GameSystem.BattleSystem;
import Repository.HeroRepository;

public class TitleScreen extends Screen {

    private JLabel titleNameLabel;
    private JLabel playerNameLabel;
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

        titleNameLabel = addLabel("Stone War", 276, 100, 548, 160, 120);
        playerNameLabel = addLabel("Name : " + player.getName(), 30, 30, 326, 32, 24);
        levelLabel = addLabel("Level " + player.getLevel(), 601, 30, 92, 32, 24);
        expLabel = addLabel("Exp : " + player.getExp() + "/" + player.getMaxExp(), 743, 30, 150, 32, 24);
        goldLabel = addLabel("Gold : " + player.getGold(), 943, 30, 127, 32, 24);

        startButton = addButton("Start Battle", 301, 358, 500);
        gachaButton = addButton("Gacha", 301, 428, 500);
        inventoryButton = addButton("Inventory", 301, 498, 500);
        exitButton = addButton("Exit", 301, 568, 500);

        panel.add(titleNameLabel);
        panel.add(playerNameLabel);
        panel.add(levelLabel);
        panel.add(expLabel);
        panel.add(goldLabel);

        panel.add(startButton);
        panel.add(gachaButton);
        panel.add(inventoryButton);
        panel.add(exitButton);

        screenHandler.addScreen("soon", new ComingSoon(screenHandler));
    }

    @Override
    public void onShow() {
        updatePlayerStats();
        titleScreenBacksound.loop();
    }

    @Override
    protected void submitAction() {
        super.submitAction();
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroRepository heroManager = new HeroRepository();
                Hero hero1 = heroManager.getCharacterByName("Archer");
                Hero hero2 = heroManager.getCharacterByName("Knight");
                screenHandler.addScreen("battle", new BattleScreen(screenHandler, player, new BattleSystem(hero1, hero2)));
                screenHandler.switchScreen("battle");
                titleScreenBacksound.stop();
            }
        });

        gachaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.switchScreen("soon");
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private void updatePlayerStats() {
        levelLabel.setText("Level " + player.getLevel());
        expLabel.setText("Exp : " + player.getExp() + "/" + player.getMaxExp());
        goldLabel.setText("Gold : " + player.getGold());
    }

}
