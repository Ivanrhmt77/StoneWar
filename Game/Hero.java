package Game;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hero {
    
    private String name;
    private int maxHp;
    private int currentHp;
    private int maxEnergy;
    private int currentEnergy;
    private int basicDamage;
    private int skillDamage;
    private int skillEnergy;
    private int healingAmount;
    private int healingEnergy;
    private boolean isDefending;
    private boolean isAlive;
    private ImageIcon avatar;

    public Hero(String name, int maxHp, int maxEnergy, int basicDamage, int skillDamage, int skillEnergy, int healingAmount, int healingEnergy, ImageIcon avatar) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
        this.basicDamage = basicDamage;
        this.skillDamage = skillDamage;
        this.skillEnergy = skillEnergy;
        this.healingAmount = healingAmount;
        this.healingEnergy = healingEnergy;
        this.isDefending = false;
        this.isAlive = true;
        this.avatar = avatar;
    }

    public int basicAttack() {
        return basicDamage;
    }

    public int useSkill() {
        currentEnergy -= skillEnergy;
        return skillDamage;
    }

    public void heal() {
        currentEnergy -= healingEnergy;

        if(currentHp + healingAmount > maxHp)
            currentHp = maxHp;
        else
            currentHp += healingAmount;
    }

    public void defend() {
        currentEnergy -= 15;
        isDefending = true;
    }

    public void takeDamage(int damage) {
        if(isDefending) {
            damage /= 2;
            isDefending = false;
        }

        currentHp -= damage;

        if(currentHp <= 0)
            isAlive = false;
    }

    public void regenerateEnergy() {
        if(currentEnergy < maxEnergy)
            currentEnergy += 5;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getSkillEnergy() {
        return skillEnergy;
    }

    public int getHealingEnergy() {
        return healingEnergy;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public int getSkillDamage() {
        return skillDamage;
    }

    public JPanel getAvatarPanel(int x, int y) {
        JLabel label = new JLabel(avatar);
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBackground(Color.BLACK);
        panel.setBounds(x, y, 200, 200);
        
        return panel;
    }

}
