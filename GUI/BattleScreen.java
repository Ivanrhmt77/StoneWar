package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Game.Player;

public class BattleScreen extends Screen {

    private JButton basicAttackButton;
    private JButton skillButton;
    private JButton healButton;
    private JButton defendButton;

    public BattleScreen(ScreenHandler screenHandler, Player player) {
        super(screenHandler);
        this.player = player;
        initialize();
        submitAction();
    }

    @Override
    protected void initialize() {
        super.initialize();

        basicAttackButton = addButton("20 ATK", 50, 618, 235);
        skillButton = addButton("50 ATK -15 EP", 305, 618, 235);
        healButton = addButton("50 HP -15 EP", 560, 618, 235);
        defendButton = addButton("DEFEND -15 EP", 815, 618, 235);

        panel.add(basicAttackButton);
        panel.add(skillButton);
        panel.add(healButton);
        panel.add(defendButton);
    }

    @Override
    protected void submitAction() {
        super.submitAction();

        basicAttackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setGold(player.getGold() + 100);
                screenHandler.switchScreen("title");
                battleScreenBacksound.stop();
            }
        });
    }

    @Override
    public void onShow() {
        battleScreenBacksound.loop();
    }
    
}
