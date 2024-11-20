package GameSystem;

import Game.Hero;

public class BattleSystem {

    private Hero myHero;
    private Hero opponent;

    public BattleSystem(Hero myHero, Hero opponent) {
        this.myHero = myHero;
        this.opponent = opponent;
    }

    public Hero getHero() {
        return myHero;
    }

    public Hero getOpponent() {
        return opponent;
    }

}