package Game;

import java.awt.Image;

public class Character {
    
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
    private Image avatar;

    public Character(String name, int maxHp, int maxEnergy, int basicDamage, int skillDamage, int skillEnergy, int healingAmount, int healingEnergy, Image avatar) {
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

    public void reset() {
        currentHp = maxHp;
        currentEnergy = maxEnergy;
        isDefending = false;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Image getAvatar() {
        return avatar;
    }

}
