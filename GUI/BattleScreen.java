package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Game.Hero;
import Game.Player;
import GameSystem.BattleSystem;

public class BattleScreen extends Screen {

    private BattleSystem battleSystem;
    private JButton basicAttackButton;
    private JButton skillButton;
    private JButton healButton;
    private JButton defendButton;
    private JButton nextButton;
    private JLabel battleInfoLabel;
    private JLabel turnLabel;
    private JLabel heroHpLabel;
    private JLabel heroEnergyLabel;
    private JLabel opponentHpLabel;
    private JLabel opponentEnergyLabel;

    public BattleScreen(ScreenHandler screenHandler, Player player, BattleSystem battleSystem) {
        super(screenHandler);

        this.player = player;
        this.battleSystem = battleSystem;
        
        initialize();
        submitAction();
    }

    @Override
    protected void initialize() {
        super.initialize();

        basicAttackButton = addButton(battleSystem.getHero().getBasicDamage() + " ATK", 50, 618, 235);
        skillButton = addButton(battleSystem.getHero().getSkillDamage() + " ATK -" + battleSystem.getHero().getSkillEnergy() +" EP", 305, 618, 235);
        healButton = addButton(battleSystem.getHero().getHealingAmount() + " HP -" + battleSystem.getHero().getHealingEnergy() + " EP", 560, 618, 235);
        defendButton = addButton("DEFEND -15 EP", 815, 618, 235);
        nextButton = addButton("Next", 486, 340, 128);
        nextButton.setVisible(false);

        battleInfoLabel = addLabel("       Your Turn", 403, 540, 304, 40, 40);
        turnLabel = addLabel("Turn " + battleSystem.getTurn(), 499, 60, 130, 40, 40);

        panel.add(addLabel("Basic Attack", 116, 688, 108, 14, 20));
        panel.add(addLabel("Skill", 408, 688, 40, 14, 20));
        panel.add(addLabel("Heal", 663, 688, 41, 14, 20));
        panel.add(addLabel("Defend", 905, 688, 65, 14, 20));

        panel.add(basicAttackButton);
        panel.add(skillButton);
        panel.add(healButton);
        panel.add(defendButton);
        panel.add(nextButton);

        panel.add(battleInfoLabel);
        panel.add(turnLabel);

        panel.add(battleSystem.getHero().getAvatarPanel(168, 265));
        panel.add(battleSystem.getOpponent().getAvatarPanel(733, 265));

        heroStatsPanel(battleSystem.getHero(), 30, 30);
        heroStatsPanel(battleSystem.getOpponent(), 891, 30);
    }

    @Override
    protected void submitAction() {
        super.submitAction();

        basicAttackButton.addActionListener(createButtonAction("basic"));
        skillButton.addActionListener(createButtonAction("skill"));
        healButton.addActionListener(createButtonAction("heal"));
        defendButton.addActionListener(createButtonAction("defend"));
        nextButton.addActionListener(createButtonAction("next"));
    }

    @Override
    protected void onShow() {
        battleScreenBacksound.loop();
    }

    private ActionListener createButtonAction(String action) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (action) {
                    case "basic" -> battleSystem.getOpponent().takeDamage(battleSystem.getHero().basicAttack());
                    case "skill" -> battleSystem.getOpponent().takeDamage(battleSystem.getHero().useSkill());
                    case "heal" -> battleSystem.getHero().heal();
                    case "defend" -> battleSystem.getHero().defend();
                    case "next" -> battleSystem.opponentTurn();
                }                

                if(!battleSystem.isFinished()) {
                    battleSystem.nextTurn();
                }

                updateUI();
            }
        };
    }

    private void heroStatsPanel(Hero hero, int x, int y) {
        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(null);
        heroPanel.setBackground(Color.BLACK);
        heroPanel.setBounds(x, y, 179, 116);
        
        JLabel nameLabel = addLabel("Name : " + hero.getName(), 0, 0, 179, 32, 24);
        JLabel hpLabel = addLabel("HP : " + hero.getCurrentHp() + "/" + hero.getMaxHp(), 0, 42, 179, 32, 24);
        JLabel energyLabel = addLabel("Energy : " + hero.getCurrentEnergy() + "/" + hero.getMaxEnergy(), 0, 84, 179, 32, 24);

        if (hero == battleSystem.getHero()) {
            heroHpLabel = hpLabel;
            heroEnergyLabel = energyLabel;
        } else {
            opponentHpLabel = hpLabel;
            opponentEnergyLabel = energyLabel;
        }

        heroPanel.add(nameLabel);
        heroPanel.add(hpLabel);
        heroPanel.add(energyLabel);

        panel.add(heroPanel);
    }

    private void updateUI() {
        turnLabel.setText("Turn " + battleSystem.getTurn());
        battleInfoLabel.setText(battleSystem.isPlayerTurn() ? "       Your Turn" : "Opponent's Turn");

        updateLabel(heroHpLabel, heroEnergyLabel, battleSystem.getHero());
        updateLabel(opponentHpLabel, opponentEnergyLabel, battleSystem.getOpponent());

        basicAttackButton.setEnabled(battleSystem.isPlayerTurn() && battleSystem.isEnoughEnergy("basic"));
        skillButton.setEnabled(battleSystem.isPlayerTurn() && battleSystem.isEnoughEnergy("skill"));
        healButton.setEnabled(battleSystem.isPlayerTurn() && battleSystem.isEnoughEnergy("heal"));
        defendButton.setEnabled(battleSystem.isPlayerTurn() && battleSystem.isEnoughEnergy("defend"));
        nextButton.setVisible(!battleSystem.isPlayerTurn());
        
        if(battleSystem.isFinished())
            endBattle();
    }

    private void updateLabel(JLabel hpLabel, JLabel energyLabel, Hero hero) {
        hpLabel.setText("HP : " + hero.getCurrentHp() + "/" + hero.getMaxHp());
        hpLabel.setForeground(hero.getCurrentHp() <= 30 ? Color.RED : Color.WHITE);
        energyLabel.setText("Energy : " + hero.getCurrentEnergy() + "/" + hero.getMaxEnergy());
    }

    private void endBattle() {
        battleScreenBacksound.stop();
            
        if(battleSystem.isWinning()) {
            victorySound.play();
            JOptionPane.showMessageDialog(null, "Congratulations! You defeated the Opponent!", "Victory", JOptionPane.INFORMATION_MESSAGE);
            player.addExp(20);
            player.setGold(player.getGold() + 100);
        } else {
            defeatSound.play();
            JOptionPane.showMessageDialog(null, "You lost! Opponent wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            player.addExp(5);
        }
        
        screenHandler.switchScreen("title");
    }
    
}
