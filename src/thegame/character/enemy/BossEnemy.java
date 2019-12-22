package thegame.character.enemy;

/**
    extreme HP and ARMOR, low SPEED, extreme bounty
*/
public class BossEnemy extends Enemy {
    private static final int HP = 950;
    private static final int ARMOR = 28;
    private static final double SPEED = 0.5;
    private static final int BOUNTY = 70;
    private static final String PATH = "src/thegame/res/asset/enemy/bossEnemy.png";

    public BossEnemy() {
        super(HP, ARMOR, SPEED, BOUNTY, PATH);
    }
}
