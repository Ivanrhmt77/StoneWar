package GameSystem;

import javax.swing.JOptionPane;

import Game.Hero;

public class BattleSystem {

    private Hero hero;
    private Hero opponent;
    private int turn;

    public BattleSystem(Hero hero, Hero opponent) {
        this.hero = hero;
        this.opponent = opponent;
        this.turn = 1;
    }

    public boolean isEnoughEnergy(String action) {
        if(action.equalsIgnoreCase("skill"))
            return hero.getCurrentEnergy() >= hero.getSkillEnergy();
        if(action.equalsIgnoreCase("heal"))
            return hero.getCurrentEnergy() >= hero.getHealingEnergy();
        if(action.equalsIgnoreCase("defend"))
            return hero.getCurrentEnergy() >= 15;
        
        return true;
    }

    public boolean isFinished() {
        return !hero.isAlive() || !opponent.isAlive();
    }

    public boolean isWinning() {
        if (!opponent.isAlive())
            return true;

        return false;
    }    

    public void nextTurn() {
        turn++;
    }

    public void opponentTurn() {
        int damage = 0;
        int randomAction = (int) (Math.random() * 3);
        String actionMessage = "";
    
        switch(randomAction) {
            case 0:
                if(opponent.getCurrentEnergy() >= opponent.getSkillEnergy()) {
                    damage = opponent.getSkillDamage();
                    actionMessage = "Opponent used skill attack!";
                } else {
                    damage = opponent.getBasicDamage();
                    actionMessage = "Opponent used basic attack!";
                }
                break;
            case 1:
                if(opponent.getCurrentEnergy() >= 15) {
                    opponent.defend();
                    actionMessage = "Opponent is defending!";
                } else {
                    damage = opponent.getBasicDamage();
                    actionMessage = "Opponent used basic attack!";
                }
                break;
            case 2: 
                if(opponent.getCurrentHp() < opponent.getMaxHp() / 2 && opponent.getCurrentEnergy() >= opponent.getHealingEnergy()) {
                    opponent.heal();
                    actionMessage = "Opponent is healing!";
                } else {
                    damage = opponent.getBasicDamage();
                    actionMessage = "Opponent used basic attack!";
                }
                break;
        }
    
        hero.takeDamage(damage);
        JOptionPane.showMessageDialog(null, actionMessage + 
            "\nDamage received: " + damage + 
            "\nRemaining HP: " + hero.getCurrentHp(), 
            "Opponent's Turn", JOptionPane.INFORMATION_MESSAGE);
        
        hero.regenerateEnergy();
        opponent.regenerateEnergy();
    }

    public Hero getHero() {
        return hero;
    }

    public Hero getOpponent() {
        return opponent;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isPlayerTurn() {
        return turn % 2 != 0;
    }

}