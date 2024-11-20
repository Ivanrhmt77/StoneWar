package Game;

import javax.swing.JOptionPane;

public class Player {
    
    private String name;
    private int level;
    private int exp;
    private int maxExp;
    private int gold;

    public Player() {
        this.level = 1;
        this.exp = 0;
        this.maxExp = 50;
        this.gold = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addExp(int exp) {
        this.exp += exp;

        if(this.exp > maxExp)
            levelUp();
    }

    private void levelUp() {
        level++;
        exp -= maxExp;
        maxExp += 20;

        JOptionPane.showMessageDialog(
            null, 
            "Congratulations! You have leveled up to Level " + level + "!", 
            "Level Up", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public int getGold() {
        return gold;
    }

}
