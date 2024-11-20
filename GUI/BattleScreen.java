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
    private JLabel basicAttackLabel;
    private JLabel skillLabel;
    private JLabel healLabel;
    private JLabel defendLabel;
    private JButton basicAttackButton;
    private JButton skillButton;
    private JButton healButton;
    private JButton defendButton;
    private JLabel battleInfoLabel;
    private JLabel turnLabel;
    private JPanel heroAvatar;
    private JPanel opponentAvatar;
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

        basicAttackLabel = addLabel("Basic Attack", 116, 688, 108, 14, 20);
        skillLabel = addLabel("Skill", 408, 688, 40, 14, 20);
        healLabel = addLabel("Heal", 663, 688, 41, 14, 20);
        defendLabel = addLabel("Defend", 905, 688, 65, 14, 20);

        basicAttackButton = addButton(battleSystem.getHero().getBasicDamage() + " ATK", 50, 618, 235);
        skillButton = addButton(battleSystem.getHero().getSkillDamage() + " ATK -" + battleSystem.getHero().getSkillEnergy() +" EP", 305, 618, 235);
        healButton = addButton(battleSystem.getHero().getHealingAmount() + " HP -" + battleSystem.getHero().getHealingEnergy() + " EP", 560, 618, 235);
        defendButton = addButton("DEFEND -15 EP", 815, 618, 235);

        battleInfoLabel = addLabel("       Your Turn", 403, 540, 304, 40, 40);
        turnLabel = addLabel("Turn " + battleSystem.getTurn(), 499, 60, 130, 40, 40);

        heroAvatar = battleSystem.getHero().getAvatarPanel(168, 265);
        opponentAvatar = battleSystem.getOpponent().getAvatarPanel(733, 265);

        panel.add(basicAttackLabel);
        panel.add(skillLabel);
        panel.add(healLabel);
        panel.add(defendLabel);

        panel.add(basicAttackButton);
        panel.add(skillButton);
        panel.add(healButton);
        panel.add(defendButton);

        panel.add(battleInfoLabel);
        panel.add(turnLabel);

        panel.add(heroAvatar);
        panel.add(opponentAvatar);

        heroStatsPanel(battleSystem.getHero(), 30, 30);
        heroStatsPanel(battleSystem.getOpponent(), 891, 30);
    }

    @Override
    protected void submitAction() {
        super.submitAction();

        basicAttackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleSystem.getOpponent().takeDamage(battleSystem.getHero().basicAttack());
                if(!battleSystem.isFinished()) {
                    battleSystem.nextTurn();
                }
                updateUI();
            }
        });

        skillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleSystem.getOpponent().takeDamage(battleSystem.getHero().useSkill());
                if(!battleSystem.isFinished()) {
                    battleSystem.nextTurn();
                }
                updateUI();
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleSystem.getHero().heal();
                if(!battleSystem.isFinished()) {
                    battleSystem.nextTurn();
                }
                updateUI();
            }
        });

        defendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleSystem.getHero().defend();
                if(!battleSystem.isFinished()) {
                    battleSystem.nextTurn();
                }
                updateUI();
            }
        });
    }

    @Override
    public void onShow() {
        battleScreenBacksound.loop();
    }

    private void heroStatsPanel(Hero hero, int x, int y) {
        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(null);
        heroPanel.setBackground(Color.BLACK);
        heroPanel.setBounds(x, y, 179, 116);
        
        JLabel nameLabel = addLabel("Name : " + hero.getName(), 0, 0, 179, 32, 24);
        if (hero == battleSystem.getHero()) {
            heroHpLabel = addLabel("HP : " + hero.getCurrentHp() + "/" + hero.getMaxHp(), 0, 42, 179, 32, 24);
            heroEnergyLabel = addLabel("Energy : " + hero.getCurrentEnergy() + "/" + hero.getMaxEnergy(), 0, 84, 179, 32, 24);
            heroPanel.add(heroHpLabel);
            heroPanel.add(heroEnergyLabel);
        } else {
            opponentHpLabel = addLabel("HP : " + hero.getCurrentHp() + "/" + hero.getMaxHp(), 0, 42, 179, 32, 24);
            opponentEnergyLabel = addLabel("Energy : " + hero.getCurrentEnergy() + "/" + hero.getMaxEnergy(), 0, 84, 179, 32, 24);
            heroPanel.add(opponentHpLabel);
            heroPanel.add(opponentEnergyLabel);
        }

        heroPanel.add(nameLabel);
        panel.add(heroPanel);
    }

    private void updateUI() {
        turnLabel.setText("Turn " + battleSystem.getTurn());
        battleInfoLabel.setText(battleSystem.isPlayerTurn() ? "       Your Turn" : "Opponent's Turn");

        heroHpLabel.setText("HP : " + battleSystem.getHero().getCurrentHp() + "/" + battleSystem.getHero().getMaxHp());
        heroEnergyLabel.setText("Energy : " + battleSystem.getHero().getCurrentEnergy() + "/" + battleSystem.getHero().getMaxEnergy());
    
        opponentHpLabel.setText("HP : " + battleSystem.getOpponent().getCurrentHp() + "/" + battleSystem.getOpponent().getMaxHp());
        opponentEnergyLabel.setText("Energy : " + battleSystem.getOpponent().getCurrentEnergy() + "/" + battleSystem.getOpponent().getMaxEnergy());

        updateButton(skillButton, "skill");
        updateButton(healButton, "heal");
        updateButton(defendButton, "defend");
        
        if(battleSystem.isFinished()) {
            battleScreenBacksound.stop();
            
            if(battleSystem.isWinning()) {
                victorySound.play();
                JOptionPane.showMessageDialog(null, "Congratulations! You defeated the Opponent!", "Victory", JOptionPane.INFORMATION_MESSAGE);
            } else {
                defeatSound.play();
                JOptionPane.showMessageDialog(null, "You lost! Opponent wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
            
            screenHandler.switchScreen("title");
            victorySound.stop();
            defeatSound.stop();
        }
    }
    
    private void updateButton(JButton button, String action) {
        if(battleSystem.isEnoughEnergy(action))
            button.setEnabled(false);
        else
            button.setEnabled(true);
    }
    
}
