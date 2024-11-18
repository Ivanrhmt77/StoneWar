package Game;

public class Player {
    
    private String name;
    private int level;
    private int exp;
    private int gold;

    public Player() {
        this.level = 1;
        this.exp = 0;
        this.gold = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
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

    public int getGold() {
        return gold;
    }

}
